package refactoring.replacetypecode.withstrategy.tree;

import lombok.Data;
import lombok.NoArgsConstructor;
import refactoring.replacetypecode.withstrategy.gardener.TreeGardener;

/**
 * 根节点
 * @author sunjian.
 */
@Data
public abstract class TreeRoot{

    private String name;

    private Double score;

    private TreeGardener treeGardener;

    public TreeRoot(TreeGardener treeGardener) {
        this.treeGardener = treeGardener;
    }

    abstract void fillNode(TreeGardener treeGardener);
}
