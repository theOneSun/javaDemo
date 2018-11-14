package study.designModel.adapter2;

/**
 * 适配器
 * @author sunjian.
 */
public class ThreeSocketAdapter implements ThreeSocket
{
    private TwoSocket twoSocket;

    public ThreeSocketAdapter(TwoSocket twoSocket)
    {
        this.twoSocket = twoSocket;
    }

    public TwoSocket getTwoSocket()
    {
        return twoSocket;
    }

    public void setTwoSocket(TwoSocket twoSocket)
    {
        this.twoSocket = twoSocket;
    }

    @Override
    public void powerWithThree()
    {
        System.out.println("转换插座");
        this.twoSocket.powerWithTwo();
    }
}
