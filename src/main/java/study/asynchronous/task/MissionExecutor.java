package study.asynchronous.task;

import study.asynchronous.behavior.Mission;

import java.util.concurrent.Callable;

/**
 * @author sunjian.
 */
public class MissionExecutor implements Callable {
    private final Mission mission;

    public MissionExecutor(Mission mission) {
        this.mission = mission;
    }

    @Override
    public Object call() throws Exception {
        return mission.execute();
    }
}
