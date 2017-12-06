package study.compare;

import java.time.LocalDate;

/**
 * @author sunjian.
 */
public class Programmer
{
    private String id;
    private String name;
    private Gender gender;
    private int salary;
    private LocalDate entryTime;
    private boolean onTheJob;//是否在职
    private LocalDate dimissionTime;

    enum Gender{
        male,
        female
    }

    public Programmer()
    {
    }

    public Programmer(String id, String name)
    {
        this.id = id;
        this.name = name;
    }

    public Programmer(String id, String name, Gender gender)
    {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }

    public Programmer(String id, String name, Gender gender, int salary, LocalDate entryTime, boolean onTheJob,
                      LocalDate dimissionTime)
    {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.salary = salary;
        this.entryTime = entryTime;
        this.onTheJob = onTheJob;
        this.dimissionTime = dimissionTime;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Gender getGender()
    {
        return gender;
    }

    public void setGender(Gender gender)
    {
        this.gender = gender;
    }

    public int getSalary()
    {
        return salary;
    }

    public void setSalary(int salary)
    {
        this.salary = salary;
    }

    public LocalDate getEntryTime()
    {
        return entryTime;
    }

    public void setEntryTime(LocalDate entryTime)
    {
        this.entryTime = entryTime;
    }

    public boolean isOnTheJob()
    {
        return onTheJob;
    }

    public void setOnTheJob(boolean onTheJob)
    {
        this.onTheJob = onTheJob;
    }

    public LocalDate getDimissionTime()
    {
        return dimissionTime;
    }

    public void setDimissionTime(LocalDate dimissionTime)
    {
        this.dimissionTime = dimissionTime;
    }
}
