package sudoku.filter;

import sudoku.domain.Cell;
import sudoku.domain.Row;
import sudoku.domain.Sudoku;

import java.util.List;
import java.util.Set;

/**
 * 显性数对
 * n个并集的元素=n,且n<当前行列宫空格数
 * (1,2),(1,3),(2,3)
 * (1,2),(1,3),(1,2,3)
 *
 * @author sunjian.
 */
public class Dominant implements Combination{
    @Override
    public boolean removeCandidate(Sudoku sudoku) {
        for (Row row : sudoku.getRows()) {
            final List<Cell> changeableCells = row.fetchChangeableCells();
            final int changeableCellsSize = changeableCells.size();
            for (int i = 0; i < changeableCellsSize; i++) {
                final Set<Integer> templateCandidates = changeableCells.get(i).getCandidates();
                /*
                1.模板格子有m个候选数,就选m+1个格子到n-1个格子分别找
                 */
                for (int j = templateCandidates.size(); j < changeableCellsSize - 1; j++) {
                    final List<Cell> cells = changeableCells.subList(i, j);

                }
            }

        }

        return false;
    }
}
