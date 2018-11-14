package study.extendsTest.thisText;

/**
 * @author sunjian.
 */
public class BottomCalculator extends BaseCalculator implements Calculator
{
    @Override
    public Calculator selectCalculator(String param)
    {
        if (param.equals("")) {
            return this;
        }
        else {
            return null;
        }
    }
}
