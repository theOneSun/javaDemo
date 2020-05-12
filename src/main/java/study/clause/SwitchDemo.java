package study.clause;

import org.junit.Test;

/**
 * @author sunjian.
 */
public class SwitchDemo {



    @Test
    public void testSwitch(){
        String gender = null;
        switch (gender){
            case "1":
                System.out.println("男");
                break;
            case "2":
                System.out.println("女");
                break;
            default:
                System.out.println(gender);
                break;
        }
    }
}
