package study.calculate;

import org.junit.Test;

/**
 * @author sunjian.
 */
public class ModTest
{
    @Test
    public void testMod(){
        int i = 3912213 / 1000000;
        System.out.println(i);
    }

    @Test
    public void testRemainder(){
        int i = 1507138 % 200;
        System.out.println(i);
        int a = 12 % 2;
        System.out.println(a);
    }
}
