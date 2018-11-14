package study.designModel.adapter2;

/**
 * @author sunjian.
 */
public class ThreeSocketImpl implements ThreeSocket
{
    @Override
    public void powerWithThree()
    {
        System.out.println("使用三相插座充电");
    }
}
