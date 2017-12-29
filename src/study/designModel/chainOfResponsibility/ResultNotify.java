package study.designModel.chainOfResponsibility;

/**
 * 结果通知
 * Created by sj on 2017/12/28.
 */
public class ResultNotify {
    private String id;
    private int money;
    private String orderId;
    private String businessCategory;
    private String functionCategory;

    public ResultNotify() {
    }

    public ResultNotify(String id, int money, String orderId) {
        this.id = id;
        this.money = money;
        this.orderId = orderId;
    }

    public ResultNotify(String id, int money, String orderId, String businessCategory, String functionCategory)
    {
        this.id = id;
        this.money = money;
        this.orderId = orderId;
        this.businessCategory = businessCategory;
        this.functionCategory = functionCategory;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getBusinessCategory()
    {
        return businessCategory;
    }

    public void setBusinessCategory(String businessCategory)
    {
        this.businessCategory = businessCategory;
    }

    public String getFunctionCategory()
    {
        return functionCategory;
    }

    public void setFunctionCategory(String functionCategory)
    {
        this.functionCategory = functionCategory;
    }
}
