package study.baseTest;

import org.junit.Test;

import java.text.DecimalFormat;

/**
 * @author sunjian.
 */
public class DoubleTest
{
    @Test
    public void testStringToDouble(){
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
        double v = Double.parseDouble(new DecimalFormat("#.##").format(1122.9182361*100));
        System.out.println(v+"%");
    }
}
