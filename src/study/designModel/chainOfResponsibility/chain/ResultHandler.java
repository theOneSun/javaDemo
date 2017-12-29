package study.designModel.chainOfResponsibility.chain;

import study.designModel.chainOfResponsibility.ResultNotify;

/**
 * @author sunjian.
 */
public interface ResultHandler
{
    /**
     * 示意处理请求的方法，虽然这个示意方法是没有传入参数的
     * 但实际是可以传入参数的，根据具体需要来选择是否传递参数
     */
    boolean handleResult(ResultNotify resultNotify, ResultHandlerChain resultHandlerChain);
}
