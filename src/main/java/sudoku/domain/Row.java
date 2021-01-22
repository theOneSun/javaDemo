package sudoku.domain;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @author sunjian.
 */
@RequiredArgsConstructor
public class Row extends Module {

    private final Integer index;
    private final ArrayList<Cell> cells = new ArrayList<>();

    @Override
    public ArrayList<Cell> getCells() {
        return this.cells;
    }

    @Override
    public Set<Integer> getCandidates() {
        Set<Integer> result = new HashSet<>();
        for (int i = 1; i < 10; i++) {
            result.add(i);
        }
        for (Cell cell : this.cells) {
            if (!cell.isChangeable()){
                result.remove(cell.getValue());
            }
        }
        return result;
    }

   /* @Override
    public boolean removeCandidate(final int value) {
        boolean result = false;
        for (Cell cell : cells) {
            if (cell.removeCandidate(value)) {
                result = true;
            }
        }
        return result;
    }*/

    @Override
    public int getIndex() {
        return this.index;
    }
}
