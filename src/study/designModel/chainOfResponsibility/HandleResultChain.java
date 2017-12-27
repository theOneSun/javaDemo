package study.designModel.chainOfResponsibility;

/**
 * Created by sj on 2017/12/28.
 */
public class HandleResultChain {
    public static void main(String[] args) {
        ResultHandler carResultHandler = new CarResultHandler();
        ResultHandler cityResultHandler = new CityResultHandler();
        ResultHandler mealResultHandler = new MealResultHandler();
        ResultHandler entranceResultHandler = new EntranceResultHandler();

        cityResultHandler.setSuccessor(carResultHandler);
        carResultHandler.setSuccessor(mealResultHandler);
        entranceResultHandler.setSuccessor(cityResultHandler);


        ResultNotify resultNotify1 = new ResultNotify("1", 10, "city1");
        ResultNotify resultNotify2 = new ResultNotify("2", 20, "car2");
        ResultNotify resultNotify3 = new ResultNotify("3", 30, "meal3");

        //测试调用
        entranceResultHandler.handleRequest(resultNotify1);
        entranceResultHandler.handleRequest(resultNotify2);
        entranceResultHandler.handleRequest(resultNotify3);

    }
}
