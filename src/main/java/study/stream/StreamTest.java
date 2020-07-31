package study.stream;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author sunjian.
 */
public class StreamTest {

    @Test
    public void emptyForeach() {
        List<String> list = new ArrayList<>();
        list.forEach(System.out::println);
    }

    //测试将集合转成逗号分隔的字符串
    //用String.join就可以
    @Test
    public void convertStringSplitComma() {
        List<String> list = new ArrayList<>();
        list.add("hehe");
        list.add("haha");
        list.add("lala");
        list.add("yes");

        final String result = String.join(",", list);
        System.out.println(result);

        list.clear();
        final String clear = String.join(",", list);
        System.out.println("clear: " + clear);

        list = null;
        final String empty = String.join(",", list);
        System.out.println("empty: " + empty);
    }

    //测试分组并组内排序
    @Test
    public void testGroupSort() {
        //模拟数据
        Random random = new Random();
        List<Demo> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(new Demo(random.nextInt(5), random.nextInt(100)));
        }

        final Map<Integer, List<Demo>> map = list.stream()
                                                 .sorted(Comparator.comparing(Demo::getScore).reversed())
                                                 .collect(Collectors.groupingBy(Demo::getAge));

        for (Map.Entry<Integer, List<Demo>> entry: map.entrySet()){
            for (Demo demo : entry.getValue()) {
                System.out.println(entry.getKey()+"=====" +demo.getScore());
            }
        }

    }


    //测试有空值的toList
    @Test
    public void testToList(){
        List<Demo> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            list.add(new Demo(random.nextInt(20),i));
        }
        list.add(new Demo(18,null));
        final List<Integer> result = list.stream()
                                          .map(Demo::getScore)
                                          .collect(Collectors.toList());
        result.forEach(System.out::println);
    }

    //测试逗号分隔
    @Test
    public void testJoin(){
        Map<String, Boolean> map = new HashMap<>();
        map.put("补助退税", false);
        map.put("购物消费", false);
        map.put("婚恋交友", false);
        map.put("假冒身份", true);
        final String collect = map.entrySet()
                                  .stream()
                                  .filter(Map.Entry::getValue)
                                  .map(Map.Entry::getKey)
                                  .collect(Collectors.joining(","));
        System.out.println(collect);
        final String[] split = collect.split(",");
        System.out.println(Arrays.toString(split));
        System.out.println(split.length);
        final String[] strings = {};
        System.out.println(strings.length);
    }

    @Test
    public void toMapTest(){
        List<Demo> list = new ArrayList<>();
        list.add(new Demo(1,100));
        list.add(new Demo(2,67));
        list.add(new Demo(3,67));
        list.add(new Demo(1,56));
        final Map<Integer, Demo> collect = list.stream()
                                               .collect(Collectors.toMap(Demo::getAge, demo -> demo,(u,v)->u));
        collect.entrySet().forEach(System.out::println);
    }


    @AllArgsConstructor
    @Getter
    @ToString
    class Demo {
        private Integer age;
        private Integer score;
    }
}
