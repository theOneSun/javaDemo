package study.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author sunjian.
 */
public class PasswordUtils {
    public static void main(final String[] args) {
        final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.encode("Zhongxin123"));
//        System.out.println(passwordEncoder.encode("666666"));
//        System.out.println(passwordEncoder.encode("888888"));
    }
}
