package study.designModel.builder;

import study.designModel.builder.domain.Display;
import study.designModel.builder.domain.Keyboard;
import study.designModel.builder.domain.Mouse;

/**
 * @authur sunjian.
 */
public class Computer
{
    //名称
    private String name;
    //显示器
    private Display display;
    //键盘
    private Keyboard keyboard;
    //鼠标
    private Mouse mouse;

    public Computer()
    {
    }

    public Computer(String name, Display display, Keyboard keyboard, Mouse mouse)
    {
        this.name = name;
        this.display = display;
        this.keyboard = keyboard;
        this.mouse = mouse;
    }

    public Computer(Builder builder){
        this.name = builder.name;
        this.display = builder.display;
        this.keyboard = builder.keyboard;
        this.mouse = builder.mouse;
    }
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Display getDisplay()
    {
        return display;
    }

    public void setDisplay(Display display)
    {
        this.display = display;
    }

    public Keyboard getKeyboard()
    {
        return keyboard;
    }

    public void setKeyboard(Keyboard keyboard)
    {
        this.keyboard = keyboard;
    }

    public Mouse getMouse()
    {
        return mouse;
    }

    public void setMouse(Mouse mouse)
    {
        this.mouse = mouse;
    }

    @Override
    public String toString()
    {
        return "Computer{" + "name='" + name + '\'' + ", display=" + display + ", keyboard=" + keyboard + ", mouse=" + mouse + '}';
    }

    public static class Builder{

        //名称
        private String name;
        //显示器
        private Display display;
        //键盘
        private Keyboard keyboard;
        //鼠标
        private Mouse mouse;

        public Builder()
        {
        }

        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder display(Display display){
            this.display = display;
            return this;
        }

        public Builder keyboard(Keyboard keyboard){
            this.keyboard = keyboard;
            return this;
        }

        public Builder mouse(Mouse mouse){
            this.mouse = mouse;
            return this;
        }

        public Computer build(){
            return new Computer(this);
        }
    }
}
