package study.baseConvert;

import com.sun.istack.internal.NotNull;
import org.junit.Test;

/**
 * Created by sunjian on 2017/6/2.
 */
public class CalculateTest
{
    @Test
    public void testIntAndDouble()
    {
        int a = 1;
        double b = 0.8;
        float f = 0.34343434f;
        double c = a + b;
        float af = a + f;
        System.out.println(c);
        System.out.println(af);
    }

    @Test
    public void testNullAnd()
    {
        String a = null;
        String b = "123";
        System.out.println(a + b);
    }
}
