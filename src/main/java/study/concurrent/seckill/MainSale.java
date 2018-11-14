package study.concurrent.seckill;

/**
 * 售卖主方法
 * @author sunjian.
 */
public class MainSale
{
    public static void main(String args[]){
        SaleGoodsThread way1 = new SaleGoodsThread("网络售卖");
//        SaleGoodsThread way1 = new SaleGoodsThread();
//        SaleGoodsThread way2 = new SaleGoodsThread("网络售票");
        Thread thread1 = new Thread(way1,"天猫");
        Thread thread2 = new Thread(way1,"京东");
        thread1.start();
        thread2.start();
    }
}
