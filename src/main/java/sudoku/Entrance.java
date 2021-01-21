package sudoku;

import com.alibaba.excel.EasyExcel;
import org.springframework.util.ObjectUtils;
import sudoku.domain.Cell;
import sudoku.domain.Sudoku;
import sudoku.domain.SudokuContext;
import sudoku.filter.CandidateRemove;
import sudoku.filter.FilterRegister;

import java.util.List;
import java.util.Scanner;

/**
 * 运行入口
 *
 * @author sunjian.
 */
public class Entrance {

    public static void main(String[] args) {
        //初始化游戏,9行9列9个小方阵
        final Entrance entrance = new Entrance();

        //初始化棋盘
        final Sudoku sudoku = SudokuFactory.create();
        //        sudoku.print();

        //        entrance.initFixedCell(sudoku);
        entrance.readExcel(sudoku, "sudoku-exp");
        sudoku.print();

        //        System.out.println(entrance.checkChangeable(sudoku));

        //        SudokuContext.setSudoku(sudoku);
        SudokuContext.put("sudoku", sudoku);

        final List<CandidateRemove> chain = FilterRegister.register();
        boolean loopFilter = true;
        while (loopFilter) {
            loopFilter = false;
            for (CandidateRemove filter : chain) {
                final boolean filterResult = filter.removeCandidate(sudoku);
                if (filterResult) {
                    loopFilter = true;
                }
            }
            System.out.println("一次完整的清除:------------------");
            sudoku.print();
            System.out.println("--------------------------------");

        }


        System.out.println(entrance.checkChangeable(sudoku));

        System.out.println("---------------------------------------------");
        sudoku.print();

    }

    public boolean checkChangeable(Sudoku sudoku) {
        boolean result;
        final List<Cell> cells = sudoku.getAllCell();
        for (Cell cell : cells) {
            if (cell.isChangeable()) {
                result = !ObjectUtils.isEmpty(cell.getCandidates());
            } else {
                result = ObjectUtils.isEmpty(cell.getCandidates());
            }
            if (!result) {
                return false;
            }
        }
        return true;
    }

    //创建一个棋盘
    private Sudoku createChessboard() {
        return SudokuFactory.create();
    }

    //指定固定的值
    private void initFixedCell(Sudoku sudoku) {

        Scanner sc = new Scanner(System.in);

        int operationCode;
        System.out.println("请输入要执行的操作编码(0:退出;1:新增初始化数格): ");
        operationCode = sc.nextInt();

        while (operationCode != 0) {
            System.out.println("请输入x轴坐标: ");
            int x = sc.nextInt();
            System.out.println("请输入y轴坐标: ");
            int y = sc.nextInt();
            System.out.println("请输入坐标为 (" + x + " , " + y + ") 的值: ");
            int value = sc.nextInt();

            sudoku.setCellValue(x, y, value);

            System.out.println("请输入要执行的操作编码(0:退出;1:新增初始化数格): ");
            operationCode = sc.nextInt();
        }
    }

    private void readExcel(Sudoku sudoku, String name) {
        String fileName = System.getProperty("user.dir") + "/" + name + ".xlsx";
        EasyExcel.read(fileName, new SudokuDataListener(sudoku)).sheet().doRead();
    }
}
