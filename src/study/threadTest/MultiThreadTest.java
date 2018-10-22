package study.threadTest;

import org.junit.Test;

/**
 * @author sunjian.
 */
public class MultiThreadTest
{
    @Test
    public void singletonThreadTest()
    {
        Gardener bottom = new BottomGardener();
        Gardener tier = new TierGardener();

        final Thread bottomThread = new Thread(bottom);
        bottomThread.start();
        System.out.println("-----------------------");
//        bottom.run();
        System.out.println("111");

        final Thread tierThread = new Thread(tier);
        tierThread.start();
        System.out.println("-----------------------");
//        tierThread.run();
        System.out.println("222");
    }
}
