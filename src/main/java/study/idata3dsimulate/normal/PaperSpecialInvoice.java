package study.idata3dsimulate.normal;

/**
 * 纸质专用发票
 * @author sunjian.
 */
public class PaperSpecialInvoice extends InvoiceInfo
{
    /**
     * 发票类型
     */
    private final Type type = Type.PAPER;
    /**
     * 发票抬头类型
     */
    private final TitleType titleType = TitleType.SPECIAL;
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
}
