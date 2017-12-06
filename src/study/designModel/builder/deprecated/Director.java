package study.designModel.builder.deprecated;

/**
 * Created by sunjian on 2017/6/1.
 */
public class Director
{
    private ComputerBuilder computerBuilder;

    public Director(ComputerBuilder computerBuilder)
    {
        this.computerBuilder = computerBuilder;
    }

    public void construct(){
        computerBuilder.buildDisplay();
        computerBuilder.buildKeyBoard();
        computerBuilder.buildMouse();
    }
}
