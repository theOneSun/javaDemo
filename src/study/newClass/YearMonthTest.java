package study.newClass;

import org.junit.Test;

import java.time.Month;
import java.time.YearMonth;

/**
 * Created by sunjian.
 */
public class YearMonthTest
{
    @Test
    public void testYearMonth() throws Exception
    {
        YearMonth now = YearMonth.now();
        System.out.println(now);
        /*YearMonth of = YearMonth.of(2017, 1);
        System.out.println(of);
        YearMonth parse = YearMonth.parse("2017-11");
        System.out.println(parse);

        Month month = now.getMonth();
        System.out.println(month);

        //获取年
        int year = now.getYear();
        System.out.println(year);
        YearMonth begin = YearMonth.of(now.getYear(), 1);
        System.out.println(begin);*/

        //获取当年一月
       /* YearMonth yearMonth = now.minusMonths(now.getMonth().getValue() - 1);
        System.out.println(yearMonth);

        YearMonth firstMonth = now.minusMonths(now.getMonthValue() - 1);
        System.out.println(firstMonth);*/
        //去年同期
        /*YearMonth pastMonth = now.minusYears(1);
        System.out.println(pastMonth);*/
        //当年一月
        YearMonth of = YearMonth.of(2017, 1);
        YearMonth firstMonth = of.minusMonths(of.getMonth().getValue() - 1);
        System.out.println(firstMonth);
        //过去12个月
        /*YearMonth twelveMonthAgo = now.minusMonths(11);
        System.out.println(twelveMonthAgo);*/
        //System.out.println(now.minusYears(1).equals(pastMonth) );
    }

    @Test
    public void testPrint() throws Exception
    {
        YearMonth now = YearMonth.now();
        YearMonth yearMonth = now.minusMonths(11);
        System.out.println(yearMonth);
    }

    @Test
    public void testBetween() throws Exception
    {
        YearMonth yearMonth;
        yearMonth = YearMonth.of(2016, 12);
        System.out.println(yearMonth.isAfter(YearMonth.of(2014, 12)) && yearMonth.isBefore(YearMonth.of(2017, 1)));

        yearMonth = YearMonth.of(2015, 1);
        System.out.println(yearMonth.isAfter(YearMonth.of(2014, 12)) && yearMonth.isBefore(YearMonth.of(2017, 1)));

        yearMonth = YearMonth.of(2014, 12);
        System.out.println(yearMonth.isAfter(YearMonth.of(2014, 12)) && yearMonth.isBefore(YearMonth.of(2017, 1)));

        yearMonth = YearMonth.of(2017, 1);
        System.out.println(yearMonth.isAfter(YearMonth.of(2014, 12)) && yearMonth.isBefore(YearMonth.of(2017, 1)));
    }
}
