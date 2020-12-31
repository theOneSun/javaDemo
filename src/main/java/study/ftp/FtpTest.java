package study.ftp;

import cn.hutool.core.io.FileUtil;
import cn.hutool.extra.ftp.Ftp;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.junit.Test;
import study.poi.WordTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author sunjian.
 */
@SuppressWarnings("FieldCanBeLocal")
public class FtpTest {
    private final String host = "172.16.4.11";
    private final String username = "ftpuser";
    private final String password = "123456";


    @Test
    public void testFtp() throws IOException {
        //匿名登录（无需帐号密码的FTP服务器）
        Ftp ftp = initFtp();
        //进入远程目录
        //        final boolean cdResult = ftp.cd("D://ftpserver");
        //        System.out.println(cdResult);
        //上传本地文件
        //        ftp.upload("/opt/upload", FileUtil.file("e:/test.jpg"));

        //测试读取文件
        //        System.out.println(ftp.pwd());
        //        System.out.println(ftp.existFile("test.jpg"));//true

       /* String fileName = "会商数据.docx";
        System.out.println(ftp.existFile(fileName));

        final String fileNameGbk = new String(fileName.getBytes("GBK"), StandardCharsets.ISO_8859_1);
        System.out.println(ftp.existFile(fileNameGbk));

        final String fileNameUtf8 = new String(fileName.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);
        System.out.println(ftp.existFile(fileNameUtf8));

        final String encodeFileName = URLEncoder.encode(fileName);
        System.out.println(ftp.existFile(encodeFileName));*/

        //
        //        byte[] bytes = fileName.getBytes("GBK");
        //        InputStream fileStream = ftp.getClient().retrieveFileStream(new String(bytes, StandardCharsets.ISO_8859_1));
/*
        final FTPClient ftpClient = ftp.getClient();
        final FTPFile[] ftpFiles = ftpClient.listFiles();
        for (int i = ftpFiles.length - 1; i >= 0; i--) {
            System.out.println(ftpFiles[i]);
        }*/

        //------------------------------------------------------------
        /*String LOCAL_CHARSET= "GBK";
        String SERVER_CHARSET = "iso-8859-1";


        if (FTPReply.isPositiveCompletion(ftpClient.getReply())) {

            ftpClient.setControlEncoding(LOCAL_CHARSET);
            ftpClient.enterLocalPassiveMode();//设置被动模式
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);//设置传输模式
            if (FTPReply.isPositiveCompletion(
                    ftpClient.sendCommand("OPTS UTF8", "ON"))) {// 开启服务器对UTF-8的支持，如果服务器支持就用UTF-8编码，否则就使用本地编码（GBK）.
                LOCAL_CHARSET = "UTF-8";
            }
        }

        final String testFileName = new String(fileName.getBytes(LOCAL_CHARSET), StandardCharsets.ISO_8859_1);

        System.out.println("测试新方法:" +ftp.existFile(testFileName));*/

        //测试上传
        String name = "上传测试.docx";
        final String uName = new String(name.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);
        final boolean upload = ftp.upload("/upload", FileUtil.file(System.getProperty("user.dir") + "/上传测试.docx"));
        System.out.println(upload);//true

        //下载远程文件
        //        ftp.download("/", "会商数据.docx", FileUtil.file(System.getProperty("user.dir") + "/ftpDownload.docx"));
        //关闭连接
        ftp.close();
    }

    @Test
    //测试找出最新的文件
    public void testFindFile() throws IOException {
        //根据文件名称格式找出数字最大的
        final Ftp ftp = initCodedFtp();
        int max = 0;
        FTPFile targetFile = null;
        String  fileName = null;

        final List<FTPFile> ftpFileList = ftp.lsFiles("", ftpFile -> ftpFile.getName()
                                                                        .startsWith("会商数据") && ftpFile.getName()
                                                       .endsWith("会议摘要.docx"));
        for (FTPFile ftpFile: ftpFileList) {
            final String name = ftpFile.getName();
            final String substring = name.substring("会商数据".length());
            final String versionStr = substring.substring(0,substring.indexOf("会议摘要.docx"));
            final Integer version = Integer.valueOf(versionStr);
            if (version > max){
                max = version;
                targetFile = ftpFile;
                fileName = name;
            }
        }

        if (targetFile == null){
            throw new RuntimeException("没有符合命名标准的文件");
        }

        System.out.println(targetFile.getName());
        final String fileType = fileName.substring(fileName.lastIndexOf(".") + 1);
        System.out.println(String.format("后缀:%s", fileType));

        //todo 下載最新文件读取
        String downloadPath = System.getProperty("user.dir")+"/tempData.docx";
        final File tempFile = new File(downloadPath);
        ftp.download("/", targetFile.getName(), tempFile);

        final WordTest wordTest = new WordTest();
        System.out.println("文档内容: ");
        System.out.println(wordTest.readWord(downloadPath));

        final boolean delete = tempFile.delete();
        System.out.println(String.format("临时文件删除 : %b" , delete) );
        ftp.close();
    }

