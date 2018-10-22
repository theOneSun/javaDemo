package study.baseTest;

import org.junit.Test;

/**
 * @author sunjian.
 */
public class StringBuilderTest
{
    @Test
    public void testDelete(){
        StringBuilder a = new StringBuilder("123,");
        a.delete(a.length()-1,a.length());
        System.out.println(a.toString());
    }
}
