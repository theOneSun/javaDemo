package sudoku.listener;

import sudoku.domain.Sudoku;

/**
 * @author sunjian.
 */
public class CellValueChangeListener {

    public static void cellValueChange(Sudoku sudoku, int x, int y, int z, int value) {
        sudoku.getRowValue(x).forEach(cell -> cell.removeCandidate(value));
        sudoku.getColumn(y).getCells().forEach(cell -> cell.removeCandidate(value));
        sudoku.getGrid(z).getCells().forEach(cell -> cell.removeCandidate(value));
    }

}
