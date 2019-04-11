package study.date;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * @author sunjian.
 */
public class DateTest
{
    @Test
    public void testLocalDateTime()
    {
        System.out.println(LocalDateTime.now());
        LocalDateTime of = LocalDateTime.of(1993, 7, 12, 12, 12, 12);
        System.out.println(of);
        //        System.out.println(LocalDate.now());
        //        System.out.println(LocalDate.now());
    }

    /**
     * 测试时间加法
     */
    @Test
    public void testLocalDateTimeAdd()
    {
        System.out.println(LocalDateTime.now());
        LocalDateTime createTime = LocalDateTime.of(1993, 7, 12, 12, 12, 12);
        System.out.println(createTime);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format = dtf.format(LocalDateTime.now());
        System.out.println(format);

        //------------------
        LocalDateTime plus = createTime.plus(365, ChronoUnit.DAYS);
        System.out.println(plus);
    }

    @Test
    public void testTimestamp() throws Exception
    {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        System.out.println(System.currentTimeMillis());
    }

    @Test
    public void testPrintDate() throws Exception
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date(System.currentTimeMillis());
        System.out.println(date);
        System.out.println(sdf.format(date));
    }
}
