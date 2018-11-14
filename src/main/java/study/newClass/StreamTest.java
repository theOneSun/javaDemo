package study.newClass;

import com.sun.org.apache.xpath.internal.SourceTree;
import org.junit.Test;
import study.finalTest.Student;
import study.newClass.domain.AgeWrite;
import study.newClass.domain.IndicatorIndexScoreVO;
import sun.awt.SunHints;

import java.awt.geom.RoundRectangle2D;
import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @authur sunjian.
 */
public class StreamTest
{
    @Test
    public void testStreamNull() throws Exception
    {
        List<Student> studentList = new ArrayList<>();
        System.out.println(studentList.size());
        for (Student student : studentList)
        {
            System.out.println(student.getName() + "-----" + student.getNum());
        }
        studentList.add(new Student("amy", 1));
        studentList.add(new Student("amy", 2));
        studentList.add(new Student("bad", 3));
        studentList.add(new Student("bad", 4));
        Map<String, Integer> collect = studentList.stream()
                                                  .collect(Collectors.groupingBy(Student::getName,
                                                                                 Collectors.summingInt(Student::getNum)));
        Set<Map.Entry<String, Integer>> entrySet = collect.entrySet();
        for (Map.Entry<String, Integer> entry : entrySet)
        {
            System.out.println(entry.getKey() + "=========" + entry.getValue());
        }
    }

    @Test
    public void testDistinct() throws Exception
    {
        List<AgeWrite> ageWriteList = new ArrayList<>();
        for (int i = 0; i < 5; i++)
        {
            ageWriteList.add(new AgeWrite(i + "", "123", "1", 2.3));
        }
        for (int i = 5; i < 10; i++)
        {
            ageWriteList.add(new AgeWrite(i + "", "abc", "1", 2.3));
        }
        for (int i = 10; i < 15; i++)
        {
            ageWriteList.add(new AgeWrite(i + "", "o1h23", "1", 2.3));
        }
        for (int i = 15; i < 20; i++)
        {
            ageWriteList.add(new AgeWrite(i + "", "abdi12", "1", 2.3));
        }
        //------------------------------------------
        List<String> businessIdList = new ArrayList<>();
        Set<String> businessIdSet = new HashSet<>();
        ageWriteList.stream().distinct().forEach(ageWrite -> businessIdSet.add(ageWrite.getBusinessId()));
        System.out.println(businessIdSet);
    }

    @Test
    public void testGroupingBy()
    {
        List<AgeWrite> ageWriteList = new ArrayList<>();
        for (int i = 0; i < 5; i++)
        {
            ageWriteList.add(new AgeWrite(i + "", "123", "1", 2.3));
        }
        for (int i = 5; i < 10; i++)
        {
            ageWriteList.add(new AgeWrite(i + "", "abc", "1", 2.3));
        }
        for (int i = 10; i < 15; i++)
        {
            ageWriteList.add(new AgeWrite(i + "", "o1h23", "1", 2.3));
        }
        for (int i = 15; i < 20; i++)
        {
            ageWriteList.add(new AgeWrite(i + "", "abdi12", "1", 2.3));
        }
        ageWriteList.add(new AgeWrite("123", "Abc", "1", 2.3));
        ageWriteList.add(new AgeWrite("123", "ABc", "1", 2.3));
        ageWriteList.add(new AgeWrite("123", "AbC", "1", 2.3));

        //------------------------------------------
        List<AgeWrite> repeatList = new ArrayList<>();
        Map<String, List<AgeWrite>> collect = ageWriteList.stream()
                                                          .collect(Collectors.groupingBy(AgeWrite::getBusinessId));
        Set<Map.Entry<String, List<AgeWrite>>> entrySet = collect.entrySet();
        for (Map.Entry entry : entrySet)
        {
            List<AgeWrite> valueList = (List<AgeWrite>) entry.getValue();
            if (valueList.size() > 1)
            {
                repeatList.addAll(valueList);
            }
        }
        System.out.println("结果集合长度:  " + repeatList.size());
        for (AgeWrite agewrite : repeatList)
        {
            System.out.println(agewrite);
        }
    }

    @Test
    public void sortRank() throws Exception
    {
        Random random = new Random();
        List<IndicatorIndexScoreVO> indicatorIndexScoreVOList = new ArrayList<>();
        List<IndicatorIndexScoreVO> resultList = new ArrayList<>();
        String city = "北京";
        YearMonth yearMonth1 = YearMonth.of(2016, 1);
        YearMonth yearMonth2 = YearMonth.of(2016, 2);
        YearMonth yearMonth3 = YearMonth.of(2016, 3);
        for (int i = 0; i < 50; i++)
        {
            indicatorIndexScoreVOList.add(new IndicatorIndexScoreVO(city + i,
                                                                    new BigDecimal(random.nextInt(100)),
                                                                    yearMonth1));
        }
        for (int i = 0; i < 50; i++)
        {
            indicatorIndexScoreVOList.add(new IndicatorIndexScoreVO(city + i,
                                                                    new BigDecimal(random.nextInt(100)),
                                                                    yearMonth2));
        }
        for (int i = 0; i < 50; i++)
        {
            indicatorIndexScoreVOList.add(new IndicatorIndexScoreVO(city + i,
                                                                    new BigDecimal(random.nextInt(100)),
                                                                    yearMonth3));
        }
        //-----------数据准备完毕
        Map<YearMonth, List<IndicatorIndexScoreVO>> map = indicatorIndexScoreVOList.stream()
                                                                                   .collect(Collectors.groupingBy(
                                                                                           IndicatorIndexScoreVO::getDataTime));

        Set<Map.Entry<YearMonth, List<IndicatorIndexScoreVO>>> entrySet = map.entrySet();
        for (Map.Entry entry : entrySet)
        {
            List<IndicatorIndexScoreVO> listByDate = (List<IndicatorIndexScoreVO>) entry.getValue();
            List<IndicatorIndexScoreVO> sortedList = listByDate.stream()
                                                               .sorted(Comparator.comparing(IndicatorIndexScoreVO::getIndexScore)
                                                                                 .reversed())
                                                               .collect(Collectors.toList());
            int rank = 0;//set排名使用
            int count = 1;//计数使用
            BigDecimal lastScore = new BigDecimal(-1);
            BigDecimal currentScore;
            for (IndicatorIndexScoreVO indicator : sortedList)
            {
                currentScore = indicator.getIndexScore();
                if (currentScore.compareTo(lastScore) != 0)
                {
                    rank = count;
                    indicator.setRank(rank);
                } else
                {
                    indicator.setRank(rank);
                }
                lastScore = currentScore;
                count++;
            }
            resultList.addAll(sortedList);
        }
        System.out.println(resultList);
    }

    @Test
    public void testAvg()
    {
        List<Double> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++)
        {
            double round = Math.round(random.nextDouble() * 100);
            System.out.println(round);
            list.add(round);
        }

        //求平均值
        Double avg = list.stream().collect(Collectors.averagingDouble(Double::doubleValue));
        System.out.println(avg);
    }

    @Test
    public void testSubPage()
    {
        int pageSize = 15;
        int pageNumber = 2;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 100; i++)
        {
            list.add("第" + i + "条数据");
        }
        final List<String> resultList = list.stream()
                                            .skip((pageNumber - 1) * pageSize)
                                            .limit(pageSize)
                                            .collect(Collectors.toList());
        resultList.forEach(System.out::println);
    }
}
