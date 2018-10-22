package study.baseTest;

import com.sun.org.apache.xpath.internal.SourceTree;
import org.junit.Test;
import study.idata3dsimulate.normal.ElectronicSpecialInvoice;
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
        String substring1 = value.substring(0, value.length());
        System.out.println(substring1);
        System.out.println(value);
        System.out.println("---"+value.substring(1,value.length()));
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

    /**
     * 测试根据下划线截取并删除第一个下划线之前的内容
     */
    @Test
    public void testSplitAndRemove() throws Exception
    {
        String fileName = "123123123_啦啦啦_123.pdf";
        int i = fileName.indexOf("_");
        System.out.println(i);
        String substring = fileName.substring(i+1, fileName.length());
        System.out.println(substring);
    }

    @Test
    public void testSubStringRankChange() throws Exception
    {
//        String change = "+123";
        String change = "-1";
//        String change = "-";

        String status = change.substring(0, 1);

        if ("+".equals(status))
        {
            // 上升
            System.out.println("上升" + change.substring(1, change.length()));
        } else if ("-".equals(status))
        {
            if (change.length() > 1)
            {
                //下降
                System.out.println("下降" + change.substring(1, change.length()));
            } else if (change.length() == 1)
            {
                // 无变化
                System.out.println("无变化");
            } else
            {
                System.out.println("异常1");
            }
        } else
        {
            System.out.println("异常2");
        }
    }

    @Test
    public void testSplit(){
        String a = "123123";
        String[] split = a.split(",");
        for (String b : split)
        {
            System.out.println(b);
        }
    }
    @Test
    public void testDeleteLast(){
        String a = "123123,123,";
        if (a.lastIndexOf(",") == a.length() -1){
            System.out.println("aaa");
        }
    }
    @Test
    public void testIndexOf(){
        String a = "123123";
        int i = a.lastIndexOf(",");
        System.out.println(i);
    }

    @Test
    //测试大小写
    public void testCase(){
        String a = "SELECT * FROM project_data WHERE";
        System.out.println(a.contains("where"));
    }
}
