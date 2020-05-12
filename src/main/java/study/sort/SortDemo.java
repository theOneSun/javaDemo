package study.sort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author sunjian.
 */
public class SortDemo {

    @Test
    public void testSort(){
        String a = "2019年第1季度";
        String b = "2019年第3季度";
        String c = "2019年第2季度";
        String d = "2019年第4季度";
        String e = "2019年第5季度";
        String f = "2019年第6季度";
        String g = "2019年第7季度";
        List<String> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        list.add(d);
        list.add(c);
        list.add(e);
        list.add(f);
        list.add(g);
        Collections.sort(list);
        System.out.println(list);
    }
}
