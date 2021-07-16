package study.baseTest;

import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;

import java.sql.Timestamp;
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
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import static java.time.DayOfWeek.MONDAY;
import static java.time.DayOfWeek.SUNDAY;

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
        final int lastDayMonth = now.getMonth().maxLength();
        System.out.println("当月最后一天: " + lastDayMonth);

        System.out.println("周" + now.getDayOfWeek().getValue());

        final LocalDateTime monday = now.minusDays(now.getDayOfWeek().getValue() - 1);
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
        final Instant instant = now.atZone(ZoneId.systemDefault()).toInstant();
        final long ldtResult = instant.toEpochMilli();
        System.out.println("ldtResult : " + ldtResult);
    }

    @Test
    public void testRandomLocalDateTime() {
        final LocalDateTime begin = LocalDateTime.of(2019, 11, 1, 0, 0, 0);
        final LocalDateTime end = LocalDateTime.of(2019, 11, 30, 0, 0, 0);
        final Instant instant = begin.atZone(ZoneId.systemDefault()).toInstant();
        final long beginLong = instant.toEpochMilli();

        final Instant endInstant = end.atZone(ZoneId.systemDefault()).toInstant();
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
        final long beginMilli = beginTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
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

        final Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
        final long l = instant.toEpochMilli();
        System.out.println("toEpochMilli : " + l);

        final LocalDateTime today = LocalDateTime.of(2019, 12, 3, 0, 0, 0);
        final long milli = today.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
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

        final List<LocalDateTime> result = list.stream().sorted().collect(Collectors.toList());
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
        System.out.println(YearMonth.now().minusMonths(1));
        System.out.println(YearMonth.now().minusMonths(7));

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
        System.out.println("本周一开始时间: " + localDateNow.with(MONDAY).atTime(LocalTime.MIN));
        System.out.println("本周日结束时间: " + localDateNow.with(DayOfWeek.SUNDAY).atTime(LocalTime.MAX));
        //本月
        System.out.println("本月1号开始时间: " + localDateNow.withDayOfMonth(1).atTime(LocalTime.MIN));
        System.out.println(
                "本月最后一天结束时间: " + localDateNow.withDayOfMonth(localDateNow.lengthOfMonth()).atTime(LocalTime.MAX));

        //本季度
        final int monthValue = localDateNow.getMonthValue();
        LocalDateTime seasonBeginTime;
        LocalDateTime seasonEndTime;
        if (monthValue < 4) {

            seasonBeginTime = LocalDate.of(localDateNow.getYear(), 1, 1).atStartOfDay();
            seasonEndTime = LocalDate.of(localDateNow.getYear(), 3, 31).atTime(LocalTime.MAX);

        } else if (monthValue < 7) {
            seasonBeginTime = LocalDate.of(localDateNow.getYear(), 4, 1).atStartOfDay();
            seasonEndTime = LocalDate.of(localDateNow.getYear(), 6, 30).atTime(LocalTime.MAX);
        } else if (monthValue < 10) {
            seasonBeginTime = LocalDate.of(localDateNow.getYear(), 7, 1).atStartOfDay();
            seasonEndTime = LocalDate.of(localDateNow.getYear(), 9, 30).atTime(LocalTime.MAX);
        } else {
            seasonBeginTime = LocalDate.of(localDateNow.getYear(), 10, 1).atStartOfDay();
            seasonEndTime = LocalDate.of(localDateNow.getYear(), 12, 31).atTime(LocalTime.MAX);
        }
        System.out.println("当前季度开始时间: " + seasonBeginTime);
        System.out.println("当前季度结束时间: " + seasonEndTime);

        //本年
        System.out.println("当年开始时间: " + localDateNow.withDayOfYear(1).atStartOfDay());
        System.out.println("当年结束时间: " + LocalDate.of(localDateNow.getYear(), 12, 31).atTime(LocalTime.MAX));
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
            list.add(beginTime.plus(i, ChronoUnit.DAYS).toLocalDate());
        }
        list.forEach(System.out::println);
    }

    @Test
    //测试减法
    public void testMinus() {
        final LocalDate now = LocalDate.now();
       /* System.out.println("begin " + now.minusWeeks(6));
        System.out.println("now " + now);
        final LocalDate last = now.plusDays(6);
        System.out.println(last);
        System.out.println(last.minusWeeks(6));*/

        //-------------开始日期
        final LocalDate temp = now.minusWeeks(6);
        System.out.println(temp.getDayOfWeek());
        final LocalDate with = temp.with(SUNDAY);
        System.out.println(with);

        final int monthValue = now.getMonthValue();
        LocalDate seasonEndDate;
        if (monthValue < 4) {
            seasonEndDate = LocalDate.of(now.getYear(), 3, 31);
        } else if (monthValue < 7) {
            seasonEndDate = LocalDate.of(now.getYear(), 6, 30);
        } else if (monthValue < 10) {
            seasonEndDate = LocalDate.of(now.getYear(), 9, 30);
        } else {
            seasonEndDate = LocalDate.of(now.getYear(), 12, 31);
        }


        System.out.println("本月最后一天: " + now.withDayOfMonth(now.lengthOfMonth()));
        System.out.println("七月前的第一天: " + now.withDayOfMonth(now.lengthOfMonth()).minusMonths(6).withDayOfMonth(1));

        System.out.println("季度最后一天: " + seasonEndDate);
        System.out.println("七个季度的第一天: " + seasonEndDate.minusMonths(20).withDayOfMonth(1));

        System.out.println("本年最后一天: " + now.withDayOfYear(now.lengthOfYear()));
        System.out.println("七年前第一天: " + now.withDayOfYear(now.lengthOfYear()).minusYears(6).withDayOfYear(1));

        System.out.println(LocalDate.now().minusMonths(11));
    }

    @Test
    public void groupByWeek() {
        final LocalDateTime now = LocalDateTime.now();
        Set<LocalDateTime> set = new LinkedHashSet<>();
        for (int i = 0; i < 30; i++) {
            set.add(now.minusDays(i).with(MONDAY));
        }

        //按周分组
        final List<LocalDateTime> collect = set.stream().sorted().collect(Collectors.toList());
        collect.forEach(System.out::println);
    }

    @Test
    public void periodUnit() {
        //周
        System.out.println("---------周begin----------");
        final LocalDate now = LocalDate.now();
        final LocalDate weekBegin = now.minusWeeks(6).with(MONDAY);
        //        final int until = (int) beginDate.until(endDate, ChronoUnit.DAYS);
        LocalDateTime[] rowArray = new LocalDateTime[7];
        for (int i = 0; i < 7; i++) {
            rowArray[i] = weekBegin.plus(i, ChronoUnit.WEEKS).atStartOfDay();
        }
        for (int i = 0; i < rowArray.length; i++) {
            System.out.println(rowArray[i]);
        }
        System.out.println("---------周end----------");
        System.out.println("---------月begin---------");
        final LocalDate monthBegin = now.minusMonths(6).withDayOfMonth(1);
        LocalDateTime[] monthArray = new LocalDateTime[7];
        for (int i = 0; i < 7; i++) {
            monthArray[i] = monthBegin.plus(i, ChronoUnit.MONTHS).atStartOfDay();
        }
        for (int i = 0; i < monthArray.length; i++) {
            System.out.println(monthArray[i]);
        }
        System.out.println("---------月end---------");
        System.out.println("---------季度begin---------");
        final LocalDate quarterBegin = now.minusMonths(20).withDayOfMonth(1);
        LocalDateTime[] quarterArray = new LocalDateTime[7];
        for (int i = 0; i < 7; i++) {
            quarterArray[i] = quarterBegin.plus(i * 3 - 1, ChronoUnit.MONTHS).atStartOfDay();
        }
        for (int i = 0; i < quarterArray.length; i++) {
            System.out.println(quarterArray[i]);
        }
        System.out.println("---------季度end---------");
        System.out.println("---------年begin---------");
        final LocalDate yearBegin = now.minusYears(6).withDayOfYear(1);
        LocalDateTime[] yearArray = new LocalDateTime[7];
        for (int i = 0; i < 7; i++) {
            yearArray[i] = yearBegin.plus(i, ChronoUnit.YEARS).atStartOfDay();
        }
        for (int i = 0; i < yearArray.length; i++) {
            System.out.println(yearArray[i]);
        }
        System.out.println("---------年end---------");
    }

    @Test
    //看看excel日期数字有bug的天数
    public void seeExcelBugDays() {
        final LocalDate baseDay = LocalDate.of(1900, 1, 1);
        System.out.println(baseDay.until(LocalDate.of(1900, 2, 28), ChronoUnit.DAYS));
        System.out.println(baseDay.plusDays(58));
    }

    @Test
    public void testMaxMin() {
        final LocalDateTime now = LocalDateTime.now();

        final LocalDateTime yearBegin = LocalDateTime.of(LocalDate.ofYearDay(now.getYear(), 1), LocalTime.MIN);
        final LocalDateTime yearEnd = LocalDateTime.of(
                LocalDate.ofYearDay(now.getYear() + 1, 1).minus(1, ChronoUnit.DAYS), LocalTime.MAX);

        final LocalDateTime dayBegin = LocalDateTime.of(now.toLocalDate(), LocalTime.MIN);
        final LocalDateTime dayEnd = LocalDateTime.of(now.toLocalDate(), LocalTime.MAX);

        System.out.println(String.format("yearBegin : %s", yearBegin));
        System.out.println(String.format("yearEnd : %s", yearEnd));
        System.out.println(String.format("dayBegin : %s", dayBegin));
        System.out.println(String.format("dayEnd : %s", dayEnd));

    }

    @Test
    public void localDatetimeConvertTimestamp() {
        final LocalDateTime now = LocalDateTime.now();
        System.out.println("now : " + now);
        final long currentTimeMillis = System.currentTimeMillis();
        final Timestamp timestamp = new Timestamp(currentTimeMillis);
        System.out.println("timestamp : " + timestamp);
        final LocalDateTime result = LocalDateTime.ofEpochSecond(currentTimeMillis / 1000, 0, ZoneOffset.ofHours(8));
        System.out.println("result : " + result);
    }

    @Test
    public void test229() {
        final LocalDate feb = LocalDate.of(2020, 2, 29);
        System.out.println(feb);
        System.out.println(feb.minusYears(1));
        final LocalDate march = LocalDate.of(2019, 3, 31);
        System.out.println(march.minusMonths(1));

    }

    @Test
    public void testMinusUntil() {
        final LocalDate now = LocalDate.now();
        final LocalDate begin = LocalDate.of(2020, 11, 25);
        final long until = begin.until(now, ChronoUnit.DAYS);

        System.out.println("间隔时间" + until);
        System.out.println("环比开始时间: " + begin.minusDays(until + 1));
        System.out.println("环比结束时间: " + now.minusDays(until + 1));
    }

    @Test
    //判断开始时间和结束时间是不是完整的一个月
    public void testJudgeWholeMonth() {
        final LocalDate nov1 = LocalDate.of(2020, 11, 1);
        final LocalDate nov30 = LocalDate.of(2020, 11, 30);
        final LocalDate nov29 = LocalDate.of(2020, 11, 29);
        final LocalDate dec1 = LocalDate.of(2020, 12, 1);
        final LocalDate dec2 = LocalDate.of(2020, 12, 2);
        //开始时间是结束时间的月初并且结束时间是开始时间的月末

        //开始时间的月末
        final LocalDate beginMonthLast = LocalDate.of(nov1.getYear(), nov1.getMonthValue(),
                                                      nov1.getMonth().maxLength());
        System.out.println(beginMonthLast);

        //结束时间的月初
        final LocalDate endMonthFirst = LocalDate.of(nov29.getYear(), nov29.getMonthValue(), 1);
        System.out.println(endMonthFirst);

        System.out.println("result : " + (nov1.isEqual(endMonthFirst) && nov29.isEqual(beginMonthLast)));
    }

    @Test
    public void firstDay() {
        System.out.println(LocalDate.now().with(TemporalAdjusters.firstDayOfMonth()));
        System.out.println(LocalDate.now().with(TemporalAdjusters.firstDayOfYear()));
    }

    @Test
    public void testSub() {
        final LocalDate now = LocalDate.now();
        System.out.println(now);
        System.out.println(now.toString().substring(5));
    }

    @Test
    public void testWith() {
        final LocalDateTime now = LocalDateTime.now();
        System.out.println("withMonth: " + now.withMonth(1));
        System.out.println("withDayOfYear: " + now.withDayOfYear(1));
        System.out.println("withDayOfMonth: " + now.withMonth(1).withDayOfMonth(1));
        System.out.println("withDayOfYear,with(): " + now.withDayOfYear(1).with(LocalTime.MIN));
    }

    @Test
    public void testMonthLast(){
        System.out.println(LocalDateTime.of(LocalDate.now().withDayOfMonth(1).minusDays(1), LocalTime.MAX));
        System.out.println(LocalDateTime.of(LocalDate.now().minusMonths(6).withDayOfMonth(1), LocalTime.MIN));
    }

}
