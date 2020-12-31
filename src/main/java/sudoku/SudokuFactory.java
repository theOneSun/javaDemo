package sudoku;

import sudoku.domain.Sudoku;

/**
 * @author sunjian.
 */
public class SudokuFactory {
    public static Sudoku create(){
        return new Sudoku().init();
    }
}
