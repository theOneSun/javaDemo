package study.designModel.builder.deprecated;

/**
 * Created by sunjian on 2017/6/1.
 */
public class DellComputerBuilder implements ComputerBuilder
{
    private Computer computer = new Computer();

    @Override
    public void buildDisplay()
    {
        System.out.println("构建Dell显示器");
        computer.setDisplay("Dell显示器");
    }

    @Override
    public void buildKeyBoard()
    {
        System.out.println("构建Dell键盘");
        computer.setKeyBoard("Dell键盘");
    }

    @Override
    public void buildMouse()
    {
        System.out.println("构建Dell鼠标");
        computer.setMouse("Dell鼠标");
    }

    @Override
    public Computer retrieveComputer()
    {
        return computer;
    }
}
