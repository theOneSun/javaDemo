package study.tree;

import lombok.Data;

import java.util.List;

/**
 * T 是继承的子类自身
 * @author sunjian.
 */
@Data
public abstract class BaseTree<K, V, T> {
    private K key;
    private V Value;
    private boolean leaf;
    private List<T> children;

    public BaseTree(final K key) {
        this.key = key;
    }
}
