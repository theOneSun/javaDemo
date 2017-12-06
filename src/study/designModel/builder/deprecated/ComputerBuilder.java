package study.designModel.builder.deprecated;

/**
 * Created by sunjian on 2017/6/1.
 */
public interface ComputerBuilder
{
    void buildDisplay();
    void buildKeyBoard();
    void buildMouse();

    Computer retrieveComputer();

}
