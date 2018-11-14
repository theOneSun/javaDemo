package study.concurrent.MoreTask;

/**
 * @author sunjian.
 */
public class MyThreadOne implements Runnable
{
    private String name;

    public MyThreadOne(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public void run()
    {
        try
        {
            for (int i = 0; i < 10; i++)
            {
                System.out.println("thread-"+name+" running " + i);
                Thread.sleep(100);
            }
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
