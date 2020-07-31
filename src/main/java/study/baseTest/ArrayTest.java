package study.baseTest;


import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import study.utils.StringUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * @authur sunjian.
 */
public class ArrayTest {

    @Test
    public void testArray() throws Exception {
        int index1 = 1;
        int index2 = 2;
        String afterName = "账号";

        String[] header = new String[]{"姓名", "QQ", "手机", "Q龄"};
        String[] newHeader = new String[header.length - 1];

        for (int i = 0; i < header.length - 1; i++) {
            if (i < index2) {
                newHeader[i] = header[i];
            } else {
                newHeader[i] = header[i + 1];
            }

        }
        newHeader[index1] = afterName;

        for (String name : newHeader) {
            System.out.println(name);
        }
    }


    @Test
    public void testMergeMore() throws Exception {
        String afterName = "账号";
        //合并qq手机学号
        String[] header = new String[]{"姓名", "QQ", "手机", "年龄", "学号", "身份证", "爱好", "性别"};
        convertCsv(header, afterName, "QQ", "手机", "学号");

    }


    private void convertCsv(String[] header, String afterColumnName, String... mergeColumns) throws IOException {

        //通过readFile获得头
        //判断要合并几列
        int mergeTotal = mergeColumns.length;
        /*
        根据获得的头生成新的头
         */
        int headerLength = header.length;
        //定义新的头
        List<String> afterHeaderList = new ArrayList<>();//先定义一个集合
        String[] afterHeader = new String[headerLength - mergeTotal];
        int k = 0;
        boolean replace = true;//是否第一次出现需要替换

        for (String column : header) {
            boolean has = false;//是否有重复,有的话跳出训话

            for (String mergeColumn : mergeColumns) {
                if (column.equals(mergeColumn)) {
                    if (replace) {
                        afterHeaderList.add(afterColumnName);
                        replace = false;//替换后就不再替换
                    }
                    has = true;
                    break;
                }
            }
            if (!has) {
                afterHeaderList.add(column);
                afterHeader[k] = column;
                k++;
            }
        }

        for (String name : afterHeader) {
            System.out.println(name);
        }
        System.out.println("----------------------");
        for (String name : afterHeaderList) {
            System.out.println(name);
        }
    }

    @Test
    public void testList() {
        String[] header = new String[]{"姓名", "QQ", "手机", "年龄", "学号", "身份证", "爱好", "性别"};
        List<String> list = Arrays.asList(header);
        /*for (String name : list)
        {
            System.out.println(name);
        }*/

        String[] header2 = (String[]) list.toArray();
        for (String name : header2) {
            System.out.println(name);
        }
    }

    @Test
    public void testIntArray() {
        int[] array = new int[10];
        array[3] = 12;
        for (int anArray : array) {
            System.out.println(anArray);
        }
        List<int[]> list = Arrays.asList(array);
        Object[] objects = list.toArray();
        String[] strArray = new String[10];
        strArray[2] = "123";
        List<String> stringList = Arrays.asList(strArray);
        Integer[] integers = new Integer[10];

    }

    @Test
    public void testPrintArray() throws Exception {
        //        String[] array = new String[]{"1","2","3"};
        //        System.out.println(array.toString());
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        System.out.println(list);
    }

    @Test
    public void testRemove() {
        String[] a = {"north", "全部"};
        System.out.println(a[a.length - 1]);
    }

    @Test
    public void testSub() {
        String[] index = {"硬件", "外部环境", "外部卫生"};
        final String[] result = Arrays.copyOfRange(index, 0, index.length);
        for (String s : result) {
            System.out.println(s);
        }

    }

    @Test
    public void testClone() {
        String[] index = {"硬件", "外部环境", "外部卫生"};
        String[] clone = ArrayUtils.clone(index);
        System.out.println(Arrays.toString(clone));
        System.out.println(Arrays.toString(index));
    }

    @Test
    public void testAdd() {
        final String[] a = new String[2];
        for (int i = 0; i < 2; i++) {
            a[i] = String.valueOf(i);
        }
        System.out.println(Arrays.toString(a));
    }
    @Test
    public void testToString() {
        final String[] a = new String[2];
        for (int i = 0; i < 2; i++) {
            a[i] = String.valueOf(i);
        }
        System.out.println(Arrays.toString(a));
    }

}
