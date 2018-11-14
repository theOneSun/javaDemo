package study.concurrent.MoreTask;

import org.junit.Test;

/**
 * @author sunjian.
 */
public class SaleTest
{
    @Test
    public void testMore()
    {
        MyThreadOne myThreadOne1 = new MyThreadOne("线程1");
        MyThreadOne myThreadOne2 = new MyThreadOne("线程2");
//        MyThreadTwo myThreadTwo = new MyThreadTwo();
        Thread thread1 = new Thread(myThreadOne1);
        Thread thread2 = new Thread(myThreadOne2);
        thread1.start();
        thread2.start();
        thread1.run();
        thread2.run();
    }
}
