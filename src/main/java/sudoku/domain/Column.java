package sudoku.domain;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;

/**
 * 列
 * @author sunjian.
 */
@RequiredArgsConstructor
public class Column extends Module {

    private final Integer index;
    private final ArrayList<Cell> cells = new ArrayList<>();
    @Override
    ArrayList<Cell> getCells() {
        return this.cells;
    }

    @Override
    public boolean removeCandidate(int value) {
        boolean result = false;
        for (Cell cell : cells) {
            if (cell.removeCandidate(value)) {
                result = true;
            }
        }
        return result;
    }

    @Override
    public int getIndex() {
        return this.index;
    }
}
