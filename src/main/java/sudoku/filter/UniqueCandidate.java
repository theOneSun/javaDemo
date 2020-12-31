package sudoku.filter;

import sudoku.domain.Cell;
import sudoku.domain.Sudoku;

import java.util.List;
import java.util.Set;

/**
 * 单候选数设置值
 * @author sunjian.
 */
public class UniqueCandidate implements CandidateRemove{
    @Override
    public boolean removeCandidate(Sudoku sudoku) {
        boolean result = false;
        final List<Cell> allCell = sudoku.getAllCell();
        for (Cell cell : allCell) {
            final Set<Integer> candidates = cell.getCandidates();
            if (cell.isChangeable() && candidates.size() == 1){
                cell.setValue(candidates.iterator().next());
                result = true;
            }
        }
        return result;
    }
}
