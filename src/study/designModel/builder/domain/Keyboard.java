package study.designModel.builder.domain;

/**
 * 键盘
 *
 * @authur sunjian.
 */
public class Keyboard
{
    private String name;

    public Keyboard()
    {
    }

    public Keyboard(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return "Keyboard{" + "name='" + name + '\'' + '}';
    }
}
