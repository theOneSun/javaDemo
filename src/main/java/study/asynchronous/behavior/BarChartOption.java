package study.asynchronous.behavior;

import lombok.Data;

/**
 * @author sunjian.
 */
@Data
public class BarChartOption implements Mission{
    private String information;

    @Override
    public Object execute() {
        return null;
    }
}
