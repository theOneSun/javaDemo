package sudoku.filter;

import sudoku.domain.Column;
import sudoku.domain.Grid;
import sudoku.domain.Row;
import sudoku.domain.Sudoku;

/**
 * 候选数相同格子的排除
 *
 * @author sunjian.
 */
public class SameCombination implements Combination {
    @Override
    public boolean removeCandidate(Sudoku sudoku) {
        boolean result = false;
        for (Row row : sudoku.getRows()) {
            final boolean groupAndClear = row.findGroupAndClear();
            if (groupAndClear) {
                result = true;
            }
        }

        for (Column column : sudoku.getColumns()) {
            final boolean groupAndClear = column.findGroupAndClear();
            if (groupAndClear) {
                result = true;
            }
        }
        for (Grid grid : sudoku.getGrids()) {
            final boolean groupAndClear = grid.findGroupAndClear();
            if (groupAndClear) {
                result = true;
            }
        }

        return result;
    }
}
