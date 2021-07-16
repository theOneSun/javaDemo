package temp;

import lombok.Data;

/**
 * @author sunjian.
 */
@Data
public class WxPhoneData {

    private String phoneNumber;

    private String purePhoneNumber;

    private String countryCode;

    private Watermark watermark;

    @Data
    private class Watermark{
        private String appid;
        private String timestamp;
    }
}
