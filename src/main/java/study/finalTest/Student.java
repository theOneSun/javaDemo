package study.finalTest;

/**
 * Created by sunjian on 2017/6/2.
 */
public class Student
{
    private String name;
    private Integer num;

    public Student()
    {
    }

    public Student(String name, Integer num)
    {
        this.name = name;
        this.num = num;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Integer getNum()
    {
        return num;
    }

    public void setNum(Integer num)
    {
        this.num = num;
    }

    @Override
    public String toString()
    {
        return "Student{" + "name='" + name + '\'' + ", num=" + num + '}';
    }
}
