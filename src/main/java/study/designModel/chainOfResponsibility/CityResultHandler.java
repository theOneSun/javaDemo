package study.designModel.chainOfResponsibility;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sj on 2017/12/28.
 */
public class CityResultHandler extends ResultHandler {
    @Override
    public void handleRequest(ResultNotify resultNotify) {
        List<String> cityOrderList = new ArrayList<>();
        for (int i=0;i<5;i++){
            cityOrderList.add("city"+i);
        }
        String orderId = resultNotify.getOrderId();
        if (cityOrderList.contains(orderId)){
            System.out.println("city处理了"+resultNotify.getMoney());
        }else {
            getSuccessor().handleRequest(resultNotify);
        }
    }
}
