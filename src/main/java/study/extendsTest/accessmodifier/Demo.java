package study.extendsTest.accessmodifier;

/**
 * @author sunjian.
 */
public class Demo {
    public static void main(String[] args) {
        Keyboard father = new Keyboard();
        Keyboard keyboard = new MachineKeyboard();
        father.enter(1,2);
        keyboard.enter(1,2);

    }
}
