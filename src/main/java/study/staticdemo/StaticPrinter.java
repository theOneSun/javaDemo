package study.staticdemo;

import study.utils.BatchUUIDUtils;

import java.io.IOException;

/**
 * @author sunjian.
 */
public class StaticPrinter {

    static {
        initialize();
    }

    private static void initialize() {
        System.out.println("静态初始化方法  run...");
    }

    public static void print() throws IOException {
        System.out.println("静态打印方法 run ...");
        final ThreadLocal<BatchUUIDUtils> tb = new ThreadLocal<>();
        BatchUUIDUtils batchUUIDUtils = tb.get();
        if (batchUUIDUtils == null){
            tb.set(new BatchUUIDUtils());
        }
        batchUUIDUtils = tb.get();
//        batchUUIDUtils.productUUIDBatch();
    }
}
