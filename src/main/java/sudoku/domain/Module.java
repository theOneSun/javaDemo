package sudoku.domain;


import java.util.ArrayList;
import java.util.Set;

/**
 * 划分的模块
 *
 * @author sunjian.
 */
public abstract class Module implements Index, Candidate {

    abstract ArrayList<Cell> getCells();

     void addCell(Cell cell){
        if (getCells().size() < 10) {
            getCells().add(cell);
        } else {
            throw new UnsupportedOperationException("over size");
        }
    }

    @Override
    public final Set<Integer> getCandidates() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        getCandidates().clear();
    }


}
