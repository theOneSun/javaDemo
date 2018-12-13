package study.utils;

/**
 * @author sunjian.
 */
public class StringUtils {

    /**
     * 包含null的比较
     * @param s1
     * @param s2
     * @return
     */
    public static boolean equalsContainsNull(String s1, String s2) {
        if (s1 == null) {
            return s2==null;
        }else{
            return s1.equals(s2);
        }
    }
}
