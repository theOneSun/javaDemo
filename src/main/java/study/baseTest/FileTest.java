package study.baseTest;

import org.junit.Test;

import java.io.File;

/**
 * @authur sunjian.
 */
public class FileTest
{
    @Test
    public void testPath(){
        File file = new File("");
        System.out.println(file.getAbsolutePath());
        System.out.println("----");
        System.out.println(System.getProperty("user.dir"));
    }

    @Test
    public void  testFile(){
        File file = new File("asdas.txt");
    }
}
