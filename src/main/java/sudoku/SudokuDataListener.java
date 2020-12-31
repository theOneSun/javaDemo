package sudoku;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.metadata.Cell;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.read.metadata.holder.ReadRowHolder;
import lombok.RequiredArgsConstructor;
import sudoku.domain.Sudoku;

import java.util.Map;

/**
 * @author sunjian.
 */
@RequiredArgsConstructor
public class SudokuDataListener extends AnalysisEventListener<Map<String, Integer>> {

    final private Sudoku sudoku;

    @Override
    public void invoke(Map<String, Integer> data, AnalysisContext context) {
        final ReadRowHolder rowHolder = context.readRowHolder();
        final Integer rowIndex = rowHolder.getRowIndex();

        final Map<Integer, Cell> cellMap = rowHolder.getCellMap();


        cellMap.forEach(
                (key, cell) -> sudoku.setCellValue(rowIndex, key + 1, ((CellData) cell).getNumberValue().intValue()));
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        System.out.println("excel read finish");
    }
}
