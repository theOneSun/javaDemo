package study.innerClass;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunjian on 2017/5/27.
 */
public class InnerTest
{
    @Test
    public void testInnerCreate()
    {
        List<OutDemo.Skill> skillList = new ArrayList<>();
        skillList.add(new OutDemo.Skill("programming"));
        skillList.add(new OutDemo.Skill("play"));
        OutDemo demo = new OutDemo("张三", skillList);
        System.out.println(demo);
    }
}
