package study.newClass.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author sunjian.
 */
public class IndexTree
{
    /**
     * 指标名称
     */
    private String indexName;
    /**
     * 得分
     */
    private Double score;
    /**
     * 权重
     */
    private Double heavy;
    /**
     * 是否叶子结点
     */
    private boolean leaf;
    /**
     * 孩子节点集合
     */
    private List<IndexTree> children = new ArrayList<>();

    public IndexTree()
    {
    }

    public IndexTree(String indexName)
    {
        this.indexName = indexName;
    }

    public IndexTree(String indexName, Double score, Double heavy, boolean leaf, List<IndexTree> children)
    {
        this.indexName = indexName;
        this.score = score;
        this.heavy = heavy;
        this.leaf = leaf;
        this.children = children;
    }

    public void addChild(String indexName)
    {
        this.addChild(new IndexTree(indexName));
    }

    public void addChild(IndexTree indexTree)
    {
        this.children.add(indexTree);
    }

    public List<IndexTree> allLeafChildren()
    {
        final List<IndexTree> leafChildrenList = new ArrayList<>();
        if (Objects.isNull(children) || children.size() == 0)
        {
            leafChildrenList.add(this);
        } else
        {
            for (IndexTree childIndex : this.children)
            {
                final List<IndexTree> indexTrees = childIndex.allLeafChildren();
                leafChildrenList.addAll(indexTrees);
            }
        }
        return leafChildrenList;
    }

    public String getIndexName()
    {
        return indexName;
    }

    public void setIndexName(String indexName)
    {
        this.indexName = indexName;
    }

    public Double getScore()
    {
        return score;
    }

    public void setScore(Double score)
    {
        this.score = score;
    }

    public Double getHeavy()
    {
        return heavy;
    }

    public void setHeavy(Double heavy)
    {
        this.heavy = heavy;
    }

    public boolean isLeaf()
    {
        return leaf;
    }

    public void setLeaf(boolean leaf)
    {
        this.leaf = leaf;
    }

    public List<IndexTree> getChildren()
    {
        return children;
    }

    public void setChildren(List<IndexTree> children)
    {
        this.children = children;
    }

    @Override
    public String toString()
    {
        return "IndexTree{" + "indexName='" + indexName + '\'' + ", score=" + score + ", heavy=" + heavy + '}';
    }
}
