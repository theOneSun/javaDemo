package refactoring.replacetypecode.withstrategy.tree;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunjian.
 */
@Data
public class TreeNode{
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
    private List<TreeNode> children = new ArrayList<>();
}
