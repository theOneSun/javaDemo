package schoolcup;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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

    /**
     * 主队进球
     */
    private Integer homeGoal;
    /**
     * 客队进球
     */
    private Integer guestGoal;
    /**
     * 主队黄牌
     */
    private Integer homeYellow;
    /**
     * 客队黄牌
     */
    private Integer guestYellow;
    /**
     * 主队红牌
     */
    private Integer homeRed;
    /**
     * 客队黄牌
     */
    private Integer guestRed;


    public Match(Integer number, Team home, Team guest, Team bye) {
        this.number = number;
        this.home = home;
        this.guest = guest;
        this.bye = bye;
    }
}
