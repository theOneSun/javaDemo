package study.baseTest;

import org.junit.Test;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * @authur sunjian.
 */
public class IntegerToDoubleTest
{
    @Test
    public void testIntegerToDouble()
    {
        Integer integer = 1238;
        String intStr = integer.toString();
        double result = Double.parseDouble(intStr);

        System.out.println("result  " + result);

        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        String format = decimalFormat.format(result);
        System.out.println(format);
        Double formatDouble = Double.valueOf(format);
        System.out.println(formatDouble);
        //----------------------------------
        BigDecimal bigDecimal = new BigDecimal(result);
        double value = bigDecimal.setScale(0, BigDecimal.ROUND_HALF_UP).doubleValue();
        //double value = bigDecimal1.doubleValue();
        System.out.println("value:" + value);
    }

    @Test
    public void testSubstring()
    {
        String aaa = "123.0.0";
        int i = aaa.indexOf(".");
        String substring = aaa.substring(0, aaa.indexOf("."));
        System.out.println(substring);
        System.out.println(i);
    }

    @Test
    public void testDoubleToInt()
    {
        Double passMoney = 98.112;
        double v = passMoney * 100;
        int v1 = (int) v;
        System.out.println(v1);
    }
}
