package study.baseTest;

import org.junit.Test;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @authur sunjian.
 */
public class TimeStampTest
{
    @Test
    public void testTimeStamp(){
        Timestamp timestamp = Timestamp.valueOf("2016-01-01 12:12:12");
        System.out.println(timestamp);
    }

    @Test
    public void testStringToTimeStamp() throws ParseException
    {
        String date = "2017061716";
        DateFormat readFormat = new SimpleDateFormat("yyyyMMddHH");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date1 = new Date(System.currentTimeMillis());
        String format1 = dateFormat.format(date1);
        System.out.println(format1);
        //-------------------------
        Date parse = readFormat.parse(date);
        String format = dateFormat.format(parse);
        Timestamp timestamp = Timestamp.valueOf(format);
        System.out.println("timeStamp:  " + timestamp);
        System.out.println(format);
    }
}
