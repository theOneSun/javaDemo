package sudoku.domain;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 划分的模块
 *
 * @author sunjian.
 */
public abstract class Module implements Index, Candidate {

    public abstract ArrayList<Cell> getCells();

    void addCell(Cell cell) {
        if (getCells().size() < 10) {
            getCells().add(cell);
        } else {
            throw new UnsupportedOperationException("over size");
        }
    }

    /*@Override
    public final Set<Integer> getCandidates() {
        throw new UnsupportedOperationException();
    }*/

    @Override
    public boolean removeCandidate(int deleteCandidate) {
        boolean result = false;
        for (Cell cell : getCells()) {
            if (cell.removeCandidate(deleteCandidate)) {
                result = true;
            }
        }
        return result;
    }

    @Override
    public boolean removeCandidates(Set<Integer> deleteCandidates) {
        boolean result = false;
        for (Cell cell : getCells()) {
            if (cell.removeCandidates(deleteCandidates)) {
                result = true;
            }
        }
        return result;
    }

    @Override
    public void clear() {
        getCandidates().clear();
    }

    /**
     * 还未填充的单元格
     *
     * @return 未填充的单元格集合
     */
    public List<Cell> fetchChangeableCells() {
        return getCells().stream().filter(Cell::isChangeable).collect(Collectors.toList());
    }


    /**
     * 找出有相同候选数的单元格组并进行清空候选数操作
     *
     * @return true:删除了候选数;false:没有删除候选数
     */
    public boolean findGroupAndClear() {
        /*
            1.找出还有几个空着的
            2.对比这些格子有没有重复的候选数组
            3.如果有候选数数量和重复的格子数相同的,那说明候选数仅能在这几个格子中,其他格子要删除这些候选数
             */
        final List<Cell> changeableCells = fetchChangeableCells();
        boolean result = false;
        for (int i = 0; i < changeableCells.size(); i++) {

            //以当前单元格的候选数为标准
            final Cell templateCell = changeableCells.get(i);
            final Set<Integer> templateCandidates = templateCell.getCandidates();

            final CandidateSameGroup candidateSameGroup = new CandidateSameGroup(templateCandidates);
            candidateSameGroup.add(templateCell);

            if (i < changeableCells.size() - 1) {
                for (int j = i + 1; j < changeableCells.size(); j++) {

                    final Cell tCell = changeableCells.get(j);
                    if (templateCandidates.equals(tCell.getCandidates())) {
                        candidateSameGroup.add(tCell);
                    }
                }
            }
            //判断如果有可以删除的则进行删除
            if (candidateSameGroup.canRemove()) {
                final List<Cell> groupCells = candidateSameGroup.getCells();
                for (Cell changeableCell : changeableCells) {
                    if (!groupCells.contains(changeableCell)) {
                        final boolean b = changeableCell.removeCandidates(candidateSameGroup.getCandidates());
                        if (b) {
                            result = true;
                        }
                    }
                }
            }
        }
        return result;
    }

}
