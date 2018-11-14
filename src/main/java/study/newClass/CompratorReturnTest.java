package study.newClass;

import org.junit.Test;

import javax.swing.plaf.multi.MultiLabelUI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author sunjian.
 */
public class CompratorReturnTest
{
    @Test
    public void testReturn(){
        //从小到大排序
        Comparator<Integer> testCompare = (o1, o2) ->
        {
            if (o1==null){
                return -1;
            }else
            {
                if (o2==null){
                    return 1;
                }else{
                    //都不为空
                    if (o1>o2){
                        return 1;
                    }else if (o1.equals(o2)){
                        return 0;
                    }else
                    {
                        return -1;
                    }
                }
            }

        };
        List<Integer> list = new ArrayList<>();
        for (int i=0;i<5;i++){
            list.add(i);
        }
        list.add(1);
        list.add(null);
        list.add(0);
        list.add(1);
        list.add(null);
        list.add(null);
        List<Integer> resultList = list.stream().sorted(testCompare).collect(Collectors.toList());
        resultList.forEach(System.out::println);
    }
}
