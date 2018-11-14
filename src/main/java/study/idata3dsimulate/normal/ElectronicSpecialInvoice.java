package study.idata3dsimulate.normal;

/**
 * 电子专用发票
 * @author sunjian.
 */
public class ElectronicSpecialInvoice extends InvoiceInfo
{
    /**
     * 发票类型
     */
    private final Type type = Type.ELECTRONIC;
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
}
