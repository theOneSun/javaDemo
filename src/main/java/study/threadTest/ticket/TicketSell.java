package study.threadTest.ticket;

/**
 * @author sunjian.
 */
@SuppressWarnings("WeakerAccess")
public class TicketSell implements Runnable {
    private int total;

    private final Object lock = new Object();

    public TicketSell(int total) {
        this.total = total;
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                if (total > 0) {
                    total--;
                    System.out.println("线程" + Thread.currentThread().getName() + "卖出了一张票,还剩余票" + total + "张");
                } else {
                    System.out.println("线程" + Thread.currentThread().getName() + "票已售罄");
                    break;
                }
            }
        }

        /*try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
    }
}
