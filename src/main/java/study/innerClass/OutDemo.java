package study.innerClass;

import java.util.List;

/**
 * Created by sunjian on 2017/5/27.
 */
public class OutDemo
{

    private String name;
    private List<Skill> skillList;

    public static class Skill
    {
        private String skillName;

        public String getSkillName()
        {
            return skillName;
        }

        public void setSkillName(String skillName)
        {
            this.skillName = skillName;
        }

        public Skill()
        {
        }

        public Skill(String skillName)
        {
            this.skillName = skillName;
        }

        @Override
        public String toString()
        {
            return "Skill{" + "skillName='" + skillName + '\'' + '}';
        }
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public List<Skill> getSkillList()
    {
        return skillList;
    }

    public void setSkillList(List<Skill> skillList)
    {
        this.skillList = skillList;
    }

    public OutDemo()
    {
    }

    public OutDemo(String name, List<Skill> skillList)
    {
        this.name = name;
        this.skillList = skillList;
    }

    @Override
    public String toString()
    {
        return "OutDemo{" + "name='" + name + '\'' + ", skillList=" + skillList + '}';
    }
}
