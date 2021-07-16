package study.utils;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author sunjian.
 */
public class MathUtils
{
    /**
     * 计算阶乘
     * @param a a的阶乘
     * @return a的阶乘
     */
    public static int factorial (int a){
        if (a>1){
            return a*factorial(a-1);
        }else{
            return a;
        }
    }

    //给一个集合返回排列组合的结果
    public static List<String> getSearchList(List<String> paramList){
        //参数集合去重
//        Set<String> paramSet = new HashSet<>();
        paramList = paramList.stream().distinct().collect(Collectors.toList());
        /*paramSet.addAll(paramList);
        paramList.addAll(paramSet);*/
        //--------------------

        List<String> resultList = new ArrayList<>();
        /*
        1,以每个关键字为key封装一个map,map的Value是出这个关键字的其它关键字的集合
        2,
         */
        int size = paramList.size();
        Map<String,List<String>> map = new HashMap<>();
        String currentKey;
        List<String> valueList;
        for (int i=0;i<size;i++){
            currentKey = paramList.get(i);
            valueList = new ArrayList<>();
            for (String tempParam : paramList)
            {
                if (!currentKey.equals(tempParam))
                {
                    valueList.add(tempParam);
                }
            }
            map.put(currentKey,valueList);
        }
        Set<Map.Entry<String, List<String>>> entrySet = map.entrySet();
        List<String> mapValueList;
        for (Map.Entry<String, List<String>> entry : entrySet)
        {
            mapValueList = entry.getValue();
            System.out.println(entry.getKey() + "---" + mapValueList);

            //--------------
            if (mapValueList.size() > 1)
            {
                getSearchList(mapValueList);
            }
        }


        return resultList;
    }

    @Test
    public void testGetMap(){
        String searchContent = "奇瑞 路虎 揽胜 路虎";

        String[] splitArray = searchContent.split(" ");
        List<String> list = Arrays.asList(splitArray);
        list.forEach(System.out::println);
        List<String> distinctList = list.stream().distinct().collect(Collectors.toList());
        Map<String, Object> resultMap = getResultMap(distinctList);
        Set<Map.Entry<String, Object>> entrySet = resultMap.entrySet();
        for (Map.Entry<String, Object> entry : entrySet)
        {
//            System.out.println(entry.getKey()+"-----"+entry.getValue());
            System.out.println(entry);
        }
    }

    public Map<String,Object> getResultMap(List<String> paramList)
    {
        //获取阶乘
        int factorial = factorial(paramList.size());//最后的list的长度为阶乘的值
        Map<String,Object> resultMap = new HashMap<>();
        /*
        1,以每个关键字为key封装一个map,map的Value是出这个关键字的其它关键字的集合
        2,
         */
        int size = paramList.size();
        Map<String,List<String>> map = new HashMap<>();
        String currentKey;
        List<String> valueList;
        for (int i=0;i<size;i++){
            currentKey = paramList.get(i);
            valueList = new ArrayList<>();
            for (String tempParam : paramList)
            {
                if (!currentKey.equals(tempParam))
                {
                    valueList.add(tempParam);
                }
            }
            map.put(currentKey,valueList);
        }
        Set<Map.Entry<String, List<String>>> entrySet = map.entrySet();
        List<String> mapValueList;
        for (Map.Entry<String, List<String>> entry : entrySet)
        {
            mapValueList = entry.getValue();
            System.out.println(entry.getKey() + "---" + mapValueList);

            //--------------
            if (mapValueList.size() > 1)
            {
                getSearchList(mapValueList);
            }
        }
        return resultMap;
    }

    public static Map<String,Object> getValueMap(List<String> valueList){
        Map<String,Object> map = new HashMap<>();
        int size = valueList.size();
        if (size>1){
//            getValueMap()
        }
        return null;
    }

    @Test
    public void name() {
        BigDecimal integral = new BigDecimal(20)//
                .add(new BigDecimal(20)
                             .multiply((new BigDecimal(3)))
                .divide(new BigDecimal(100), RoundingMode.HALF_UP));
        System.out.println(integral);
        System.out.println("intValue:" + integral.intValue());
        int addIntegral = Math.round(integral.floatValue());
        System.out.println(addIntegral);

        final BigDecimal bigDecimal = new BigDecimal(1.56);
        System.out.println(bigDecimal.intValue());
        System.out.println(bigDecimal.floatValue());
        System.out.println(bigDecimal.setScale(0, RoundingMode.HALF_UP).intValue());
    }
}
