package study.idata3dsimulate;


/**
 * 发票信息
 *
 * @author zhangpeng
 */
public class InvoiceInfo
{
    /**
     * 发票类型
     */
    private Type type;
    /**
     * 发票抬头类型
     */
    private TitleType titleType;
    /**
     * 发票抬头
     */
    private String title;
    /**
     * 纳税人识别号
     */
    private String taxpayerIdentificationNumber;
    /**
     * 发票金额
     */
    private int money;
    /**
     * 地址
     */
    private String address;
    /**
     * 联系电话
     */
    private String phoneNumber;
    /**
     * 开户行
     */
    private String bankName;
    /**
     * 开户行账号
     */
    private String accountNumber;
    /**
     * 收件人
     */
    private String receiver;
    /**
     * 手机号码
     */
    private String receiverPhoneNumber;
    /**
     * 地区信息
     */
    private String districtInfo;
    /**
     * 运费
     */
    private int freight;
    /**
     * 是否货到付款
     */
    private boolean cashOnDelivery;

    public enum Type
    {
        /**
         * 电子发票
         */
        ELECTRONIC,
        /**
         * 纸质发票
         */
        PAPER
    }

    public enum TitleType
    {
        /**
         * 普通
         */
        ORDINARY,
        /**
         * 专用
         */
        SPECIAL
    }
}
