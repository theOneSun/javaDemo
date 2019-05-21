package study.threadTest.ticket;

/**
 * @author sunjian.
 */
public class Demo {


    public static void main(String[] args) {
        final Runnable ticketSell = new TicketSell(20);

        final Thread thread1 = new Thread(ticketSell, "售票员1");
        final Thread thread2 = new Thread(ticketSell, "售票员2");
        new Thread(ticketSell, "售票员3").start();

        thread1.start();
        thread2.start();
        System.out.println("这应该是主线程:"+Thread.currentThread().getName());
    }
}
