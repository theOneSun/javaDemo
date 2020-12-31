package study.asynchronous;

import study.asynchronous.behavior.BarChartOption;
import study.asynchronous.behavior.Mission;
import study.asynchronous.behavior.PieChartOption;
import study.asynchronous.behavior.TableOption;
import study.asynchronous.task.MissionExecutor;

/**
 * @author sunjian.
 */
public class Entrance {


    public static void main(String[] args) throws Exception {

        System.out.println("start...");

        final Mission bar = new BarChartOption("柱状图");
        final Mission pie = new PieChartOption("饼图");
        final Mission table = new TableOption("表格");

        final MissionExecutor barExecutor = new MissionExecutor(bar);
        final MissionExecutor pieExecutor = new MissionExecutor(pie);
        final MissionExecutor tableExecutor = new MissionExecutor(table);

        final Object barResult = barExecutor.call();
        final Object pieResult = pieExecutor.call();
        final Object tableResult = tableExecutor.call();

        System.out.println(barResult);
        System.out.println(pieResult);
        System.out.println(tableResult);
        //----------------------------
//        System.out.println(bmi(56.9, 1.70));
    }

    private static Double bmi(double weight, double height) {
        return weight / (height * height);
    }
}
