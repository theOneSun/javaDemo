package study.baseTest;

import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author sunjian.
 */
public class TimeTest {
    @Test
    public void test() {
        TimeZone tz1 = TimeZone.getTimeZone("Asia/Shanghai");
        TimeZone tz2 = TimeZone.getTimeZone("UTC");
        final Date nowDate = Date.from(Instant.now());
        System.out.println("nowDate: " + nowDate);
        System.out.println("Asia/Shanghai: "+getISO8601Timestamp(nowDate, tz1));
        System.out.println("UTC: "+getISO8601Timestamp(nowDate, tz2));
    }

    private static String getISO8601Timestamp(Date date, TimeZone tz){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        df.setTimeZone(tz);
        return df.format(date);
    }


}
