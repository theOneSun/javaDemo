package refactoring.replacetypecode.withstrategy.tree;

import lombok.Data;
import lombok.NoArgsConstructor;
import study.newClass.domain.IndexTree;

import java.util.ArrayList;
import java.util.List;

/**
 * 满意度树
 *
 * @author sunjian.
 */
@Data
@NoArgsConstructor
public class SatisfactionTree {
    /**
     * 名称
     */
    private String name;
    /**
     * 得分
     */
    private Double score;
    /**
     * 权重
     */
    private Double weight;
    /**
     * 是否叶子结点
     */
    private boolean leaf;
    /**
     * 孩子节点集合
     */
    private List<IndexTree> children = new ArrayList<>();
}

