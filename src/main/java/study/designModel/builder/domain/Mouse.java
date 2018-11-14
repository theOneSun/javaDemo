package study.designModel.builder.domain;

/**
 * @authur sunjian.
 */
public class Mouse
{
    private String name;

    public Mouse()
    {
    }

    public Mouse(String name)
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
        return "Mouse{" + "name='" + name + '\'' + '}';
    }
}
