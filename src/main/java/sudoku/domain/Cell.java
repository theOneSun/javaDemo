package sudoku.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

/**
 * 单元格
 *
 * @author sunjian.
 */
@RequiredArgsConstructor
public class Cell implements Candidate {
    private final Set<Integer> candidates = new LinkedHashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
    //行标,start with 1
    @Setter
    @Getter
    private Integer x;
    //列标,start with 1
    @Setter
    @Getter
    private Integer y;
    //模块标,start with 1
    @Setter
    @Getter
    private Integer z;
    //数值
    @Getter
    private Integer value;

    //是否可变(1.指定不可变;2.根据推算不可变)
    @Getter
    private boolean changeable = true;

    public Cell(Integer x, Integer y) {
        this.x = x;
        this.y = y;
        this.setZ();
    }

    //设置z轴坐标
    private void setZ() {
        if (x < 4) {
            if (y < 4) {
                this.z = 1;
            } else if (y < 7) {
                this.z = 2;
            } else {
                this.z = 3;
            }
        } else if (x < 7) {
            if (y < 4) {
                this.z = 4;
            } else if (y < 7) {
                this.z = 5;
            } else {
                this.z = 6;
            }
        } else {
            if (y < 4) {
                this.z = 7;
            } else if (y < 7) {
                this.z = 8;
            } else {
                this.z = 9;
            }
        }
    }

    public void setValue(Integer value) {
        this.value = value;
        this.changeable = false;
        //1.清空候选值
        //2.同行同列同宫的候选值删掉与
        this.candidates.clear();
        // 同行同列同宫的候选值删掉与
        final Sudoku sudoku = (Sudoku) SudokuContext.get("sudoku");
        if (Objects.nonNull(sudoku)){
            sudoku.getRow(x).getCells().forEach(cell -> cell.removeCandidate(value));
            sudoku.getColumn(y).getCells().forEach(cell -> cell.removeCandidate(value));
            sudoku.getGrid(z).getCells().forEach(cell -> cell.removeCandidate(value));
        }
    }

    //排除候选项
    public void excludeCandidate(Set<Integer> set) {
        this.candidates.removeAll(set);
        if (candidates.size() == 0) {
            throw new RuntimeException("解错了");
        }
        if (candidates.size() == 1) {
            setValue(candidates.iterator().next());
        }
    }

    @Override
    public Set<Integer> getCandidates() {
        return this.candidates;
    }

    @Override
    public void clear() {
        this.candidates.clear();
    }

    @Override
    public boolean removeCandidate(int value) {
        return this.candidates.remove(value);
    }


}
