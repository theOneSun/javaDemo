package study.net;

import org.junit.Test;

import java.net.URI;

/**
 * @author sunjian.
 */
public class URITest {
    @Test
    public void testUriBuilder(){
        final URI uri = URI.create("http://1.1.1.1:8080/uc");
        System.out.println("host: "+uri.getHost());
        System.out.println("scheme: "+uri.getScheme());
        System.out.println("port: "+uri.getPort());
        System.out.println("path: "+uri.getPath());
        System.out.println(uri);
    }
}
