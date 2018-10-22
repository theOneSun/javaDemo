package study.baseTest;

import org.junit.Test;

/**
 * @author sunjian.
 */
public class SystemTest
{
    @Test
    public void testSystemProperty(){
        System.out.println(System.getProperty("user.home"));
        System.out.println(System.getProperty("user.dir"));
    }
}
