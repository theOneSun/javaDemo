package temp;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.sql.Timestamp;

/**
 * @author sunjian.
 */
public class JsonConvert {

    private String rawData = "{\n" + "\t\"phoneNumber\": \"13580006666\",\n" + "\t\"purePhoneNumber\": \"13580006666\",\n" + "\t\"countryCode\": \"86\",\n" + "\t\"watermark\": {\n" + "\t\t\"appid\": \"APPID\",\n" + "\t\t\"timestamp\": \"123123123\"\n" + "\t}\n" + "}";

    @Test
    public void testConvert() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        final WxPhoneData wxPhoneData = objectMapper.readValue(rawData, WxPhoneData.class);
        System.out.println(wxPhoneData);
    }

    @Test
    public void name() {
        final long currentTimeMillis = System.currentTimeMillis();
        System.out.println("currentTimeMillis: "+currentTimeMillis);
        final Timestamp timestamp = new Timestamp(currentTimeMillis);
        final long time = timestamp.getTime();
        System.out.println(timestamp);
        System.out.println("time : "+time);
    }
}
