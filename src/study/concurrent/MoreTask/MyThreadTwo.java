package study.concurrent.MoreTask;

/**
 * @author sunjian.
 */
public class MyThreadTwo implements Runnable
{
    @Override
    public void run()
    {
        for (int i = 0; i < 10; i++)
        {
            System.out.println("thread-two running " + i);
        }
    }
}
