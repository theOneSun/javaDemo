package study.designModel.builder.domain;

/**
 * @authur sunjian.
 */
public class Display
{
    private String name;

    public Display()
    {
    }

    public Display(String name)
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
        return "Display{" + "name='" + name + '\'' + '}';
    }
}
