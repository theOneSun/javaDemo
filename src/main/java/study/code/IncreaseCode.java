package study.code;

import org.junit.Test;

/**
 * @author sunjian.
 */
public class IncreaseCode {
    @Test
    public void testGenerateIncrease() {
        String prefix = "FP";
        String currentCode = "00000199";

        final Integer current = Integer.valueOf(currentCode);
        System.out.println("current int : " + current);
        final int now = current + 1;
        System.out.println("now int :" + now);

        final String nowStr = String.valueOf(now);
        System.out.println("now String :" + nowStr);

        System.out.println(String.format("%08d",now));

    }
}
