package study.concurrent;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author sunjian.
 */
public class ListTest
{
    @Test
    public void testRemove()
    {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++)
        {
            list.add(i);
        }

        /*Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
            if (iterator.next() == 3){
                list.remove(4);
            }
        }*/

        for (Integer value : list)
        {
            System.out.println(value);
            if (value == 3){
                list.remove(value);
            }
        }
    }

    @Test
    public void testCopyAndWrite() throws Exception
    {
        List<Integer> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 10; i++)
        {
            list.add(i);
        }
        //用iterator遍历
        /*Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
            if (iterator.next() == 3){
                list.remove(5);
            }
        }
        Iterator<Integer> iterator2 = list.iterator();
        while (iterator2.hasNext()){
            System.out.println("二次遍历的:   "+ iterator2.next());
        }*/
        for (Integer value : list)
        {
            System.out.println(value);
            if (value == 3){
                list.remove(6);
            }
            System.out.println("长度:"+list.size());
        }
        for (Integer value: list){
            System.out.println("二次遍历值:  "+ value);
        }
    }
    private static List<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
    @Test
    public void testConcurrentTwo() throws Exception
    {
        for (int i = 0; i < 10; i++)
        {
            copyOnWriteArrayList.add(i);
        }
        new ThreadOne().start();
        new ThreadTwo().start();
    }

    private static class ThreadOne extends Thread
    {
        public void run()
        {
            Iterator<Integer> iterator = copyOnWriteArrayList.iterator();
            while (iterator.hasNext())
            {
                int i = iterator.next();
                System.out.println("ThreadOne 遍历:" + i);
                try
                {
                    Thread.sleep(10);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * @desc:当i == 3时，修改list
     * @Project:test
     * @file:FailFastTest.java
     * @Authro:chenssy
     * @data:2014年7月26日
     */
    private static class ThreadTwo extends Thread
    {
        public void run()
        {
            int i = 0;
            while (i < 6)
            {
                System.out.println("ThreadTwo run：" + i);
                if (i == 3)
                {
                    copyOnWriteArrayList.remove(i);
                }
                i++;
            }
        }
    }
}
