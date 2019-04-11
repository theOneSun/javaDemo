package life;

/**
 * 计算月卡是否划算
 *
 * @author sunjian.
 */
public class SubwayPay {
    //当月工作日天数
    private static final int workDay = 17;
    //每次乘坐金额
    private static final double price = 6;
    //使用打折卡的单价
    private static final double disCountPrice = 6 * 0.8;


    public static void main(String[] args) {

        printByWorkDay();
        printByPrice();
    }

    //计算没用打折卡的次数
    private static double original(double price, int frequency) {
        double cost = 0;
        for (int i = 1; i <= frequency; i++) {
            if (cost < 100) {
                cost += price;
            } else if (cost >= 100 && cost < 150) {
                cost += price * 0.8;
            } else {
                cost += price * 0.5;
            }
        }
        return cost;
    }

    private static void printByWorkDay() {
        for (int i = 20; i <= 25; i++) {
            //计算当月乘坐次数
            final int frequency = 2 * i;
            final double original = original(price, frequency);
            final double discount = original(disCountPrice, frequency);
            System.out.println();
            System.out.println("当乘坐日是 " + i + " 日时: ");
            System.out.println("使用月卡之前的消费是: " + original);
            System.out.println("使用月卡之后的消费是: " + discount);
            System.out.println("可节约: " + (original - discount));

            System.out.println("看看是否相等:" + original * 0.2);
        }
    }

    private static void printByPrice() {
        for (int i = 3; i <= 8; i++) {
            //计算当月乘坐次数
            final int frequency = 2 * workDay;
            final double original = original(i, frequency);
            final double discount = original(i * 0.8, frequency);
            System.out.println();
            System.out.println("当单程票价是" + i + "元时:");
            System.out.println("使用月卡之前的消费是: " + original);
            System.out.println("使用月卡之后的消费是: " + discount);
            System.out.println("可节约: " + (original - discount));
        }
    }
}
