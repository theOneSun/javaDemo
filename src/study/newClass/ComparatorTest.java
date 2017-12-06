package study.newClass;

import com.sun.deploy.util.StringUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author sunjian.
 */
public class ComparatorTest
{
    @Test
    public void testSort()
    {
        List<StudentInfo> infoList = new ArrayList<>();
        infoList.add(new StudentInfo("hehe1", "99", "12"));
        infoList.add(new StudentInfo("hehe2", "99", "12"));
        infoList.add(new StudentInfo("hehe3", null, null));
        infoList.add(new StudentInfo("hehe4", "0", "0"));
        infoList.add(new StudentInfo("hehe5", "14", null));
        infoList.add(new StudentInfo("hehe6", null, null));
        infoList.add(new StudentInfo("hehe7", "99", "14"));
        infoList.add(new StudentInfo("hehe8", "99", "10"));
        Comparator<StudentInfo> scoreComparator = (o1, o2) ->
        {
            String totalScore1 = o1.getTotalScore();
            String totalScore2 = o2.getTotalScore();
            String mathScore1 = o1.getMathScore();
            String mathScore2 = o2.getMathScore();
            //先判断一级,在判断二级
            if (totalScore1 == null || "".equals(totalScore1) || totalScore2 == null || "".equals(totalScore2))
            {
                if ((totalScore1 == null || "".equals(totalScore1)) && (totalScore2 != null && !"".equals(totalScore2)))
                {
                    return 1;
                } else if ((totalScore2 == null || "".equals(totalScore2)) && (totalScore1 != null && !"".equals(totalScore1)))
                {
                    return -1;
                } else
                {
                    return 0;
                }
            } else
            {
                //一级都不为空可以比较
                if (Integer.parseInt(totalScore1) < Integer.parseInt(totalScore2)) return 1;
                if (Integer.parseInt(totalScore1) > Integer.parseInt(totalScore2)) return -1;
                if (Integer.parseInt(totalScore1) == Integer.parseInt(totalScore2))
                {
                    //相同的情况
                    if (mathScore1 == null || "".equals(mathScore1) || mathScore2 == null || "".equals(mathScore2))
                    {
                        if ((mathScore1 == null || "".equals(mathScore1)) && (mathScore2 != null && !"".equals(mathScore2)))
                            return -1;
                        if ((mathScore2 == null || "".equals(mathScore2)) && (mathScore1 != null && !"".equals(mathScore1)))
                            return 1;
                        if ((mathScore1 == null || "".equals(mathScore1)) && (mathScore2 == null || "".equals(mathScore2)))
                            return 0;
                    } else
                    {
                        if (Integer.parseInt(mathScore1) < Integer.parseInt(mathScore2)) return 1;
                        if (Integer.parseInt(mathScore1) > Integer.parseInt(mathScore2)) return -1;
                        if (Integer.parseInt(mathScore1) == Integer.parseInt(mathScore2)) return 0;
                    }
                }
                return 0;
            }
        };

        List<StudentInfo> list = infoList.stream().sorted(scoreComparator).collect(Collectors.toList());
        for (StudentInfo info : list)
        {
            System.out.println(info.getName() + "---" + info.getTotalScore() + "---" + info.getMathScore());

        }
    }
}

class StudentInfo
{
    private String name;
    private String totalScore;
    private String mathScore;


    public StudentInfo()
    {
    }

    public StudentInfo(String name, String totalScore, String mathScore)
    {
        this.name = name;
        this.totalScore = totalScore;
        this.mathScore = mathScore;
    }

    public String getTotalScore()
    {
        return totalScore;
    }

    public void setTotalScore(String totalScore)
    {
        this.totalScore = totalScore;
    }

    public String getMathScore()
    {
        return mathScore;
    }

    public void setMathScore(String mathScore)
    {
        this.mathScore = mathScore;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
