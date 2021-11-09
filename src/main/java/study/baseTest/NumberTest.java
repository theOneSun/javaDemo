package study.baseTest;

import org.junit.Test;

/**
 * @author sunjian.
 */
public class NumberTest {
    @Test
    public void testLength(){
        Integer a = 123;
        Integer b = 123123;
        Long c = Long.valueOf("123123");
        System.out.println(String.valueOf(a).length());
        System.out.println(String.valueOf(b).length());
        System.out.println(String.valueOf(c).length());
    }
}
