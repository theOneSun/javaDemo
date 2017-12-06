package study.designModel.builder;

import org.junit.Test;
import study.designModel.builder.domain.Display;
import study.designModel.builder.domain.Keyboard;
import study.designModel.builder.domain.Mouse;

/**
 * @authur sunjian.
 */
public class Demo
{

    @Test
    public void testBuilder()
    {
        Computer computer = new Computer.Builder().name("Dell")
                                               .keyboard(new Keyboard("机械键盘"))
                                               .display(new Display("液晶显示器"))
                                               .mouse(new Mouse("雷蛇鼠标"))
                                               .build();
        System.out.println(computer);
    }
}
