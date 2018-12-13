package study.tree;

import lombok.Data;

import java.util.List;

/**
 * 森林
 * @author sunjian.
 */
@Data
public class Woods {
    private String name;
    List<IndexTree> trees;
}
