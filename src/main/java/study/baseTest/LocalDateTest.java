package study.baseTest;

import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @author sunjian.
 */
public class LocalDateTest {

    public void demo() {
        final LocalDate now = LocalDate.now();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
        simpleDateFormat.format(now);
    }

    @Test
    public void testLocalDateTime() {
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
    public void testLocalDateTimeAdd() {
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
    public void testTimestamp() throws Exception {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        System.out.println(System.currentTimeMillis());
    }

    @Test
    public void testPrintCurrentMillis() {
        System.out.println(System.currentTimeMillis());
    }

    @Test
    public void testCreate() {
        final LocalDateTime now = LocalDateTime.now();
        System.out.println("now: " + now);
        final LocalDateTime plusMonths = now.plusMonths(1);
        System.out.println("plus month: " + plusMonths);
        final LocalDateTime withHour = now.withHour(1);
        System.out.println("with hour : " + withHour);

        final LocalDate nowLocalData = LocalDate.now();
        System.out.println("now localdata : " + nowLocalData);

        final LocalDate month1day = LocalDate.of(now.getYear(), now.getMonth(), 1);
        System.out.println("当月第一天 : " + month1day);
        final int lastDayMonth = now.getMonth()
                                    .maxLength();
        System.out.println("当月最后一天: " + lastDayMonth);

        System.out.println("周" + now.getDayOfWeek()
                                    .getValue());

        final LocalDateTime monday = now.minusDays(now.getDayOfWeek()
                                                      .getValue() - 1);
        System.out.println("周一:" + monday);

    }

    @Test
    public void testTimestampConvert() {
        final long currentTimeMillis = System.currentTimeMillis();
        final LocalDateTime zone = LocalDateTime.ofEpochSecond(currentTimeMillis / 1000, 0, ZoneOffset.ofHours(8));
        System.out.println(zone);

        //        final LocalDateTime mills = LocalDateTime.ofEpochSecond(currentTimeMillis / 1000);
    }

    @Test
    public void testAfterBefore() {
        final LocalDateTime createdTime = LocalDateTime.of(2019, 10, 15, 11, 0, 0);
        System.out.println("创建时间 : " + createdTime);
        final LocalDateTime now = LocalDateTime.now();
        System.out.println("now : " + now);
        final LocalDateTime yesterday = now.minusDays(1);
        System.out.println("now-1天 : " + yesterday);
        if (createdTime.isBefore(now) && createdTime.isAfter(yesterday)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }

    @Test
    public void testConvertLong() {
        final long currentTimeMillis = System.currentTimeMillis();
        System.out.println("---long to LocalDateTime---");
        System.out.println("currentTimeMillis:" + currentTimeMillis);
        //        System.out.println(Instant.now().equals(Instant.ofEpochMilli(currentTimeMillis)));
        final LocalDateTime longResult = LocalDateTime.ofInstant(Instant.ofEpochMilli(currentTimeMillis),
                                                                 ZoneId.systemDefault());
        System.out.println("convert result : " + longResult);
        System.out.println("---end---");
        System.out.println("---LocalDateTime to long---");
        final LocalDateTime now = LocalDateTime.now();
        System.out.println("localDateTime now : " + now);
        final Instant instant = now.atZone(ZoneId.systemDefault())
                                   .toInstant();
        final long ldtResult = instant.toEpochMilli();
        System.out.println("ldtResult : " + ldtResult);
    }

    @Test
    public void testRandomLocalDateTime() {
        final LocalDateTime begin = LocalDateTime.of(2019, 11, 1, 0, 0, 0);
        final LocalDateTime end = LocalDateTime.of(2019, 11, 30, 0, 0, 0);
        final Instant instant = begin.atZone(ZoneId.systemDefault())
                                     .toInstant();
        final long beginLong = instant.toEpochMilli();

        final Instant endInstant = end.atZone(ZoneId.systemDefault())
                                      .toInstant();
        final long endLong = endInstant.toEpochMilli();

        System.out.println("begin Long : " + beginLong);
        System.out.println("end Long : " + endLong);

        final long randomLong = RandomUtils.nextLong(beginLong, endLong);
        System.out.println("生成的long: " + randomLong);

        final LocalDateTime longResult = LocalDateTime.ofInstant(Instant.ofEpochMilli(randomLong),
                                                                 ZoneId.systemDefault());

        System.out.println("convert LocalDateTime :" + longResult);
    }

    @Test
    public void testWorkTime() {
        final LocalDateTime beginTime = LocalDateTime.of(2019, 12, 1, 9, 0, 0);
        final long beginMilli = beginTime.atZone(ZoneId.systemDefault())
                                         .toInstant()
                                         .toEpochMilli();
        Random random = new Random();
        final int day = random.nextInt(10);
        final int randomMillis = random.nextInt(1000);
        //        System.out.println("random day : " + day);
        final int second = random.nextInt(9 * 60 * 60);
        //        final int second = 28800;
        final long result = beginMilli + second * 1000 + randomMillis;
        final LocalDateTime longResult = LocalDateTime.ofInstant(Instant.ofEpochMilli(result), ZoneId.systemDefault());
        System.out.println(longResult);
    }

    @Test
    public void printTemp() {
        for (int i = 0; i < 20; i++) {
            testWorkTime();
            //            System.out.println(RandomUtils.nextInt(9, 18));
        }
    }

    @Test
    public void testLocalDateConvertLong() {
        System.out.println("----测试localDate转毫秒值----------");
        final LocalDate localDate = LocalDate.of(2019, 12, 3);
        final LocalDateTime localDateTime = localDate.atStartOfDay();
        System.out.println("atStartOfDay : " + localDateTime);

        final Instant instant = localDateTime.atZone(ZoneId.systemDefault())
                                             .toInstant();
        final long l = instant.toEpochMilli();
        System.out.println("toEpochMilli : " + l);

        final LocalDateTime today = LocalDateTime.of(2019, 12, 3, 0, 0, 0);
        final long milli = today.atZone(ZoneId.systemDefault())
                                .toInstant()
                                .toEpochMilli();
        System.out.println("toEpochMilli: " + milli);
        /*final long l1 = System.currentTimeMillis();
        System.out.println("currentTimeMillis : " + l1);*/
    }

    @Test
    public void testAtTime() {
        final LocalDate localDate = LocalDate.of(2019, 12, 31);
        final LocalDateTime localDateTime = localDate.atTime(9, 0, 1);
        System.out.println(localDateTime);
    }

    @Test
    public void testGenerateLocalDateTime() {
        Random random = new Random();
        final LocalDateTime beginTime = LocalDateTime.of(2019, 12, 30, 9, 0, 0);
        final int day = random.nextInt(10);
        final int hour = random.nextInt(9);
        final int minute = random.nextInt(60);
        final int second = random.nextInt(60);
        final int milli = random.nextInt(1000);
        final LocalDateTime plus = beginTime.plusDays(day)
                                            .plusHours(hour)
                                            .plusMinutes(minute)
                                            .plusSeconds(second)
                                            .plus(milli, ChronoUnit.MILLIS);
        System.out.println(plus);
    }

    @Test
    public void testDuration() {
        final Duration between = Duration.between(LocalDateTime.now(), LocalDateTime.of(2020, 1, 31, 9, 0, 31));
        System.out.println("days: " + between.toDays());
        System.out.println("hour: " + between.toHours());
        System.out.println("minutes: " + between.toMinutes());
        System.out.println("seconds: " + between.toMillis());

        System.out.println("-----test period-----");

        final LocalDate now = LocalDate.now();
        final LocalDate of = LocalDate.of(2020, 1, 31);
        final Period period = Period.between(now, of);
        System.out.println("days: " + period.getDays());
        System.out.println("month: " + period.getMonths());
        System.out.println(" unit days : " + period.get(ChronoUnit.DAYS));
        final LocalDate localDate = now.plusDays(period.getDays());
        System.out.println("plus result : " + localDate);
        System.out.println(of.equals(localDate));

    }

    @Test
    public void testSort() {
        List<LocalDateTime> list = new ArrayList<>();
        final LocalDateTime now = LocalDateTime.now();
        list.add(now);
        list.add(now.plusDays(3));
        list.add(now.minusDays(1));
        list.add(now.plusMinutes(23));
        list.add(now.minusMonths(3));
        list.add(now.minusHours(5));

        final List<LocalDateTime> result = list.stream()
                                               .sorted()
                                               .collect(Collectors.toList());
        result.forEach(System.out::println);
    }

    @Test
    public void testUntil() {
        final LocalDate now = LocalDate.now();
        final LocalDate of = LocalDate.of(2020, 1, 10);
        final long until = now.until(of, ChronoUnit.DAYS);
        System.out.println(until);

        final LocalDateTime timeNow = LocalDateTime.now();
        final LocalDateTime timeOf = LocalDateTime.of(2020, 4, 12, 0, 20, 33);
        final long timeUntil = timeOf.until(timeNow, ChronoUnit.SECONDS);
        System.out.println(timeUntil);
    }

    @Test
    public void testYearMonth() {
        System.out.println(YearMonth.now());
        System.out.println(YearMonth.now()
                                    .minusMonths(1));
        System.out.println(YearMonth.now()
                                    .minusMonths(7));

    }

    //测试两个yearMonth之间月份遍历
    @Test
    public void testLoopBetweenYearMonth() {
        final YearMonth beginYearMonth = YearMonth.of(2019, 5);
        final YearMonth now = YearMonth.now();

        final long until = beginYearMonth.until(now, ChronoUnit.MONTHS);
        System.out.println("两个年月的差距: " + until);

        for (int i = 0; i <= until; i++) {
            final YearMonth yearMonth = beginYearMonth.plusMonths(i);
            System.out.println("当前年月:" + yearMonth);
        }
    }

    //测试yearMonth作为map的key
    @Test
    public void testMap() {
        final YearMonth beginYearMonth = YearMonth.of(2019, 5);
        final YearMonth now = YearMonth.now();
        Map<YearMonth, Integer> map = new HashMap<>();
        map.put(beginYearMonth, 10);
        map.put(now, 12);

        System.out.println(map.get(YearMonth.of(2020, 3)));
        Map<String, Integer> sMap = new HashMap<>();
        sMap.put("2019-01", 10);
        sMap.put("2020-03", 12);
        System.out.println(sMap.get(now.toString()));
    }

    @Test
    public void testCompare() {
        final LocalDateTime now = LocalDateTime.now();
        final LocalDateTime tomorrow = now.plusDays(1);
        System.out.println(now.isAfter(tomorrow));
        System.out.println(now.isAfter(null));

    }

    //测试时间段
    @Test
    public void testPeriod() {
        final LocalDate localDateNow = LocalDate.now();

        //当天
        System.out.println("当天开始时间: " + localDateNow.atStartOfDay());
        System.out.println("当天结束时间: " + localDateNow.atTime(LocalTime.MAX));

        //本周
        System.out.println("本周一开始时间: " + localDateNow.with(DayOfWeek.MONDAY)
                                                     .atTime(LocalTime.MIN));
        System.out.println("本周日结束时间: " + localDateNow.with(DayOfWeek.SUNDAY)
                                                     .atTime(LocalTime.MAX));
        //本月
        System.out.println("本月1号开始时间: " + localDateNow.withDayOfMonth(1)
                                                      .atTime(LocalTime.MIN));
        System.out.println("本月最后一天结束时间: " + localDateNow.withDayOfMonth(localDateNow.lengthOfMonth())
                                                        .atTime(LocalTime.MAX));

        //本季度
        final int monthValue = localDateNow.getMonthValue();
        LocalDateTime seasonBeginTime;
        LocalDateTime seasonEndTime;
        if (monthValue < 4) {

            seasonBeginTime = LocalDate.of(localDateNow.getYear(), 1, 1)
                                       .atStartOfDay();
            seasonEndTime = LocalDate.of(localDateNow.getYear(), 3, 31)
                                     .atTime(LocalTime.MAX);

        } else if (monthValue < 7) {
            seasonBeginTime = LocalDate.of(localDateNow.getYear(), 4, 1)
                                       .atStartOfDay();
            seasonEndTime = LocalDate.of(localDateNow.getYear(), 6, 30)
                                     .atTime(LocalTime.MAX);
        } else if (monthValue < 10) {
            seasonBeginTime = LocalDate.of(localDateNow.getYear(), 7, 1)
                                       .atStartOfDay();
            seasonEndTime = LocalDate.of(localDateNow.getYear(), 9, 30)
                                     .atTime(LocalTime.MAX);
        } else {
            seasonBeginTime = LocalDate.of(localDateNow.getYear(), 10, 1)
                                       .atStartOfDay();
            seasonEndTime = LocalDate.of(localDateNow.getYear(), 12, 31)
                                     .atTime(LocalTime.MAX);
        }
        System.out.println("当前季度开始时间: " + seasonBeginTime);
        System.out.println("当前季度结束时间: " + seasonEndTime);

        //本年
        System.out.println("当年开始时间: " + localDateNow.withDayOfYear(1)
                                                    .atStartOfDay());
        System.out.println("当年结束时间: " + LocalDate.of(localDateNow.getYear(),12,31)
                                                    .atTime(LocalTime.MAX));
    }

    @Test
    public void testPeriodList() {
        final LocalDateTime now = LocalDateTime.now();
        System.out.println("now: " + now);
        final LocalDateTime beginTime = now.minusDays(6);
        System.out.println("begin: " + beginTime);
        List<LocalDate> list = new ArrayList<>();
        final int until = (int) beginTime.until(now, ChronoUnit.DAYS);
        for (int i = 0; i < until + 1; i++) {
            list.add(beginTime.plus(i, ChronoUnit.DAYS)
                              .toLocalDate());
        }
        list.forEach(System.out::println);

    }
}
