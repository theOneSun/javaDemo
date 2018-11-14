package study.baseTest;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author sunjian.
 */
public class BigDecimalTest
{
    @Test
    public void firstTry(){
        BigDecimal a = new BigDecimal(10.23);
        BigDecimal b = new BigDecimal(3);
        BigDecimal multiply = a.multiply(b);
        System.out.println(multiply);
        Double c = 10.23;
        Double d = 3d;
        double v = c * d;
        System.out.println(v);
    }
}
