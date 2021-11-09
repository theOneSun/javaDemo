package study.math;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author sunjian.
 */
public class CalculateTest {


    //测试数差百分比
    @Test
    public void testDifferPercent(){
        int base = 1000;
        int real = 988;
        int real1 = 1046;
        final double r1 = differPercent(base, real);
        final double r2 = differPercent(base, real1);
        System.out.println(r1);
        System.out.println(r2);

        System.out.println(60 + r1 * 100);
        System.out.println(60 + r2 * 100);
    }

    public double differPercent(int base , int real){
        BigDecimal baseBg = new BigDecimal(base);
        BigDecimal realBg = new BigDecimal(real);
        final BigDecimal result = (realBg.subtract(baseBg)).divide(baseBg,2,BigDecimal.ROUND_DOWN);

        return result.doubleValue();
    }
}
