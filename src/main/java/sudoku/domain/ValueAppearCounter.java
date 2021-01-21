package sudoku.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author sunjian.
 */
@NoArgsConstructor
@Data
public class ValueAppearCounter {

    Map<Integer, AppearCounter> map = new HashMap<>();

    public void put(Integer value, Cell cell) {
        final AppearCounter appearCounter = map.get(value);
        if (Objects.isNull(appearCounter)) {
            final AppearCounter newCounter = new AppearCounter();
            newCounter.addCell(cell);
            map.put(value, newCounter);
        } else {
            appearCounter.addCell(cell);
        }
    }

    //判断整行有没有单独的数
    public Cell singleValue() {
        for (Map.Entry<Integer, AppearCounter> entry : map.entrySet()) {

        }
        ;
        return null;
    }
}
