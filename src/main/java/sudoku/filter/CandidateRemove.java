package sudoku.filter;

import sudoku.domain.Sudoku;

/**
 * @author sunjian.
 */
public interface CandidateRemove {
    /**
     * 根据逻辑删除候选数
     *
     * @return 是否有修改
     */
    boolean removeCandidate(Sudoku sudoku);
}
