package study.io;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author sunjian.
 */
public class ReadTest
{
    @Test
    public void testWrite() throws IOException
    {
        File file1 = new File("uuidResult.txt");
        File file2 = new File("uuidResult2.txt");
        OutputStream out = null;
        InputStream in = new FileInputStream(file1);
        FileOutputStream outputStream = new FileOutputStream(file2);

//        byte[] bytes = new byte[512];
//        int read = 0;
//        StringBuffer sb = new StringBuffer();
//        while ((read = in.read(bytes)) != -1)
//        {
//            sb.append(new String(bytes, 0, read));
//        }
//        System.out.println("a");
//        InputStream inputStream = new ByteArrayInputStream(sb.toString().getBytes());
//        byte[] re = new byte[1024];
//        int haveRead = 0;
//        FileOutputStream fileOutputStream = new FileOutputStream(file2);
//        while ((haveRead = inputStream.read(re)) != -1)
//        {
//            fileOutputStream.write(re, 0, haveRead);
//        }
        //-----------------
        int b = 0;
        final byte[] buffer = new byte[512];
//        b = in.read(buffer);
        while ((b= in.read(buffer)) != -1)
        {
            outputStream.write(buffer, 0, b);
        }
        in.close();
        outputStream.flush();
        outputStream.close();
        //-------------
    }

}
