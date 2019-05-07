package study.threadTest.satisfaction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * @author sunjian.
 */
public class BarChartSelect implements Callable<List<String>> {

    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public List<String> call() throws Exception {
        final List<String> result = new ArrayList<>();
        Collections.addAll(result,"1","2","3");
        return result;
    }
}
