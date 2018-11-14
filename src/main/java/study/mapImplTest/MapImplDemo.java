package study.mapImplTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @authur sunjian.
 */
public class MapImplDemo
{
    @Test
    public void demoRun(){
        CheckResult<ErrorMessage,List> checkResult = new CheckResult<>();
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        checkResult.put(ErrorMessage.DATA_EMPTY,list);
        System.out.println(checkResult);
    }
}
