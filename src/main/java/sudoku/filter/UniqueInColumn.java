package sudoku.filter;

import sudoku.domain.AppearCounter;
import sudoku.domain.Cell;
import sudoku.domain.Column;
import sudoku.domain.Sudoku;
import sudoku.domain.ValueAppearCounter;

import java.util.ArrayList;
import java.util.Map;

/**
 * 某一列中有单独出现的预选数
 *
 * @author sunjian.
 */
public class UniqueInColumn implements CandidateRemove {
    @Override
    public boolean removeCandidate(Sudoku sudoku) {
        boolean result = false;
        /*
        目的是找出cell有整行唯一的预选数
         */
        final ArrayList<Column> columns = sudoku.getColumns();

        for (Column column : columns) {
            final ArrayList<Cell> cells = column.getCells();
            ValueAppearCounter valueAppearCounter = new ValueAppearCounter();

            cells.forEach(cell -> {
                if (cell.isChangeable()) {
                    cell.getCandidates().forEach(candidate -> valueAppearCounter.put(candidate, cell));
                }
            });
            for (Map.Entry<Integer, AppearCounter> entry : valueAppearCounter.getMap().entrySet()) {
                final AppearCounter appearCounter = entry.getValue();
                if (appearCounter.getTimes() ==1 ){
                    //仅出现一次
                    if (appearCounter.getCells().size() != 1) {
                        throw new RuntimeException();
                    }
                    final Cell cell = appearCounter.getCells().get(0);
                    cell.setValue(entry.getKey());
                    result = true;
//                    break;
                }
            }
        }
        return result;
    }


}
