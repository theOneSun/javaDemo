package life.manufacturing;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.LinkedHashMap;

/**
 * 零件
 * @author sunjian.
 */
@AllArgsConstructor
@Data
class Part {
    private LinkedHashMap<Integer,Integer> stationTime;
    private int count;
    private Status status = Status.READY;

    Part(LinkedHashMap<Integer, Integer> stationTime, int count) {
        this.stationTime = stationTime;
        this.count = count;
    }

    enum Status{
        //准备
        READY,
        //加工中
        UNDERWAY,
        //加工完成
        FINISHED,

    }
}
