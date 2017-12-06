package study.newClass.domain;


import java.math.BigDecimal;
import java.time.YearMonth;

/**
 * @author sunjian.
 */
public class IndicatorIndexScoreVO
{
    private String areaName;
    private BigDecimal indexScore;
    private YearMonth dataTime;
    private int rank;//排名

    public IndicatorIndexScoreVO()
    {
    }

    public IndicatorIndexScoreVO(String areaName, BigDecimal indexScore, YearMonth dataTime)
    {
        this.areaName = areaName;
        this.indexScore = indexScore;
        this.dataTime = dataTime;
    }

    public IndicatorIndexScoreVO(String areaName, BigDecimal indexScore, YearMonth dataTime, int rank)
    {
        this.areaName = areaName;
        this.indexScore = indexScore;
        this.dataTime = dataTime;
        this.rank = rank;
    }

    public String getAreaName()
    {
        return areaName;
    }

    public void setAreaName(String areaName)
    {
        this.areaName = areaName;
    }

    public BigDecimal getIndexScore()
    {
        return indexScore;
    }

    public void setIndexScore(BigDecimal indexScore)
    {
        this.indexScore = indexScore;
    }

    public YearMonth getDataTime()
    {
        return dataTime;
    }

    public void setDataTime(YearMonth dataTime)
    {
        this.dataTime = dataTime;
    }

    public int getRank()
    {
        return rank;
    }

    public void setRank(int rank)
    {
        this.rank = rank;
    }

    @Override
    public String toString()
    {
        return "IndicatorIndexScoreVO{" + "areaName='" + areaName + '\'' + ", indexScore=" + indexScore + ", dataTime=" + dataTime + ", rank=" + rank + '}';
    }
}
