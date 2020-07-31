package study.enumdemo;

import org.junit.Test;

import static study.enumdemo.ParamEnum.COMMUNICATION_SKILL;

/**
 * @author sunjian.
 */
public class EnumTest
{
    @Test
    public void testPrint(){
        System.out.println(ParamEnum.SERVICE_ETIQUETTE);
        ParamEnum.SERVICE_LEVEL.print();
        COMMUNICATION_SKILL.talk();
    }
}
