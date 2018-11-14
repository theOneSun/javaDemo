package study.designModel.chainOfResponsibility.chain;

import org.junit.Test;
import study.designModel.chainOfResponsibility.ResultNotify;

/**
 * @author sunjian.
 */
public class ChainTest2
{
    @Test
    public void testChain()
    {
        ResultHandlerChain chain = new ResultHandlerChain();
        chain.addResultHandler(new CityResultHandler()).addResultHandler(new CarResultHandler());
        ResultNotify resultNotify1 = new ResultNotify("1", 10, "13213123", "car", "hongqi");
        ResultNotify resultNotify2 = new ResultNotify("2", 20, "321", "city", "hotline");
        ResultNotify resultNotify3 = new ResultNotify("3", 30, "123", "meal", "hongqi");

        System.out.println("第一个通知开始");
        chain.handleResult(resultNotify1, chain);
        System.out.println("第一个通知结束");
        System.out.println("第二个通知开始");
        chain = new ResultHandlerChain();
        chain.addResultHandler(new CityResultHandler()).addResultHandler(new CarResultHandler());
        chain.handleResult(resultNotify2, chain);
        System.out.println("第二个通知结束");
        System.out.println("第三个通知开始");
        chain = new ResultHandlerChain();
        chain.addResultHandler(new CityResultHandler()).addResultHandler(new CarResultHandler());
        chain.handleResult(resultNotify3, chain);
        System.out.println("第三个通知结束");

    }
}
