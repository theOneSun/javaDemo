package study.poi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.ObjectUtils;

import java.util.LinkedList;
import java.util.List;
import java.util.OptionalInt;

/**
 * @author sunjian.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
class FsIndex {
    private String id;
    private String name;
    private String parentId;
    private Integer level;
    private List<FsIndex> children = new LinkedList<>();

    public FsIndex(String id, String name, String parentId, Integer level) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
        this.level = level;
        this.children = new LinkedList<>();
    }

    public FsIndex(String id, String name, Integer level) {
        this.id = id;
        this.name = name;
        this.level = level;
    }

    public void addChild(FsIndex fsIndex) {
        fsIndex.setParentId(this.id);
        this.children.add(fsIndex);
    }

    public boolean isLeaf() {
        return ObjectUtils.isEmpty(this.children);
    }

    public Integer getMaxLength() {
        if (isLeaf()) {
            return 1;
        } else {
            return this.children.stream().mapToInt(FsIndex::getMaxLength).sum();
        }
    }

    public Integer getMaxDeep() {
        if (isLeaf()) {
            return 1;
        } else {
            final OptionalInt max = this.children.stream().mapToInt(FsIndex::getMaxLength).max();
            return max.orElse(0);
        }
    }
}
