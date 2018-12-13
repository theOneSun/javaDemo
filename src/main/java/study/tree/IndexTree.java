package study.tree;

import lombok.Data;

/**
 * @author sunjian.
 */
@Data
public class IndexTree extends BaseTree<String,Double, study.tree.IndexTree>{

    //权重
    private Double weight;

    public IndexTree(String key) {
        super(key);
    }
}
