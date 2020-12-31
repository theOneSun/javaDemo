package study.interfacetest;

import static study.interfacetest.ColorEnum.GREEN;

/**
 * @author sunjian.
 */
public class ColorDemo {

    public static void main(String[] args) {
        final Red red = new Red();

        System.out.println(red.getColor());

        System.out.println(GREEN.getColor());
    }
}
