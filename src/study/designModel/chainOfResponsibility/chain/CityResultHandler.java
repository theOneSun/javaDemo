package study.designModel.chainOfResponsibility.chain;

import study.designModel.chainOfResponsibility.ResultNotify;

/**
 * @author sunjian.
 */
public class CityResultHandler implements ResultHandler
{
    @Override
    public boolean handleResult(ResultNotify resultNotify, ResultHandlerChain resultHandlerChain)
    {
        //todo 判断应该增加的权限表的处理方式
        /*
        1.根据orderId查询product4user,得到productId
        2.根据一级和二级类目判断要插入的权限表以及处理逻辑
         */
        if ("city".equals(resultNotify.getBusinessCategory()))
        {
            if ("hotline".equals(resultNotify.getFunctionCategory()))
            {
                System.out.println("政府服务热线的订单已处理,订单号是"+resultNotify.getOrderId());
                return true;
            }
        }
        return resultHandlerChain.handleResult(resultNotify, resultHandlerChain);
    }
}
