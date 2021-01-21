package sudoku.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sunjian.
 */
public class SudokuContext {
    private static Map<String, Object> map = new HashMap<>();

    public static Object get(String key) {
        return map.get(key);
    }

    public static void put(String key, Object o) {
        map.put(key, o);
    }
}
