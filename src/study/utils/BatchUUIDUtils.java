package study.utils;

import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.UUID;

/**
 * @author sunjian.
 */
public class BatchUUIDUtils
{
    @Test
    public void productUUIDBatch() throws IOException
    {
//        int max = 290000;
        int max = 724193-580000;
//        int max = 94678;
//        System.out.println("-------------------");
        FileWriter fw = new FileWriter(new File("uuidResult.txt" ));
        String id;
        for (int i = 0; i< max; i++){
            id = UUID.randomUUID().toString().replaceAll("-", "");
            fw.write(id+"\r\n");
            fw.flush();
//            System.out.println(id);
        }
        fw.close();
    }

}
