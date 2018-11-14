package study.designModel.adaptor;

import org.junit.Test;

/**
 * Created by sunjian on 2017/6/2.
 */
public class AdaptorTest
{
    @Test
    public void testAdaptor() throws Exception{
        ImplAll want1 = new  WantedClass();
        ImplAll want2 = new WantedClass2();
        want1.function1();
        want1.function2();
        want2.function1();
        want2.function2();

    }
}
