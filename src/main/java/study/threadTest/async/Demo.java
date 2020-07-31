package study.threadTest.async;

import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author sunjian.
 */
public class Demo {
    @Test
    public void testCallableAsync() throws InterruptedException, ExecutionException {
        System.out.println(Thread.currentThread().getName()+" this should be main");
        final FutureTask<String> task = new FutureTask<>(() -> {
            Thread.sleep(2000);
            return Thread.currentThread()
                         .getName() + "lalala";
        });
        new Thread(task).start();

//        System.out.println(task.get());
        System.out.println();
        System.out.println("123");
    }

    @Test
    public void testRunnableAsync() throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+" this should be main");
        new Thread(()-> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" lalala");
        }).start();
        Thread.sleep(3000);
    }
}
