package study.designModel.adapter2;

/**
 * @author sunjian.
 */
public class Hotel
{
    private ThreeSocket threeSocket;

    public Hotel(ThreeSocket threeSocket)
    {
        this.threeSocket = threeSocket;
    }

    public void charge(){
        this.threeSocket.powerWithThree();
    }

    public ThreeSocket getThreeSocket()
    {
        return threeSocket;
    }

    public void setThreeSocket(ThreeSocket threeSocket)
    {
        this.threeSocket = threeSocket;
    }
}
