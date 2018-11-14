package study.utils;

import org.junit.Test;

import java.util.UUID;

/**
 * @author sunjian.
 */
public class OrderCodeTest
{
    @Test
    public void testOrderCode()
    {
        int i = UUID.randomUUID().hashCode();
        int abs = Math.abs(i);
        System.out.println(i);
        System.out.println(abs);
    }

    /*private String getUUID(){

    }*/
}
