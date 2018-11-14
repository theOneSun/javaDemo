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
        for (int i=0 ;i<10;i++){
//            System.out.println(Double.valueOf(random.nextInt(100)+""));
            long round = Math.round(random.nextDouble() * 100);
            if (round<50){
                round = round+50;
            }
            System.out.println(round);
        }
    }

    /**
     * 测试random的一般方法
     */
    @Test
    public void testNormalMethod(){
        Random random = new Random(100);
        for (int i=0;i<10;i++){
            System.out.println(random.nextDouble());
        }
    }
}
