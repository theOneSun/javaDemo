package study.date;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author sunjian.
 */
public class CalendarTest {

    @Test
    public void testWeek(){
        Date now = new Date();
        final Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
//        calendar.setTime(now);
        calendar.set(Calendar.YEAR, 2021);
        calendar.set(Calendar.MONTH, 9);
        calendar.set(Calendar.DATE, 13);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(sdf.format(calendar.getTime()));
        System.out.println(calendar.get(Calendar.WEEK_OF_YEAR));
    }

    @Test
    public void testWeekToDate(){
        final Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.set(Calendar.YEAR, 2021);
        calendar.set(Calendar.WEEK_OF_YEAR, 1);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        System.out.println(calendar.getTime());
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        System.out.println(calendar.getTime());
    }

    @Test
    public void testStringSort() {
        String a = "2021-9";
        String b = "2021-8";
        String c = "2021-11";
        List<String> list = new LinkedList<>();
        list.add(a);
        list.add(b);
        list.add(c);
        final List<String> result = list.stream().sorted().collect(Collectors.toList());
        result.forEach(System.out::println);

        System.out.println("--------------");
        final List<String> sortedList = result.stream().sorted((o1, o2) -> {
            // 转成calendar比较
            final String[] yearWeekArray1 = o1.split("-");
            final int year1 = Integer.parseInt(yearWeekArray1[0]);
            final int week1 = Integer.parseInt(yearWeekArray1[1]);
            final Calendar calendar1 = Calendar.getInstance();
            calendar1.set(Calendar.YEAR, year1);
            calendar1.set(Calendar.WEEK_OF_YEAR, week1);

            final String[] yearWeekArray2 = o2.split("-");
            final int year2 = Integer.parseInt(yearWeekArray2[0]);
            final int week2 = Integer.parseInt(yearWeekArray2[1]);
            final Calendar calendar2 = Calendar.getInstance();
            calendar2.set(Calendar.YEAR, year2);
            calendar2.set(Calendar.WEEK_OF_YEAR, week2);
            if (calendar1.after(calendar2)){
                return 1;
            }else if (calendar1.before(calendar2)){
                return -1;
            }else {
                return 0;
            }
        }).collect(Collectors.toList());
        sortedList.forEach(System.out::println);
    }

    @Test
    public void testCompare() {
        final Calendar calendar1 = Calendar.getInstance();
        calendar1.set(Calendar.YEAR,2021);
        calendar1.set(Calendar.WEEK_OF_YEAR,9);
        final Calendar calendar2 = Calendar.getInstance();
        calendar2.set(Calendar.YEAR,2021);
        calendar2.set(Calendar.WEEK_OF_YEAR,8);
        final Calendar calendar3 = Calendar.getInstance();
        calendar3.set(Calendar.YEAR,2021);
        calendar3.set(Calendar.WEEK_OF_YEAR,11);

        System.out.println(calendar1.after(calendar2));
        System.out.println(calendar1.after(calendar3));
        System.out.println(calendar1.after(calendar1));
        System.out.println(calendar1.before(calendar1));
    }
}
