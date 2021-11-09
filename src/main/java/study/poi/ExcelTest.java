package study.poi;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

/**
 * @author sunjian.
 */
public class ExcelTest {

    @Test
    public  void export() {
        HSSFWorkbook book = new HSSFWorkbook();
        //创建sheet
        HSSFSheet sheet = book.createSheet();

       /* String head1 = "表头:xxxx表";
        //一级指标
        String[] head2 = new String[]{"序号","部门名称","1号一级指标","2号一级指标","3号一级指标"};
        //二级指标
        String[] head3 = new String[]{"1-1办事指南发布数量","1-2指南完备度,准确性","2-1全称网版","2-2资助办"};
        //三级指标
        String[] head4 = new String[]{"1-1办事指南发布数量-数值","1-1办事指南发布数量-得分","1-2指南完备度,准确性-数值","2-1全称网版-数值","2-2资助办-数值","3号一级指标-数值","3号一级指标-得分","3号一级指标-排名"};
*/

        final FsIndex fsIndex = headIndexTree();

        //大表头
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, fsIndex.getMaxLength()-1));
        final HSSFRow row = sheet.createRow(0);
        final HSSFCell cell = row.createCell(0);
        cell.setCellValue(fsIndex.getName());

        final Integer rootDeep = fsIndex.getMaxDeep();

        //一级指标表头
        /*if (fsIndex.isLeaf()){
            System.out.println("没有下级指标");
        }else
        {
            final int level1Deep = rootDeep - 1;
            final HSSFRow row1 = sheet.createRow(1);
            final List<FsIndex> children = fsIndex.getChildren();
            //当前单元格列标
            int columnIndex = 0;
            for (final FsIndex child : children) {
                final Integer maxDeep = child.getMaxDeep();
                int lastRow;
                if (maxDeep == 1) {
                    lastRow = level1Deep;
                } else {
                    lastRow = maxDeep;
                }
                sheet.addMergedRegion(new CellRangeAddress(1, lastRow, columnIndex, child.getMaxLength() - 1));

                //设置单元格值
                row1.createCell(columnIndex).setCellValue(child.getName());

                columnIndex = columnIndex + child.getMaxLength();
            }
        }*/

        createHead(fsIndex,sheet,fsIndex.getMaxDeep());


    }

    private void createHead(FsIndex fsIndex, HSSFSheet sheet,int deep){

        if (fsIndex.isLeaf()){
            System.out.println("没有下级指标");
        }else
        {
            final Integer level = fsIndex.getLevel();
            if (level ==0){
                //大表头
                sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, fsIndex.getMaxLength()-1));
                final HSSFRow row = sheet.createRow(0);
                final HSSFCell cell = row.createCell(0);
                cell.setCellValue(fsIndex.getName());

            }else
            {
                final HSSFRow row1 = sheet.createRow(level);
                final List<FsIndex> children = fsIndex.getChildren();
                //当前单元格列标
                int columnIndex = 0;
                for (final FsIndex child : children) {
                    final Integer maxDeep = child.getMaxDeep();
                    int lastRow;
                    if (maxDeep == 1) {
                        lastRow = deep;
                    } else {
                        lastRow = maxDeep;
                    }
                    sheet.addMergedRegion(new CellRangeAddress(1, lastRow, columnIndex, child.getMaxLength() - 1));

                    //设置单元格值
                    row1.createCell(columnIndex).setCellValue(child.getName());

                    columnIndex = columnIndex + child.getMaxLength();
                }
            }

        }
    }

    @Test
    public void printIndex(){
        final FsIndex fsIndex = headIndexTree();
        System.out.println(fsIndex);
    }

    private FsIndex headIndexTree(){
        final FsIndex root = new FsIndex();
        root.setName("表头");
        final String rootId = UUID.randomUUID().toString();
        root.setId(rootId);
        root.setLevel(0);

        //一级指标
        List<FsIndex> level1List = new LinkedList<>();
        level1List.add(new FsIndex(UUID.randomUUID().toString(),"序号",rootId,1));
        level1List.add(new FsIndex(UUID.randomUUID().toString(),"1号一级指标",rootId,1));

        root.setChildren(level1List);

        //二级指标
        final FsIndex level1Index = level1List.get(1);
        level1Index.addChild(new FsIndex(UUID.randomUUID().toString(),"1-1办事指南发布数量",2));
        level1Index.addChild(new FsIndex(UUID.randomUUID().toString(),"1-2指南完备度,准确性",2));

        return root;
    }
}
