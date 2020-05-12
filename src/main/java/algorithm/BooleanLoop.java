package algorithm;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunjian.
 */
public class BooleanLoop {

    List<Integer[]> integerlist = new ArrayList<>();

    @Test
    public void produceArray() {
        int count = 0;
        List<Integer[]> list = new ArrayList<>();
//        Integer[] array = new Integer[5];
        for (int i = 0; i < 2; i++) {
//            array[0] = i;
            for (int j = 0; j < 2; j++) {
//                array[1] = j;
                for (int l = 0; l < 2; l++) {
//                    array[2] = l;
                    for (int m = 0; m < 2; m++) {
//                        array[3] = m;
                        for (int n = 0; n < 2; n++) {
//                            array[4] = n;
                            Integer[] array = new Integer[]{i,j,l,m,n};
                            list.add(array);
                            System.out.println(count++ + " : " + ArrayUtils.toString(array));
                        }
                    }
                }
            }
        }
        System.out.println("===========分割线==================");
        list.forEach(array-> System.out.println(ArrayUtils.toString(array)));
    }

    @Test
    public void recursionTest(){
        recursion(new Integer[5],0);
        System.out.println("===========分割线==================");
        integerlist.forEach(array-> System.out.println(ArrayUtils.toString(array)));
    }

    private void recursion(Integer[] array,int level){
        if (level < 5){
            for (int i = 0; i < 2; i++) {
                array[level] = i;
                recursion(array,level+1);
            }
        }else
        {
            System.out.println(ArrayUtils.toString(array));
            integerlist.add(array.clone());
        }

    }
}
