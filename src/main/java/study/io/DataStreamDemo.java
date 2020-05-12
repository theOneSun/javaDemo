package study.io;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author sunjian.
 */
public class DataStreamDemo {

    @Test
    public void testOutPutStream() throws IOException {
        /*
        1.用connection发个请求
        2.使用dataoutputstream看是什么
         */

        URL url;
        HttpURLConnection urlConn = null;
        try {
            url = new URL("http://localhost:8090/business/json_test");
            urlConn = (HttpURLConnection)url.openConnection();
            urlConn.setDoInput(true);
            urlConn.setDoOutput(true);
            urlConn.setRequestMethod("POST");
            urlConn.setUseCaches(false);
            urlConn.setInstanceFollowRedirects(true);
            urlConn.setRequestProperty("Content-Type", "application/json");
            urlConn.connect();
        } catch (IOException e) {
            e.printStackTrace();
        }

        final DemoParam demoParam = new DemoParam("hehe",18);

        ObjectMapper objectMapper = new ObjectMapper();

        DataOutputStream dops = new DataOutputStream(urlConn.getOutputStream());
        try {
//            String content = JSONObject.toJSONString(demoParam);
            final String content = objectMapper.writeValueAsString(demoParam);
            dops.writeBytes(content);
            dops.flush();
            dops.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("-------------------------");

        BufferedReader reader = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
        String inputLine = null;
        StringBuilder resultBuilder = new StringBuilder();
        while ((inputLine = reader.readLine()) != null) {
            resultBuilder.append(inputLine)
                         .append("\n");
        }
        reader.close();
        urlConn.disconnect();

//        log.info("user info service login response : " + resultBuilder.toString());

        final User user = objectMapper.readValue(resultBuilder.toString(), User.class);

        System.out.println(user);

        System.out.println("end=========");
    }

//    @Data
//    @NoArgsConstructor
//    @AllArgsConstructor
//    public class User{
//        private UUID id;
//        private String username;
//    }

    @Data
    @AllArgsConstructor
    public class DemoParam{
        private String username;
        private Integer age;
    }
}
