package study.baseTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

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

    /**
     * 测试生成6位纯数字code
     */
    @Test
    public void generateCode(){
        final Random random = new Random();
//        final IntStream ints = random.ints(6, 0, 99999);
        /*for (int i=0;i<20;i++){
            System.out.println(random.nextInt(10));

        }
//        ints.forEach(System.out::println);
        //        System.out.println(l);

        StringBuilder code = new StringBuilder();
        for(int j=0;j<6;j++){
            code.append(random.nextInt(10));
        }
        System.out.println(code.toString());

        final String s = RandomStringUtils.randomNumeric(6);
        System.out.println(s);*/

        for (int i=0;i<10;i++){
            final int intCode = 100000 + ThreadLocalRandom.current().nextInt(900000);
            System.out.println(intCode);
        }

    }

    @Test
    public void testFotune() {

        final Random random = new Random();
        for (int i = 0; i < 6; i++) {
            final int r = random.nextInt(35);
            switch (i) {
                case 0:
                    System.out.println(r * 0.8 + 3 * 0.2);
                    break;
                case 1:
                    System.out.println(r * 0.8 + 6 * 0.2);
                    break;
                case 2:
                    final int a = random.nextInt(12);
                    System.out.println("蓝色:"+a);
                    break;
                case 3:
                    System.out.println(r * 0.8 + 8 * 0.2);
                    break;
                case 4:
                    System.out.println(r * 0.8 + 19 * 0.2);
                    break;
                case 5:
                    System.out.println(r * 0.8 + 20 * 0.2);
                    break;
                default:
                    throw new RuntimeException("cuowu");
            }
        }
    }

    @Test
    public void testZero(){
        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            System.out.println(random.nextInt(3));
        }
    }

    @Test
    public void testRandomUtils() {
        System.out.println(RandomStringUtils.random(5));
        System.out.println(RandomStringUtils.random(5,false,true));
        System.out.println(RandomStringUtils.random(5,"abcdefghijklmn"));
        System.out.println(RandomStringUtils.randomAlphabetic(5));
    }

    @Test
    public void temp() {
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            BigDecimal bg =  new BigDecimal(String.valueOf(60+40*random.nextDouble()));
            final double result = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            System.out.println(result);
        }
    }
}
