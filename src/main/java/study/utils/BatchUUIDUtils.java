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
    public void printUUIDBatch() {
        int max = 10;
        for (int i = 0; i < max; i++) {
            System.out.println(UUID.randomUUID());
        }
    }

    @Test
    public void writeUUID() throws IOException {
        int max = 43830;
        FileWriter fw = new FileWriter(new File("uuidResult.txt" ));
        for (int i = 0; i< max; i++){
            fw.write(UUID.randomUUID().toString()+"\r\n");
            fw.flush();
        }
        fw.close();
    }

}
