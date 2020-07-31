package study.proxy.jdkdynamic;

/**
 * @author sunjian.
 */
public class Referee implements IPeople {
    @Override
    public void eat(String food) {
        System.out.println("裁判吃饭啦!--" + food);
    }
}
