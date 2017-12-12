package study.idata3dsimulate.bridge;

import study.idata3dsimulate.bridge.InvoiceInfo;

/**
 * 电子专用
 * @author sunjian.
 */
public class PaperInvoice extends InvoiceInfo
{
    private final Type type = Type.ELECTRONIC;
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
