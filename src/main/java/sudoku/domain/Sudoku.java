package sudoku.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 数独对象
 *
 * @author sunjian.
 */
public class Sudoku {

    @Setter(AccessLevel.PRIVATE)
    @Getter
    private List<List<Cell>> cells;

    private final ArrayList<Row> rows = new ArrayList<>(9);
    private final ArrayList<Column> columns = new ArrayList<>(9);
    private final ArrayList<Grid> grids = new ArrayList<>(9);

    /*public static Sudoku init() {
        final Sudoku sudoku = new Sudoku();
        List<List<Cell>> list = new ArrayList<>();

        for (int i = 1; i < 10; i++) {
            //i 是行数
            List<Cell> temp = new ArrayList<>();
            for (int j = 1; j < 10; j++) {
                //j是列数
                final Cell cell = new Cell(i, j);

                temp.add(cell);
            }
            list.add(temp);
        }
        sudoku.setCells(list);
        return sudoku;
    }*/

    public Column getColumn(int index) {
        return this.columns.get(index - 1);
    }

    public Row getRow(int index) {
        return this.rows.get(index - 1);
    }

    public Grid getGrid(int index) {
        return this.grids.get(index - 1);
    }

    public Sudoku init() {
        for (int i = 1; i < 10; i++) {
            rows.add(new Row(i));
            columns.add(new Column(i));
            grids.add(new Grid(i));
        }
        List<List<Cell>> list = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            //i 是行数
            List<Cell> temp = new ArrayList<>();
            for (int j = 1; j < 10; j++) {
                //j是列数
                final Cell cell = new Cell(i, j);
                temp.add(cell);
                this.distributeCell(cell);
            }
            list.add(temp);
        }
        this.cells = list;
        return this;
    }

    public List<Cell> getAllCell(){
        List<Cell> result = new ArrayList<>();
        for (List<Cell> cellList: this.cells) {
            result.addAll(cellList);
        }
        return result;
    }

    //分配单元格到行列宫
    private void distributeCell(Cell cell){
        this.getRow(cell.getX()).addCell(cell);
        this.getColumn(cell.getY()).addCell(cell);
        this.getGrid(cell.getZ()).addCell(cell);
    }

    public List<Cell> getRowValue(int x) {
        return cells.get(x - 1);
    }

    private Cell getCell(Integer x, Integer y) {
        return cells.get(x - 1).get(y - 1);
    }

    public void print() {
        cells.forEach(cellList -> {
            for (int i = 0; i < 9; i++) {
                final Cell cell = cellList.get(i);
                System.out.print(
                        "值:" + cell.getValue() + ", 坐标:(" + cell.getX() + "," + cell.getY() + "," + cell.getZ() + ")");
                System.out.print(", 候选数:(" + cell.getCandidates() + ");");
                if (i < 8) {
                    System.out.print(" , ");
                } else {
                    System.out.println();
                }
            }
        });
    }

    public void setCellValue(Integer x, Integer y, Integer value) {
        this.getCell(x, y).setValue(value);
    }

    //获取行的值,row从1开始,只获取不可变的值
    private Set<Integer> rowValue(Integer row) {
        final List<Cell> list = cells.get(row - 1);
        return list.stream().map(Cell::getValue).collect(Collectors.toSet());
    }

    //获取行的值,row从1开始,只获取不可变的值
    private Set<Integer> columnValue(Integer column) {
        Set<Integer> result = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            result.add(getCell(i, column - 1).getValue());
        }
        return result;
    }

    //获取小模块的值,只获取不可变的值
    private Set<Integer> moduleValue(@NonNull Integer module) {
        Set<Integer> result = new HashSet<>();
        cells.forEach(cellList -> cellList.forEach(cell -> {
            if (Objects.equals(cell.getZ(), module)) {
                result.add(cell.getValue());
            }
        }));
        return result;
    }

    public void filter() {
        /*
        1.根据xyz填充预选值
         */
        for (int x = 1; x < 10; x++) {
            //行
            for (int y = 1; y < 10; y++) {
                //列
                final Cell cell = this.getCell(x, y);
                if (cell.isChangeable()) {
                    final Set<Integer> rowValue = rowValue(x);
                    final Set<Integer> columnValue = columnValue(y);
                    final Set<Integer> moduleValue = moduleValue(cell.getZ());
                    //删除行内已有值
                    cell.excludeCandidate(rowValue);
                    //删除列内已有值
                    cell.excludeCandidate(columnValue);
                    //删除模块内已有值
                    cell.excludeCandidate(moduleValue);
                }
            }
        }
    }

    public void deleteCandidate(int x, int y, int z, int value) {
        for (List<Cell> row : this.cells) {
            for (Cell cell : row) {
                if (cell.getX() == x) {
                    cell.removeCandidate(value);
                }
                if (cell.getY() == y) {
                    cell.removeCandidate(value);
                }
                if (cell.getZ() == z) {
                    cell.removeCandidate(value);
                }
            }
        }
    }
}
