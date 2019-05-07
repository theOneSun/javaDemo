package study.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunjian.
 */
public class StreamTest {

    @Test
    public void emptyForeach(){
        List<String> list = new ArrayList<>();
        list.forEach(System.out::println);
    }
}
