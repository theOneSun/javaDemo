package study.baseTest;

import org.junit.Test;

/**
 * @author sunjian.
 */
public class IntTest
{
    @Test
    public void testInt(){
        int a = (int) 1.99999;
        System.out.println(a);
    }

    @Test
    public void testDiscount() throws Exception
    {
        int price = 28900;
        int value = 85;
        float v = value / 100f;
        int discountPrice = (int) (price * v);
        System.out.println(discountPrice);
    }
}
