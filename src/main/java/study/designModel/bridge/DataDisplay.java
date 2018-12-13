package study.designModel.bridge;

/**
 * @author sunjian.
 */
public abstract class DataDisplay {

    /**
     * 根据分类的页面参数返回批次的查询参数
     *
     * @param categoryParam 分类的页面参数
     * @return 批次的查询参数
     */
    abstract String getDataBatch();
}
