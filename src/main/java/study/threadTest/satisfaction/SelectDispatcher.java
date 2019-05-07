package study.threadTest.satisfaction;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @author sunjian.
 */
public class SelectDispatcher {

    public static void main(String[] args) throws Exception {

//        loopExecute();
        selfHandle();
    }

    /**
     * 创建线程池,
     * 将执行的callable接口添加到集合中循环取值
     * 执行时异步的,取值是同步的
     */
    private static void loopExecute() throws Exception {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        //我们使用一个List来存放Callable的返回值
        List<Future> futures = new ArrayList<>();

        futures.add(cachedThreadPool.submit(new BarChartSelect()));
        futures.add(cachedThreadPool.submit(new HighLowBarSelect()));
        futures.add(cachedThreadPool.submit(new IndexLevelSelect()));

        for (Future future : futures) {
            final Object o = future.get();
            System.out.println("主线程收集的到了  线程的返回值:"+o.toString());
            System.out.println("返回值类型是:"+o.getClass());
        }
        System.out.println("main thread finished!!");
    }

    /**
     * 自己处理结果
     */
    private static void selfHandle() throws Exception {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        //我们使用一个List来存放Callable的返回值

        final Future<List<String>> barData = cachedThreadPool.submit(new BarChartSelect());
        final Future<String> highLow = cachedThreadPool.submit(new HighLowBarSelect());
        final Future<String> indexLevel = cachedThreadPool.submit(new IndexLevelSelect());

        final List<String> list = barData.get();
        System.out.println(list);
        final String s = highLow.get();
        System.out.println(s);
        final String s1 = indexLevel.get();
        System.out.println(s1);

        System.out.println("main thread finished!!");
    }

}
