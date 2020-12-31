package study.date;

import org.junit.Test;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

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
}
