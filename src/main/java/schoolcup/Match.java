package schoolcup;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author sunjian.
 */
@Data
@NoArgsConstructor
class Match {
    private Integer number;
    /**
     * 开始时间
     */
    private LocalDateTime beginTime;
    /**
     * 结束时间
     */
    private LocalDateTime endTime;
    /**
     * 主队
     */
    private Team home;
    /**
     * 客队
     */
    private Team guest;
    /**
     * 轮空球队
     */
    private Team bye;

    @Override
    public String toString() {
        return "Match{" + "number=" + number + ", beginTime=" + beginTime + ", endTime=" + endTime + ", home=" + home.getName() + ", guest=" + guest
                .getName() + ", bye=" + bye.getName() + '}';
    }

    public Match(Integer number, Team home, Team guest, Team bye) {
        this.number = number;
        this.home = home;
        this.guest = guest;
        this.bye = bye;
    }
}
