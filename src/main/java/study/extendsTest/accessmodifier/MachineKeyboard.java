package study.extendsTest.accessmodifier;

/**
 * @author sunjian.
 */
public class MachineKeyboard extends Keyboard {
    public void enter(int a, int b) {
        System.out.println(a - b);
    }

    private void enter(int a, long b) {
        System.out.println(a - b);
    }
}
