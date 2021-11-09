package temp;

import org.junit.Test;

/**
 * 123,321,123,321...
 * @author sunjian.
 */
public class LoopCode {
    @Test
    public void test123(){
        Integer[] array = new Integer[]{1,3,2,2,1,3,3,2,1};
        for (int i = 0; i < 13; i++) {
            System.out.println(array[i%9]);
        }
    }
}
