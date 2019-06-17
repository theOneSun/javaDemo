package study.baseTest;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

/**
 * @author sunjian.
 */
public class LocalDateTest {

    public void demo(){
        final LocalDate now = LocalDate.now();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
        simpleDateFormat.format(now);
    }
}
