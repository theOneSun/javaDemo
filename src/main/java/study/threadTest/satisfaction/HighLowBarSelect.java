package study.threadTest.satisfaction;

import java.util.concurrent.Callable;

/**
 * @author sunjian.
 */
public class HighLowBarSelect implements Callable<String> {

    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public String call() throws Exception {
        Thread.sleep(5000);
        return "高低分图结果";
    }
}
