package study.baseTest;

import com.sun.org.apache.bcel.internal.generic.NEWARRAY;
import org.junit.Test;
import study.baseTest.domain.Student;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @authur sunjian.
 */
public class ListTest
{
    @Test
    public void testContainsAll(){
        List<String> openList = new ArrayList<>();
        openList.add("1");
        openList.add("2");
        openList.add("3");
        openList.add("4");
        openList.add("5");
        openList.add("6");
        openList.add("7");
        List<String> checkList = new ArrayList<>();
        checkList.addAll(openList);
        checkList.add("8");

        System.out.println(checkList.containsAll(openList));
        System.out.println(openList.containsAll(checkList));

    }

    @Test
    public void testContains(){
        List<Student> studentList = new ArrayList<>();
        Student messi = new Student(1, "Messi", "男");
        studentList.add(messi);
        studentList.add(new Student(2,"C.Ronaldo","男"));
        studentList.add(new Student(3,"Havi","男"));

        Student student = new Student(1, "Messi", "男");

        boolean contains = studentList.contains(student);
        System.out.println(contains);
        System.out.println(messi.equals(student));
        System.out.println(studentList.contains(messi));
    }

    @Test
    public void testRemoveAll(){
        List<Integer> writeList = new ArrayList<>();
        List<Integer> removeList = new ArrayList<>();
        for (int i=0;i<10;i++){
            writeList.add(i);
            removeList.add(i);
        }
        removeList.remove(0);
        removeList.add(11);

        boolean b = writeList.removeAll(removeList);
        System.out.println(b);
        System.out.println(writeList);
    }

    @Test
    public void testNull() throws Exception
    {
        List<Double> list = new ArrayList<>();
        list.add(null);
        list.add(null);
        System.out.println(list.size());
    }

    @Test
    public void testInsert() throws Exception
    {
//        String searchContent = "奇瑞 路虎 揽胜 路虎";
        String searchContent = "奇瑞 揽胜";

        String[] splitArray = searchContent.split(" ");
        List<String> list = Arrays.asList(splitArray);
        List<String> list2;

//        List<String> list2 = new ArrayList<>(list.size()+1);
//        list2.addAll(list);
        Map<String,List<String>> map = new HashMap<>();
        for (int i=0;i<= list.size();i++){
            list2 = new ArrayList<>(list.size()+1);
            list2.addAll(list);
            list2.add(i,"路虎");
            list2.forEach(System.out::println);
            System.out.println("-----------");
            map.put("路虎"+i,list2);
        }

        Set<Map.Entry<String, List<String>>> entrySet = map.entrySet();
        for (Map.Entry<String, List<String>> entry : entrySet)
        {
            System.out.println(entry);
        }
//        list2.add(0,"路虎");
//        list2.add(1,"路虎");
//        list2.forEach(System.out::println);
    }

    //测试指定位置插入
    @Test
    public void testAddIndex(){
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add(0,"0");
        System.out.println(list.size());
    }
}
