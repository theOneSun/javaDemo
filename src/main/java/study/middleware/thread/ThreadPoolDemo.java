package study.middleware.thread;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池相关演示
 * @author sunjian.
 */
public class ThreadPoolDemo {

    @Test
    public void testThreadPool(){
        int count = 100000;

        randomWithPool(count);
        randomNormal(count);
        /*
        result:
            111
            100000
            26992
            100000
         */
    }
    //使用线程池创建随机数
    private void randomWithPool(int count){
        final long startTime = System.currentTimeMillis();
        List<Integer> list = new LinkedList<>();
        final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 60, TimeUnit.SECONDS,
                                                                             new LinkedBlockingQueue<>(count));
        Random random = new Random();
        for (int i=0;i<count;i++){
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    list.add(random.nextInt());
                }
            });
        }

        threadPoolExecutor.shutdown();
        try {
            threadPoolExecutor.awaitTermination(10,TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(System.currentTimeMillis()-startTime);
        System.out.println(list.size());
    }
    //不使用线程池创建随机数
    private void randomNormal(int count){
        final long startTime = System.currentTimeMillis();
        List<Integer> list = new LinkedList<>();
        Random random = new Random();
        for (int i=0;i<count;i++){
            final Thread thread = new Thread(){

                @Override
                public void run() {
                    list.add(random.nextInt());
                }
            };
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(System.currentTimeMillis()-startTime);
        System.out.println(list.size());
    }
}
