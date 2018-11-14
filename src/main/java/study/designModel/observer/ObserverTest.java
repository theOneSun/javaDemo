package study.designModel.observer;

/**
 * @author sunjian.
 */
public class ObserverTest {
    public static void main(String[] args) {
        final Yilin yilin = new Yilin();
        final YilinReader sam = new YilinReader("sam");
        final YilinReader amy = new YilinReader("amy");
        yilin.addObserver(sam);
        yilin.addObserver(amy);

        yilin.setVersion("3");
    }
}
