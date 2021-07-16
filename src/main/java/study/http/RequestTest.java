package study.http;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sunjian.
 */
public class RequestTest {

    public static void main(String[] args) throws IOException {
        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {


            HttpPost httpPost = new HttpPost("https://sxity.idataway.com/api/save/answer/callback");
            List<NameValuePair> nvps = new ArrayList<>();
            nvps.add(new BasicNameValuePair("callbackJson", "{\"answer_type\":2,\"source\":\"dadui2\",\"userFlag\":\"oiH3Y5dle9o5Efhho4pAIypDvaBo__20\",\"queVersionId\":\"k41529\",\"answerId\":112233}"));
            httpPost.setEntity(new UrlEncodedFormEntity(nvps));

            try (CloseableHttpResponse response2 = httpclient.execute(httpPost)) {
                final StatusLine statusLine = response2.getStatusLine();

                System.out.println(statusLine.getStatusCode() + " " + statusLine.getReasonPhrase());
                HttpEntity entity2 = response2.getEntity();
                // do something useful with the response body
                System.out.println("entity2" + entity2);
                // and ensure it is fully consumed
                EntityUtils.consume(entity2);
                System.out.println(entity2.getContentEncoding());
            }
        }
    }
    
    @Test
    public void convertUrl(){
        String json = "{" + "\"answer_type\":2," + " \"source\":\"dadui2\"," + "\"userFlag\":\"oiH3Y5dle9o5Efhho4pAIypDvaBo__20\"," + "\"queVersionId\":\"k41529\"," + "\"answerId\":112233" + "}";
        final String encode = URLEncoder.encode(json);
        System.out.println(encode);
    }

}
