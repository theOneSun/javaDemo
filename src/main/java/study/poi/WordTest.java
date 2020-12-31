package study.poi;

import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.ooxml.POIXMLDocument;
import org.apache.poi.ooxml.extractor.POIXMLTextExtractor;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;

import java.io.FileInputStream;

/**
 * @author sunjian.
 */
public class WordTest {
    public static void main(String[] args) {
        WordTest tp = new WordTest();
        //.docx和doc文件的读取
        final String filePath = System.getProperty("user.dir") + "/上传测试.docx";
        String content = tp.readWord(filePath);
        System.out.println("content====" + content);
    }

    /**
     * 读取word文件内容
     *
     * @param path
     * @return buffer
     */
    public String readWord(String path) {
        String buffer = "";
        try {
            if (path.endsWith(".doc")) {
                FileInputStream is = new FileInputStream(path);
                WordExtractor ex = new WordExtractor(is);
                buffer = ex.getText();
                is.close();
            } else if (path.endsWith("docx")) {
                OPCPackage opcPackage = POIXMLDocument.openPackage(path);
                XWPFWordExtractor extractor = new XWPFWordExtractor(opcPackage);
                buffer = extractor.getText();
                opcPackage.close();
            } else {
                System.out.println("此文件不是word文件！");
                throw new UnsupportedOperationException("unsupported fileType " + path.substring(path.lastIndexOf(".") + 1));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return buffer;
    }
}