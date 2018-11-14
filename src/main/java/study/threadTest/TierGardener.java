package study.threadTest;


/**
 * @author sunjian.
 */
public class TierGardener implements Gardener
{
    @Override
    public void run()
    {
        System.out.println("耶耶耶");
        try
        {
            Thread.sleep(3000);
            System.out.println("当前线程:" + Thread.currentThread().getName());
            final Calculator calculator = Calculator.getCalculator();
            Thread.sleep(3000);
            System.out.println("当前计算器:" + calculator);
            calculator.calculate("tier");
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
