package sudoku.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author sunjian.
 */
@RequiredArgsConstructor
@Getter
public class CandidateSameGroup {

    private final Set<Integer> candidates;
    private List<Cell> cells = new LinkedList<>();

    public void add(Cell cell) {
        cells.add(cell);
    }

    /**
     * 是否存在数组
     *
     * @return true:存在多个相同候选数的情况;false:不存在多个相同候选数的情况
     */
    public boolean existGroup() {
        return cells.size() > 1;
    }

    /**
     * 是否可以删除其他格子的候选数
     * 候选数的数量跟候选数在的格子数量相同,说明候选数只能出现在这几个格子里,同组的其他格子的候选数可以删除这几个候选数
     *
     * @return true:同行/列/宫的其他格子中如果存在这几个候选数的话可以删除;false:不存在数组,不删
     */
    public boolean canRemove() {
        return existGroup() && candidates.size() == cells.size();
    }
}
