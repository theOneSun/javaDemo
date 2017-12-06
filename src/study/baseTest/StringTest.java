package study.baseTest;

import com.sun.org.apache.xpath.internal.SourceTree;
import org.junit.Test;
import study.utils.MathUtils;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @authur sunjian.
 */
public class StringTest
{
    @Test
    public void testSubString(){
        String value = "123.0.1";
        String substring = value.substring(0, value.indexOf("."));
        Integer integer = Integer.valueOf(substring);
        System.out.println(integer);
    }

    @Test
    public void getServicesName(){
        String name = "hotline_查看综合信息";
        String substring = name.substring(name.indexOf("_")+1, name.length());
        System.out.println(substring);
    }

    @Test
    public void testDecode() throws UnsupportedEncodingException
    {
        String param = "广州";
//        byte[] bytes = param.getBytes("iso-8859-1");
//        param = new String(param.getBytes(),"iso-8859-1");
//        param = new String(param.getBytes("iso-8859-1"),"UTF-8");
//        String result = new String(param.getBytes(), "utf-8");
//        System.out.println(result);
        param = new String(param.getBytes(),"iso-8859-1");

        String result = new String(param.getBytes("iso-8859-1"), "UTF-8");
        System.out.println(result);

    }

    @Test
    public void testJsonLength(){
        String jsonArray = "[\n" + "  {\n" + "    \"id\": \"706d1fe2a02049e1af19541f60936920\",\n" + "    \"city\": \"广州\",\n" + "    \"hundredIndexCount\": 18,\n" + "//    \"hundredRate\": 100.0,\n" + "    \"hundredIndexCountRank\": 1\n" + "  },\n" + "  {\n" + "    \"id\": \"55158daf28d74ced9fae722c003ba5d5\",\n" + "    \"city\": \"济南\",\n" + "    \"hundredIndexCount\": 18,\n" + "    \"hundredRate\": 100.0,\n" + "    \"hundredIndexCountRank\": 1\n" + "  },\n" + "  {\n" + "    \"id\": \"82b90f19a0fb4b23adf6940e43ef04bf\",\n" + "    \"city\": \"佛山\",\n" + "    \"hundredIndexCount\": 16,\n" + "    \"hundredRate\": 88.89,\n" + "    \"hundredIndexCountRank\": 3\n" + "  },\n" + "  {\n" + "    \"id\": \"a4f485f06297473da71dd5c5072d6912\",\n" + "    \"city\": \"乌海\",\n" + "    \"hundredIndexCount\": 16,\n" + "    \"hundredRate\": 88.89,\n" + "    \"hundredIndexCountRank\": 3\n" + "  }\n" + "]";
        int length = jsonArray.length();
        System.out.println(length);
    }

    @Test
    public void changeArea() throws Exception
    {
        /*
        带市的直接干掉市
        不是的进行判断
         */
        String paramArea = "北京市";

        if (paramArea.lastIndexOf("市") == (paramArea.length()-1)){
            paramArea = paramArea.replaceAll("市", "");
        }
        System.out.println(paramArea);
//        String area = null;
//        if (paramArea.contains("市")){
//            area = paramArea.replaceAll("市","");
//        }else if (paramArea.contains()){
//
//        }
//        System.out.println(area);

    }
    
    //测试按空格分组并组合

    @Test
    public void testGroupAndCombination() throws Exception
    {
        String searchContent = "奇瑞 路虎 揽胜 路虎";
        /*
        1,对字符创按照空格分组
        2,根据集合中的每个字符串进行顺序上的重新组合
         */
        String[] splitArray = searchContent.split(" ");
        List<String> list = Arrays.asList(splitArray);
        list.forEach(System.out::println);
        int size = list.size();
        int factorial = MathUtils.factorial(size);
        System.out.println("阶乘的结果:  " + factorial);

        //----
        List<String> resultList = new ArrayList<>();
        StringBuilder stringBuilder;
        for (int i=0;i<factorial;i++){
            stringBuilder = new StringBuilder("");
            for (int j=0;j<size;j++){
                if (j!=0){
                    stringBuilder.append("%");
                }
                stringBuilder.append(list.get(j));
            }
            resultList.add(stringBuilder.toString());
        }
        resultList.forEach(System.out::println);

        MathUtils.getSearchList(list);
    }

}
