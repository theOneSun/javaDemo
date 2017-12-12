package study.idata3dsimulate.bridge;


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
