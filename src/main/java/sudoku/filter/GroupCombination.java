package sudoku.filter;

import sudoku.domain.Cell;
import sudoku.domain.Row;
import sudoku.domain.Sudoku;

import java.util.List;
import java.util.Set;

/**
 * 数组的组合
 * 例如(1,2),(1,3),(2,3),则123只能出现在这三个格中
 * 引申,当n个格中仅有n个数出现,那其他格子中不会出现这n个数中的任意一个(n<当前行/列/宫的空格数)
 * todo 思考(1,2),(1,3),(1,2,3) n个并集的元素=n,且n<当前行列宫空格数,显性数对
 * @author sunjian.
 */
@Deprecated
public class GroupCombination implements Combination {
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
