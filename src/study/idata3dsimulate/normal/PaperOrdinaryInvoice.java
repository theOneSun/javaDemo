package study.idata3dsimulate.normal;

/**
 * 纸质个人发票
 * @author sunjian.
 */
public class PaperOrdinaryInvoice extends InvoiceInfo
{

    /**
     * 发票类型
     */
    private final Type type = Type.PAPER;
    /**
     * 发票抬头类型
     */
    private final TitleType titleType = TitleType.ORDINARY;
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
