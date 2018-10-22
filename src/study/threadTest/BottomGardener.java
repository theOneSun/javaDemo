package study.threadTest;

/**
 * @author sunjian.
 */
public class BottomGardener implements Gardener
{
    @Override
    public void run()
    {
        try
        {
            Thread.sleep(3000);
            System.out.println("当前线程:" + Thread.currentThread().getName());
            final Calculator calculator = Calculator.getCalculator();
            Thread.sleep(3000);
            System.out.println("当前计算器:" + calculator);
            calculator.calculate("bottom");

        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
