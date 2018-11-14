package study.baseTest;

import org.junit.Test;

/**
 * @authur sunjian.
 */
public class LongDoubleConvertTest
{
    @Test
    public void convertLongToDouble(){
        Long aLong = new Long(12312131);
        Double v = aLong.doubleValue();
        System.out.println(aLong);
        System.out.println(v);
    }


}
