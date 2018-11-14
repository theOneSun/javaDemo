package study.baseTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author sunjian.
 */
public class CharTest
{
    @Test
    public void testASCII()
    {
        String letter = "abcdefghijklmnopqrstuvwxyz";
        char c = letter.charAt(0);
        System.out.println(c);
        System.out.println((int) c);
        System.out.println((char) (c - 32));
    }

    @Test
    public void testSortASCII() throws Exception
    {
        List<String> list = new ArrayList<>();
        list.add("asd");
        list.add("1eq");
        list.add("asdfwd");
        list.add("12rr");
        list.add("2rfrg");
        list.add("bg44");
        list.add("安卓");
        list.add("苹果");
        list.add("安全");
        list.forEach(System.out::println);
        System.out.println("----------");
        Collections.sort(list);
        list.forEach(System.out::println);
    }

}
