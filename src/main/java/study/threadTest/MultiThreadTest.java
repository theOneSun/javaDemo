package study.threadTest;

import org.junit.Test;

/**
 * @author sunjian.
 */
public class MultiThreadTest
{
    @Test
    public void singletonThreadTest() throws InterruptedException
    {
        Gardener bottom = new BottomGardener();
        Gardener tier = new TierGardener();

        final Thread bottomThread = new Thread(bottom);
        bottomThread.start();
        System.out.println("--------" + bottomThread.getName() + "---------------");
        //        bottom.run();
        System.out.println("111");

        final Thread tierThread = new Thread(tier);
        tierThread.start();
        System.out.println("----------" + tierThread.getName() + "-------------");
        //        tierThread.run();
        System.out.println("222");
        Thread.currentThread().join();
    }

    public static void main(String[] args)
    {
        Gardener bottom = new BottomGardener();
        Gardener tier = new TierGardener();

        final Thread bottomThread = new Thread(bottom);
        bottomThread.start();
        System.out.println("--------" + bottomThread.getName() + "---------------");
        //        bottom.run();
        System.out.println("111");

        final Thread tierThread = new Thread(tier);
        tierThread.start();
        System.out.println("----------" + tierThread.getName() + "-------------");
        //        tierThread.run();
        System.out.println("222");
    }
}