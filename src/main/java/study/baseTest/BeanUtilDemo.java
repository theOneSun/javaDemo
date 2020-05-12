package study.baseTest;

import org.junit.Test;
import study.io.User;

import java.util.UUID;

/**
 * @author sunjian.
 */
public class BeanUtilDemo {

    //测试复制属性
    @Test
    public void testCopyProperties(){
        final User target = new User(UUID.randomUUID(),"呵呵");
        final User user = new User(UUID.randomUUID(),"呵呵");

    }
}
