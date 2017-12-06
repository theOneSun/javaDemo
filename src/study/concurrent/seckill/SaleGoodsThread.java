package study.concurrent.seckill;

import javax.sound.sampled.Mixer;

/**
 * @author sunjian.
 */
public class SaleGoodsThread implements Runnable
{
    private String way;
    private static int total = 20;
    private volatile int max = 20;
    //    private static final Object lock = new Object();
    private Object lock = new Object();

    public int getTotal()
    {
        return total;
    }

    public SaleGoodsThread()
    {
    }

    public SaleGoodsThread(String way)
    {
        this.way = way;
    }

    public String getWay()
    {
        return way;
    }

    public void setWay(String way)
    {
        this.way = way;
    }


    /*@Override
    public void run()
    {
        try
        {
            while (total > 0)
            {
                saleGoods();
            }
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }*/
    @Override
    public void run()
    {
        try
        {
            while (max > 0)
            {
                countDown();
            }
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    /*private void saleGoods() throws InterruptedException
    {
        synchronized (lock)
        {
            if (total > 0)
            {
                total--;
                System.out.println(way + Thread.currentThread().getName() + "卖出了一张票,还剩" + total + "张票");
                Thread.sleep(100);
            } else
            {
                System.out.println("票已售罄" + Thread.currentThread().getName());
            }
        }
    }*/

    private synchronized void saleGoods() throws InterruptedException
    {
        if (total > 0)
        {
            total--;
            System.out.println(way + Thread.currentThread().getName() + "卖出了一张票,还剩" + total + "张票");
            Thread.sleep(100);
        } else
        {
            System.out.println("票已售罄" + Thread.currentThread().getName());
        }
    }

    private void countDown() throws InterruptedException
    {
        if (max > 0)
        {
            max--;
            System.out.println(way + Thread.currentThread().getName() + "卖出了一张票,还剩" + max + "张票");
            Thread.sleep(100);
        } else
        {
            System.out.println("票已售罄" + Thread.currentThread().getName());
        }
    }

}
