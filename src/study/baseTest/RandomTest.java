package study.baseTest;

import org.junit.Test;

import java.util.Random;

/**
 * Random类的测试
 * @author sunjian.
 */
public class RandomTest
{
    /**
     * 测试生成成绩
     */
    @Test
    public void testRandomDouble(){
        Random random = new Random();
        for (int i=0 ;i<100;i++){
            System.out.println(Double.valueOf(random.nextInt(100)+""));
        }
    }

    /**
     * 测试random的一般方法
     */
    @Test
    public void testNormalMethod(){
        Random random = new Random();
//        random.
    }
}
