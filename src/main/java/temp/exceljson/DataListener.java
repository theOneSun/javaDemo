package temp.exceljson;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.List;

/**
 * @author sunjian.
 */
public class DataListener extends AnalysisEventListener<ExcelObject> {

    private final List<ExcelObject> list;

    public DataListener(List<ExcelObject> list) {
        this.list = list;
    }

    @Override
    public void invoke(ExcelObject data, AnalysisContext context) {
        list.add(data);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        System.out.println("完成!");
    }
}
