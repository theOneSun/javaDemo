package sudoku.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedList;
import java.util.List;

/**
 * @author sunjian.
 */
@NoArgsConstructor
@Data
public class AppearCounter {
    private Integer times = 0;
    private List<Cell> cells = new LinkedList<>();

    public void addCell(Cell cell) {
        this.times = this.times + 1;
        this.cells.add(cell);
    }
}
