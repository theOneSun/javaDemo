package sudoku.domain;

import java.util.Set;

/**
 * 候选功能
 * @author sunjian.
 */
public interface Candidate {
    //获取候选数
    Set<Integer> getCandidates();

    //清空候选数
    void clear();

    //删除候选值
    boolean removeCandidate(int deleteCandidate);

    boolean removeCandidates(Set<Integer> deleteCandidates);

    //todo 增加一些特殊情况的候选数判断,例如双数组和三数组
}
