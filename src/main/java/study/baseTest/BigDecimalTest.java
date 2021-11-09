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

    //测试string构造
    @Test
    public void testConstructor(){
        String s = "0.01";
        double d = 0.01;
        System.out.println("new (string) : "+new BigDecimal(s));
        System.out.println("valueOf (double) : "+BigDecimal.valueOf(d));
        System.out.println("new (double) : "+new BigDecimal(d));
    }

    @Test
    public void testDivision(){
        int a=12;
        int b = 22;
        final BigDecimal ab = new BigDecimal(a);
        final BigDecimal bb = new BigDecimal(b);
        final BigDecimal result = ab.divide(bb, 4, BigDecimal.ROUND_HALF_UP);
        final double dv = result.doubleValue();
        System.out.println(result);
        System.out.println(dv);
    }

    @Test
    public void testToInteger(){
        final BigDecimal a = BigDecimal.valueOf(132);
        final BigDecimal b = BigDecimal.valueOf(132.8);
        System.out.println(a.intValue());
        System.out.println(b.intValue());

    }

    @Test
    public void testSetScale() {
        final BigDecimal bigDecimal = new BigDecimal("123.19237");
        final BigDecimal result = bigDecimal.setScale(0, BigDecimal.ROUND_HALF_UP);
        System.out.println(String.valueOf(result));
        final BigDecimal result2 = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
        System.out.println(String.valueOf(result2));
    }

    @Test
    public void testMultiply() {
        final BigDecimal bigDecimal = new BigDecimal("0.19237");
        final BigDecimal bigDecimal1 = new BigDecimal(100.23);
        System.out.println(bigDecimal.multiply(new BigDecimal("100")).setScale(-1,BigDecimal.ROUND_HALF_UP));
    }
}
