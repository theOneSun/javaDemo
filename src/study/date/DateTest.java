package study.date;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
}
