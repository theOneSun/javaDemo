package study.baseTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author sunjian.
 */
public class CollectionsTest
{
    @Test
    public void testRemoveAll(){
        List<Integer> list = new ArrayList<>();
        for (int i=0;i<10;i++){
            list.add(i);
        }
        list.add(1);

        Set<Integer> set = new HashSet<>();
        for (int j=0;j<5;j++){
            set.add(j);
        }

        boolean b = list.removeAll(set);
        System.out.println(b);
        System.out.println(list);
    }

    @Test
    public void testAddAll(){
        List<Integer> list = new ArrayList<>();
        for (int i=0;i<10;i++){
            list.add(i);
        }
        list.add(1);

        Set<Integer> set = new HashSet<>();
        boolean b1 = set.addAll(list);

        System.out.println(b1);
        System.out.println(set);
        System.out.println(list);
    }

}
