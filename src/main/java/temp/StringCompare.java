package temp;

import org.junit.Test;

/**
 * @author sunjian.
 */
public class StringCompare {
    @Test
    public void compare(){
        String a = "http://localhost:9999/TokenWechat/webservice.do?action=httpJsonPostRequestByForm";
        String b = "http://localhost:9999/TokenWechat/webservice.do?action=httpJsonPostRequestByForm";
        System.out.println(a.equals(b));
    }
}
