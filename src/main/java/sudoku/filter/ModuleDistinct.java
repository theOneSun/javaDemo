package sudoku.filter;

import sudoku.domain.Cell;
import sudoku.domain.Column;
import sudoku.domain.Grid;
import sudoku.domain.Row;
import sudoku.domain.Sudoku;

import java.util.List;

/**
 * @author sunjian.
 */
public class ModuleDistinct implements CandidateRemove{


    @Override
    public boolean removeCandidate(Sudoku sudoku) {
        boolean status = false;
        //1.找出没有value的cell,根据行列宫删除候选项
        final List<List<Cell>> allCells = sudoku.getCells();
        for (List<Cell> rowCells : allCells) {
            for (Cell cell : rowCells){
                if (!cell.isChangeable()){
                    final Row row = sudoku.getRow(cell.getX());
                    final boolean rowChange = row.removeCandidate(cell.getValue());
                    final Column column = sudoku.getColumn(cell.getY());
                    final boolean columnChange = column.removeCandidate(cell.getValue());
                    final Grid grid = sudoku.getGrid(cell.getZ());
                    final boolean gridChange = grid.removeCandidate(cell.getValue());
                    if (rowChange || columnChange || gridChange){
                        status = true;
                    }
                }
            }
        }
        /*if (status){
            //如果有过设置值,再一次修改
            removeCandidate(sudoku);
        }*/
        return status;
    }
}
