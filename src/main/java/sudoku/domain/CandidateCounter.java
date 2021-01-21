package sudoku.domain;

import java.util.List;

/**
 * @author sunjian.
 */
public class CandidateCounter {
    private int value;
    private int count;
    /**
     * 可填value的cell
     */
    private List<Cell> cells;
}
