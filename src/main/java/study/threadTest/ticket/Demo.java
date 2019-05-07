package study.threadTest.ticket;

/**
 * @author sunjian.
 */
public class Demo {


    public static void main(String[] args) {
        final TicketSell ticketSell = new TicketSell(20);

        final Thread thread1 = new Thread(ticketSell, "售票员1");
        final Thread thread2 = new Thread(ticketSell, "售票员2");
        new Thread(ticketSell, "售票员3").start();

        thread1.start();
        thread2.start();
    }
}
