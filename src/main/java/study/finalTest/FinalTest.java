package study.finalTest;

import org.junit.Test;

/**
 * Created by sunjian on 2017/6/2.
 */
public class FinalTest
{
    @Test
    public void testFinalPosition() throws Exception{
        final Student student = new Student("peter",123);
        changeStudent(student);
        System.out.println("change方法后: " + student);
    }

    private void changeStudent(Student student){
        //int a = 2;
        student.setName("haha");
        System.out.println("change方法中: " + student);
    }


}
