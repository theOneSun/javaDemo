package study.baseTest;

import org.junit.Test;
import study.baseTest.domain.Student;

import java.util.HashSet;
import java.util.Set;

/**
 * @author sunjian.
 */
public class SetTest
{
    @Test
    public void testRemoveAll() throws Exception{
        Set<Student> insertSet = new HashSet<>();
        Set<Student> hasSet = new HashSet<>();
        for (int i=0;i<10;i++){
            insertSet.add(new Student(i,"小明",null));
        }
        for (int i=0;i<15;i++){
            hasSet.add(new Student(i,"小明",null));
        }
        insertSet.removeAll(hasSet);
        System.out.println(insertSet.size());
    }
}
