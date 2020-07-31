package study.baseTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author sunjian.
 */
public class IteratorTest {
    @Test
    public void testAdd(){
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(String.valueOf(i));
        }

        final Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            final String s = iterator.next();
            System.out.println(s);
            if ("4".equals(s)){
                iterator.remove();
            }
        }

        list.forEach(System.out::println);
    }
}
