package study.idata3dsimulate.bridge;

/**
 * 专用发票抬头
 * @author sunjian.
 */
public class SpecialInvoiceTitle extends InvoiceTitle
{
    private final InvoiceInfo.TitleType titleType = InvoiceInfo.TitleType.SPECIAL;

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
