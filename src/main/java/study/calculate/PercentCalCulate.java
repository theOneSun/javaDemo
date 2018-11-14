package study.calculate;

import org.junit.Test;

import java.text.DecimalFormat;

/**
 * @author sunjian.
 */
public class PercentCalCulate
{
    @Test
    public void testPercent(){
        int i = 1;
        int j = 19;
        //double result = i / j;
        double d1 = Double.parseDouble(i + "");
        double d2 = Double.parseDouble(j + "");
        double result = d1 / d2;
        DecimalFormat decimalFormat = new DecimalFormat("#0.00");
        String format = decimalFormat.format(result);
        System.out.println(result);
        System.out.println(format);
    }

    @Test
    public void testDoubleMultiplication(){
        double a = 0.56;
        double b = a*100;
        System.out.println(b);
        System.out.println("---------------------");
        int i = 1;
        int j = 19;
        //double result = i / j;
        double d1 = Double.parseDouble(i + "");
        double d2 = Double.parseDouble(j + "");
        double result = d1 / d2 * 100;
        DecimalFormat decimalFormat = new DecimalFormat("#0.00");
        String format = decimalFormat.format(result);
        System.out.println(result);
        System.out.println(format);
    }
}
