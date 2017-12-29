package study.designModel.chainOfResponsibility.chain;

import study.designModel.chainOfResponsibility.ResultNotify;

import java.util.ArrayList;
import java.util.List;

/**
 * 责任链
 *
 * @author sunjian.
 */
public class ResultHandlerChain implements ResultHandler
{
    private List<ResultHandler> resultHandlerList = new ArrayList<>();
    private int index = 0;

    public ResultHandlerChain addResultHandler(ResultHandler resultHandler)
    {
        resultHandlerList.add(resultHandler);
        return this;
    }

    @Override
    public boolean handleResult(ResultNotify resultNotify, ResultHandlerChain chain)
    {
        if (index == resultHandlerList.size())
        {
            return false;
        } else
        {
            ResultHandler resultHandler = resultHandlerList.get(index);
            index++;
            return resultHandler.handleResult(resultNotify, chain);
        }
    }
}