    @Test
    //测试下载
    public void testDownload() throws IOException {
        final Ftp ftp = initFtp();
        final FTPClient ftpClient = ftp.getClient();
        String LOCAL_CHARSET = "GBK";

        final int replyCode = ftpClient
                .getReplyCode();

        if (FTPReply.isPositiveCompletion(replyCode)){
            if (FTPReply.isPositiveCompletion(ftpClient.sendCommand("OPTS UTF8", "ON"))){
                LOCAL_CHARSET = "UTF-8";
            }
        }
        ftpClient.setControlEncoding(LOCAL_CHARSET);
        ftp.download("/上传测试.docx",new File(System.getProperty("user.dir")+"/下载的上传文件.docx"));
        ftp.close();
    }

    //初始化客户端
    private Ftp initFtp() {
        return new Ftp(host, 21, username, password);
    }

    /**
     * 初始化编码后的客户端对象
     */
    private Ftp initCodedFtp() throws IOException {
        final Ftp ftp = new Ftp(host, 21, username, password);
        final FTPClient ftpClient = ftp.getClient();
        String LOCAL_CHARSET = "GBK";
        final int replyCode = ftpClient
                .getReplyCode();
        System.out.println(replyCode);
        if (FTPReply.isPositiveCompletion(replyCode)){
            if (FTPReply.isPositiveCompletion(ftpClient.sendCommand("OPTS UTF8", "ON"))){
                LOCAL_CHARSET = "UTF-8";
            }
        }
        ftpClient.setControlEncoding(LOCAL_CHARSET);
        return ftp;
    }


    @Test
    //测试上传
    public void testUpload() throws IOException {
        final Ftp ftp = initFtp();
//        String fileName = "上传测试.docx";
        String fileName = "上传测试.docx";
        //测试上传
//        final boolean upload = ftp.upload("/upload", FileUtil.file(System.getProperty("user.dir") + "/" + fileName));
//        System.out.println("简单上传测试: " + upload);//true

        //解决中文乱码
//        final String uploadFileName = new String(fileName.getBytes("GBK"), StandardCharsets.ISO_8859_1);
//        final String uploadFileName = new String(fileName.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);
//        final String uploadFileName = new String(fileName.getBytes("GBK"), StandardCharsets.UTF_8);

        /*final FileInputStream fileInputStream = new FileInputStream(
                new File(System.getProperty("user.dir") + "/上传测试.docx"));
        final boolean upload1 = ftp.upload("/upload", uploadFileName, fileInputStream);
        System.out.println("中文乱码解决结果: " + upload1);*/

        //修改服务器配置测试  这个方法OK
        final FTPClient ftpClient = ftp.getClient();
        String LOCAL_CHARSET = "GBK";
        final int replyCode = ftpClient
                .getReplyCode();
        System.out.println(replyCode);
        if (FTPReply.isPositiveCompletion(replyCode)){
            if (FTPReply.isPositiveCompletion(ftpClient.sendCommand("OPTS UTF8", "ON"))){
                LOCAL_CHARSET = "UTF-8";
            }
        }
        ftpClient.setControlEncoding(LOCAL_CHARSET);
        /*final FileInputStream fileInputStream = new FileInputStream(
                new File(System.getProperty("user.dir") + "/上传测试.docx"));
        final boolean upload1 = ftp.upload("", fileName, fileInputStream);
        System.out.println("中文乱码解决结果: " + upload1);*/


        for (int i = 123; i < 126; i++) {
            final FileInputStream fileInputStream = new FileInputStream(
                    new File(System.getProperty("user.dir") + "/上传测试.docx"));
            final boolean upload1 = ftp.upload("", "会商数据"+i+"会议摘要.docx", fileInputStream);
            System.out.println(String.format("上传结果: %s", upload1));
        }
        ftp.close();
    }

    @Test
    public void testReplyCode() throws IOException {
        String local_charset = "utf-8";
        final Ftp ftp = initFtp();
        final FTPClient ftpClient = ftp.getClient();
        final int replyCode = ftpClient
                                       .getReplyCode();
        System.out.println(replyCode);
        if (FTPReply.isPositiveCompletion(replyCode)){
            if (FTPReply.isPositiveCompletion(ftpClient.sendCommand("OPTS UTF8", "ON"))){
                local_charset = "UTF-8";
            }
        }
        ftpClient.setControlEncoding(local_charset);
        ftp.close();
    }
}
