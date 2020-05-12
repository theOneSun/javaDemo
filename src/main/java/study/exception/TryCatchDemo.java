package study.exception;

import org.junit.Test;

/**
 * @author sunjian.
 */
public class TryCatchDemo {

    @Test
    public void finalExecute(){
        final Integer print = print();
        System.out.println(print);
    }

    private Integer print(){
        try {

//            int i = 1/0;
            int i=100;
            return i;
        }catch (Exception e){
            return -1;
        }finally {
            System.out.println("execute finally");
            return 0;
        }
    }
}
