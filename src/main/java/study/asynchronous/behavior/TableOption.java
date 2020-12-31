package study.asynchronous.behavior;

import lombok.Getter;

/**
 * @author sunjian.
 */
@Getter
public class TableOption implements Mission{
    private final String information;

    public TableOption(String information) {
        this.information = information;
    }

    @Override
    public Object execute() {
        try {
            Thread.sleep(1000*5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return information;
    }
}
