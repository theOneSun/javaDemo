package study.baseTest;

import org.junit.Test;
import study.finalTest.Student;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @authur sunjian.
 */
public class ForTest
{
    @Test
    public void testFor() throws Exception
    {
        List<Student> studentList = new ArrayList<>();
        Student student = null;
        studentList.add(new Student("messi", 28));
        studentList.add(new Student("c.ronaldo", 30));
        studentList.add(new Student("pique", 28));
        studentList.add(new Student("havi", 34));
        studentList.add(new Student("alves", 34));
        studentList.add(student);
        /*for (int i=0 ;i<studentList.size();i++){
            System.out.println(studentList.get(i).getName());
        }*/

        for (Student s : studentList)
        {
            System.out.println(s.getName());
        }
    }

    @Test
    public void testVeryMuch() throws Exception
    {
        List<String> list = new LinkedList<>();
        Set<String> set = new HashSet<>();
        Set<String> set2 = new HashSet<>();

        List<String> list2 = new LinkedList<>();
        long beginInsert = System.currentTimeMillis();
        for (int i = 0; i < 300000; i++)
        {
//            list.add(i + "");
            set.add(i+"");
        }
        for (int i = 0; i < 1000000; i++)
        {
//            list2.add(i + "");
            set2.add(i+"");
        }
        long endInsert = System.currentTimeMillis();

        long insert = endInsert - beginInsert;
        System.out.println("插入用时:   " + insert);
        //----------------------------
        long beginForeach = System.currentTimeMillis();
        /*for (String str : list)
        {
            if (list2.contains(str)){
                System.out.print(str+" ");
            }
        }*/
        for (String str: set)
        {
            if (set2.contains(str)){
                System.out.print(str+" ");
            }
        }
        long endForeach = System.currentTimeMillis();
        long forEachTime = endForeach - beginForeach;
        System.out.println("foreach用时:   " + forEachTime);

        //----------------------------
        /*long beginFor = System.currentTimeMillis();
        int size = list.size();
        for (int j = 0; j < size; j++)
        {
            if (list2.contains(list.get(j))){
                System.out.print(list.get(j));
            }
        }
        long endFor = System.currentTimeMillis();
        long forTime = endFor - beginFor;
        System.out.println("for用时:   " + forTime);*/
    }
}
