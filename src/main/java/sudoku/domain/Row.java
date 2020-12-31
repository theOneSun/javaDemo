package sudoku.domain;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;

/**
 * @author sunjian.
 */
@RequiredArgsConstructor
public class Row extends Module {

    private final Integer index;
    private final ArrayList<Cell> cells = new ArrayList<>();

    @Override
    ArrayList<Cell> getCells() {
        return this.cells;
    }

    @Override
    public boolean removeCandidate(final int value) {
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
