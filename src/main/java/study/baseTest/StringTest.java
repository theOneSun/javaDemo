package study.baseTest;

import com.sun.org.apache.xpath.internal.SourceTree;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import study.idata3dsimulate.normal.ElectronicSpecialInvoice;
import study.utils.MathUtils;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
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

        System.out.println(LocalDate.now()
                                    .toString().substring(0,7));
    }

    @Test
    public void testPoliceSubString() {
        String police = "长兴测试派出所";
        String area2 = "长兴县";

        if (police.startsWith(area2)) {
            police = police.substring(area2.length());
            System.out.println(police);
        }

        if (police.endsWith("派出所")) {
            police = police.substring(1, police.length() - "派出所".length());
            System.out.println(police);
        }
        System.out.println(police);
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
        /*if (a.lastIndexOf(",") == a.length() -1){
            System.out.println("aaa");
        }*/
        StringBuilder sb = new StringBuilder(a);
        sb.deleteCharAt(a.lastIndexOf(","));
        System.out.println(sb.toString());
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

    @Test
    public void testJoin(){
        String delimiter = ",";
        String a = "";
        String b = null;
        String c = "cdb123";
        String d = "cdb000";

        System.out.println("a,d : " + String.join(delimiter,a,d));
        System.out.println("b,d : " + String.join(delimiter,b,d));
        System.out.println("c,d : " + String.join(delimiter,c,d));

        System.out.println(StringUtils.isEmpty(a));
        System.out.println(StringUtils.isEmpty(b));
        System.out.println("--------测试null拼接---------");
        System.out.println(StringUtils.join(new String[]{b,d}, ","));
        System.out.println(StringUtils.joinWith(",", (Object[]) new String[]{b, d}));



    }

    @Test
    public void testLoopJoin(){
        String delimiter = ",";
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        final String join = String.join(delimiter, list);
        System.out.println(join);
        final String[] objects = list.toArray(new String[0]);
        System.out.println(Arrays.toString(objects));

        /*for (int i = 0; i < 3; i++) {
            String.join()
        }*/
        String result = "";
        for (String s : list) {
            result = String.join(",", result, s);
        }
        System.out.println("result : "+result);
    }

    @Test
    public void testValueOfDouble(){
        Double d = 0.0000089798712312;
        System.out.println(String.valueOf(d));
        BigDecimal bg = new BigDecimal("0.00000");
        System.out.println(bg.toString());
        DecimalFormat df = new DecimalFormat("#.######");

        System.out.println("df: "+df.format(d));

        System.out.println("--------");

        NumberFormat nf = NumberFormat.getInstance();
        nf.setGroupingUsed(false);
        System.out.println(nf.format(d));
    }

    @Test
    public void testValueOfDoubleRound(){
        Double d = 0.0000089798712312;
        DecimalFormat df = new DecimalFormat("#.######");
        System.out.println("df: "+df.format(d));
    }

    @Test
    public void testReplace(){
        String idCard = "21111019901221001X";
        StringBuilder sb = new StringBuilder(idCard);
        sb.replace(14,18,"****");
        System.out.println(sb.toString());
    }

    @Test
    public void testSensitive(){
        String name = "薰悟空";
        String idNumber = "330108199901011234";
        String mobile = "13155556666";
        String tel = "88889999";
        System.out.println("name = " + desensitization(name));
        System.out.println("idNumber = " + desensitization(6,idNumber,idNumber.length()-6));
        System.out.println("mobile = " + desensitization(1,mobile,10));
        System.out.println("tel = " + desensitization(1,tel,tel.length()-1));
    }

    //脱敏处理,只保留第一位
    private String desensitization(String original){

        return desensitization(1,original);
    }
    private String desensitization(int start,String original){
        return desensitization(1,original,1);
    }
    private String desensitization(int start,String original,int number){
        StringBuilder star = new StringBuilder();
        for (int i = 0; i < number; i++) {
            star.append("*");
        }
        final String stars = star.toString();
        StringBuilder sb = new StringBuilder(original);
        sb.replace(start,sb.length(),stars);
        return sb.toString();
    }


    @Test
    public void testFilter(){
        List<String> list = new ArrayList<>();
        list.add("湖州公安情报第133期(会议纪要).docx");
        list.add("湖州公安情报第135期(会议纪要).docx");
        list.add("湖州公安情报第145期(会议纪要).docx");
        list.add("湖州公安情报第146期(会议纪要).docx");
        list.add("湖州公安情报第146期(会议纪asd要).docx");
        list.add("asd(会议纪要).docx");
        list.add("a123kasd).docx");

        int max= 0;
        String target = "";

        for (String name : list) {
            if (name.startsWith("湖州公安情报第") && name.endsWith("期(会议纪要).docx")){
                final String substring = name.substring(7);
                final String versionStr = substring.substring(0,substring.indexOf("期(会议纪要).docx"));
                final Integer version = Integer.valueOf(versionStr);
                if (version > max){
                    max = version;
                    target = name;
                }
            }
        }
        System.out.println(target);
    }

    @Test
    public void subArea2() {
        String area2 = "公安局太平派出所";
        String result = area2;
        if (result.startsWith("公安局")){
            result = result.substring(3);
        }
        if (result.endsWith("派出所")){
            result = result.substring(0, result.length() - 3);
        }
        System.out.println(result);
    }
}
