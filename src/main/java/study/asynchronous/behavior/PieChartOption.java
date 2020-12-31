package study.asynchronous.behavior;

import lombok.Getter;

/**
 * @author sunjian.
 */
@Getter
public class PieChartOption implements Mission {
    private final String information;

    public PieChartOption(String information) {
        this.information = information;
    }

    @Override
    public Object execute() {
        try {
            Thread.sleep(1000 * 3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return information;
    }
}
