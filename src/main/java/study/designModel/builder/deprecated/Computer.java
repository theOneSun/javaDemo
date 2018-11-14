package study.designModel.builder.deprecated;

/**
 * Created by sunjian on 2017/6/1.
 */
public class Computer
{
    //显示器
    private String display;
    //键盘
    private String keyBoard;
    //鼠标
    private String mouse;

    public String getDisplay()
    {
        return display;
    }

    public void setDisplay(String display)
    {
        this.display = display;
    }

    public String getKeyBoard()
    {
        return keyBoard;
    }

    public void setKeyBoard(String keyBoard)
    {
        this.keyBoard = keyBoard;
    }

    public String getMouse()
    {
        return mouse;
    }

    public void setMouse(String mouse)
    {
        this.mouse = mouse;
    }

    @Override
    public String toString()
    {
        return "Computer{" + "display='" + display + '\'' + ", keyBoard='" + keyBoard + '\'' + ", mouse='" + mouse + '\'' + '}';
    }
}
