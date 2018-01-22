package study.designModel.adapter2;

/**
 * @author sunjian.
 */
public class Demo
{
    public static void main(String[] args)
    {
        ThreeSocket threeSocket = new ThreeSocketImpl();
        Hotel hotel = new Hotel(threeSocket);
        hotel.charge();
        System.out.println("---------------------");
        TwoSocket twoSocket = new TwoSocketImpl();
        ThreeSocketAdapter adapter = new ThreeSocketAdapter(twoSocket);
        Hotel hotel2 = new Hotel(adapter);
        hotel2.charge();
        System.out.println("---------------------");
        TwoSocket bestSocket = new BestSocketImpl();
        ThreeSocketAdapter adapter2 = new ThreeSocketAdapter(bestSocket);
        Hotel hotel3 = new Hotel(adapter2);
        hotel3.charge();
    }
}
