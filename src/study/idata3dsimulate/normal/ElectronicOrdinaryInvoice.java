package study.idata3dsimulate.normal;

/**
 * 电子个人发票
 * @author sunjian.
 */
public class ElectronicOrdinaryInvoice extends InvoiceInfo
{
    /**
     * 发票类型
     */
    private final Type type = Type.ELECTRONIC;
    /**
     * 发票抬头类型
     */
    private final TitleType titleType = TitleType.ORDINARY;
}
