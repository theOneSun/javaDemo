package study.utils;

import org.junit.Test;

import java.util.UUID;

/**
 * @author sunjian.
 */
public class UUIDUtils
{
    public static String getUUID()
    {
        return UUID.randomUUID().toString().replaceAll("-","");
    }

    public static long numberCode() {
        final long hashCode = (Math.abs(uuid().hashCode()) + 1095_600_000_000L) + System.currentTimeMillis();

        return hashCode;
    }
    public static String uuid() {
        final StringBuilder sb = new StringBuilder(UUID.randomUUID().toString());
        sb.deleteCharAt(8);
        sb.deleteCharAt(12);
        sb.deleteCharAt(16);
        sb.deleteCharAt(20);
        return sb.toString();
    }

    @Test
    public void getCode() throws InterruptedException
    {
        long l = numberCode();
        System.out.println(l);
        Thread.sleep(5000);
        long l2 = numberCode();
        System.out.println(l2);
    }
}
