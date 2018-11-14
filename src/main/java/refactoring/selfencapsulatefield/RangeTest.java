package refactoring.selfencapsulatefield;

import org.junit.Test;

/**
 * @author sunjian.
 */
public class RangeTest
{
    @Test
    public void testGetHigh()
    {
        CappedRange cappedRange = new CappedRange(1, 8, 10);
        final int high = cappedRange.getHigh();
        System.out.println(high);
    }
}
