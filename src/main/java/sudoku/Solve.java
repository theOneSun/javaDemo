package sudoku;

import lombok.RequiredArgsConstructor;
import sudoku.domain.Sudoku;
import sudoku.filter.CandidateRemove;

import java.util.List;

/**
 * @author sunjian.
 */
@RequiredArgsConstructor
public class Solve {
    private final Sudoku sudoku;
    private List<CandidateRemove> filterList;
    private boolean update;
}
