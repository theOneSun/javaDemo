package study.asynchronous.behavior;

import lombok.Getter;

/**
 * @author sunjian.
 */
@Getter
public class BarChartOption implements Mission{
    private final String information;

    public BarChartOption(String information) {
        this.information = information;
    }

    @Override
    public Object execute() {
        return information;
    }
}
