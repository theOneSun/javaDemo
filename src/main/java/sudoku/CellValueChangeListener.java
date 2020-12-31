package sudoku;

import lombok.RequiredArgsConstructor;
import sudoku.domain.Cell;
import sudoku.domain.Sudoku;

import java.util.List;

/**
 * @author sunjian.
 */
@RequiredArgsConstructor
public class CellValueChangeListener {
    private final Sudoku sudoku;

    public void cellValueChange(int x,int y,int z ,int value){
        final List<Cell> row = sudoku.getRowValue(x);
        sudoku.deleteCandidate(x,y, z ,value);
    }
}
