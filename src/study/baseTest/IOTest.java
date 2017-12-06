package study.baseTest;

import org.junit.Test;
import study.baseTest.domain.Student;

import javax.swing.text.StyledEditorKit;
import javax.xml.crypto.Data;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @authur sunjian.
 */
public class IOTest
{
    @Test
    public void printToTxt() throws IOException
    {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(123, "呵呵", "男"));
        studentList.add(new Student(231, "哈哈", "男"));
        studentList.add(new Student(321, "嘿嘿", "男"));

        Map<String, List<Student>> resultMap = new HashMap<>();
        resultMap.put("插入的数据", studentList);
        //File file = new File("/src/resultMap.txt");
        FileWriter fileWriter = new FileWriter("resultMap.txt");

        BufferedWriter bw = new BufferedWriter(fileWriter);

        Set<Map.Entry<String, List<Student>>> entrySet = resultMap.entrySet();

//        for (Map.Entry entry : entrySet)
//        {
//            bw.write(entry.getKey() + "===" + entry.getValue());
//        }
        bw.write(resultMap.toString());
        bw.flush();
        bw.close();
    }


    @Test
    public void testCreateFile() throws IOException
    {
        String property = System.getProperty("user.dir");
        System.out.println(property);

        DateFormat dft = new SimpleDateFormat("yyyy_MM_dd");
        long l = System.currentTimeMillis();
        Date date = new Date(l);
        String format = dft.format(date);
        File file = new File(property + "/导入数据结果" + format);
        boolean mkdir = file.mkdir();
        System.out.println(mkdir);
    }
}
