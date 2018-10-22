package study.threadTest;

/**
 * @author sunjian.
 */
public class Calculator
{
    private static Calculator calculator = null;

    private Calculator()
    {
    }

    public static Calculator getCalculator()
    {
        if (calculator == null)
        {
            synchronized (Calculator.class)
            {
                if (calculator == null)
                {
                    calculator = new Calculator();
                }
            }
        }
        return calculator;
    }


    public void calculate(String algorithm)
    {
        switch (algorithm)
        {
            case "tier":
                System.out.println("逐层计算");
                break;
            case "bottom":
                System.out.println("末级计算");
                break;
            default:
                System.out.println("参数错误");
        }
    }
}
