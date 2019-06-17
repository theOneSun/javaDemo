package study.baseTest;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * @author sunjian.
 */
public class DoubleTest
{
    @Test
    public void testStringToDouble()
    {
        String a = "49.332145691";
        double d = Double.parseDouble(a);
        System.out.println(d);
    }

    @Test
    public void testOne() throws Exception
    {
        Double d = 202.9999999997;
        //        Double d = 0D;

        DecimalFormat df = new DecimalFormat("#.#");
        String format1 = df.format(d);
        System.out.println(format1);
    }

    @Test
    public void remain4() throws Exception
    {
        double v = Double.parseDouble(new DecimalFormat("#.##").format(1122.9182361 * 100));
        System.out.println(v + "%");
    }


    @Test
    public void remain2()
    {
        Double a = 123.0003918237;
        Double b = 123.0153918237;
        //        System.out.println(Math.round(a * 100) / 100);

        DecimalFormat df = new DecimalFormat("#.00");
        DecimalFormat df2 = new DecimalFormat("#.##");
        long start = System.currentTimeMillis();
        System.out.println(Double.valueOf(df.format(a)));
        System.out.println(df2.format(a));
        System.out.println(df.format(a));
        System.out.println("format耗时:" + (System.currentTimeMillis() - start));

        long start2 = System.currentTimeMillis();
        BigDecimal bg = new BigDecimal(b);

        double f1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println(Double.valueOf(f1));
        System.out.println("bigDecimal耗时:" + (System.currentTimeMillis() - start2));

    }

    @Test
    public void remain()
    {
        Double a = 123.0153918237;
        Double b = 12.3;
        int c = 12;
        System.out.println(a / b);
        System.out.println(a / c);
    }

    @Test
    public void showLastZero()
    {
        double a = 98.90;
        System.out.println(a);
    }

    //测试"#.00"和"0.00"的区别
    @Test
    public void remain0point0()
    {
        Double b = 0d;

        DecimalFormat df = new DecimalFormat("#.00");
        DecimalFormat df2 = new DecimalFormat("0.00");

        System.out.println(df.format(b));
        System.out.println(df2.format(b));
    }

    //测试保留整数转int
    @Test
    public void convertInt()
    {
        Double b = 0d;

        DecimalFormat df = new DecimalFormat("#");

        final BigDecimal bigDecimal = new BigDecimal(b);
        final BigDecimal result = bigDecimal.setScale(0, RoundingMode.HALF_UP);
        System.out.println(result);
        final Double bd = Double.valueOf(String.valueOf(result));
        System.out.println("bigdecimal->double"+bd);
        System.out.println(Integer.valueOf(String.valueOf(result)));

        System.out.println(df.format(b));
        System.out.println(Integer.valueOf(df.format(b)));
    }

    //测试double转string
    @Test
    public void testToString(){
        /*double d = 19d;
        System.out.println(String.valueOf(d));
        System.out.println(String.valueOf((long) d));*/

        double d2 = -19.9;
        final long round = Math.round(d2);
        if (round-d2==0){
            System.out.println((long) d2);
        }else
        {
            System.out.println(d2);
        }

    }
}
