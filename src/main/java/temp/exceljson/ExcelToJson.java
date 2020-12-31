package temp.exceljson;

import com.alibaba.excel.EasyExcel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

/**
 * @author sunjian.
 */
public class ExcelToJson {

    @Test
    public void excelToJson() throws JsonProcessingException {
        final File file = new File(System.getProperty("user.dir") + "/potential clients list.xlsx");
        final List<ExcelObject> list = new LinkedList<>();
        EasyExcel.read(file, ExcelObject.class, new DataListener(list))
                 .sheet()
                 .doRead();
        final ObjectMapper om = new ObjectMapper();
        final String s = om.writeValueAsString(list);
        System.out.println(s);

    }
}
