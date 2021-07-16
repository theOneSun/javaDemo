package study.date;

import org.junit.Test;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author sunjian.
 */
public class DateTest
{
    @Test
    public void testPrintDate() throws Exception
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date(System.currentTimeMillis());
        System.out.println(date);
        System.out.println(sdf.format(date));
    }

    @Test
    public void testDateTime(){
        System.out.println(new Timestamp(System.currentTimeMillis()).toString());

    }

    @Test
    public void generateTimestamp() {
        System.out.println(System.currentTimeMillis());
        System.out.println(new Date().getTime());
        System.out.println(new Date().getTime() / 1000);
        System.out.println(Timestamp.valueOf(LocalDateTime.now()));
        final LocalDateTime startTime = LocalDate.now().withDayOfYear(1).atStartOfDay();
        System.out.println("startTime : " + startTime);
        System.out.println("startTime.toEpochSecond : "+ startTime.toEpochSecond(ZoneOffset.of("+8")));
        final Date date = new Date(2021,1,1,0,0,0);
        System.out.println("getTime: " + date.getTime());
        final GregorianCalendar calendar = new GregorianCalendar(2021, 1, 1, 0, 0, 0);
        System.out.println(calendar.getTimeInMillis()/1000);
    }

}
