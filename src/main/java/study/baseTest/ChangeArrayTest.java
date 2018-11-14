package study.baseTest;

import org.junit.Test;

import java.lang.reflect.Parameter;

/**
 * @authur sunjian.
 */
public class ChangeArrayTest
{
    @Test
    public void testChangeArray(){
        printParam("姓名","年龄","学号","成绩");
    }

    private void printParam(String... columns){
        System.out.println("长度: " + columns.length);
        for (String column : columns)
        {
            System.out.println("param: " + column);
        }
    }
}
