package study.baseTest;

import org.junit.Test;
import study.baseTest.domain.Student;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author sunjian.
 */
public class SetTest {
    @Test
    public void testRemoveAll() throws Exception {
        Set<Student> insertSet = new HashSet<>();
        Set<Student> hasSet = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            insertSet.add(new Student(i, "小明", null));
        }
        for (int i = 0; i < 15; i++) {
            hasSet.add(new Student(i, "小明", null));
        }
        insertSet.removeAll(hasSet);
        System.out.println(insertSet.size());
    }

    @Test
    public void testAddAgain() {
        Set<Student> set = new LinkedHashSet<>();
        Student a = new Student(1, "小明", "男");
        Student b = new Student(2, "小明", "男");
        Student c = new Student(2, "小明", "男");
        System.out.println(b.equals(c));
        set.add(a);
        set.add(b);
        final boolean addCResult = set.add(c);
        System.out.println("添加结果:" + addCResult);
        final boolean remove = set.remove(c);
        System.out.println("删除结果: "+ remove);
        set.forEach(System.out::println);
    }
}
