package study.designModel.chainOfResponsibility;

/**
 * Created by sj on 2017/12/28.
 */
public class EntranceResultHandler extends ResultHandler {
    @Override
    public void handleRequest(ResultNotify resultNotify) {
        //参数校验
        if (null == resultNotify) {
            System.out.println("参数为空");
        } else {
            getSuccessor().handleRequest(resultNotify);

        }
    }
}
