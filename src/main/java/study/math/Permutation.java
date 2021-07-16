package study.math;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 排列组合
 *
 * @author sunjian.
 */
public class Permutation {
    /**
     * 组合C(m,n) m里取n个数
     *
     * @param pm 总数
     * @param pn 单次取出的数量
     * @return 组合结果
     */
    public List<List<Integer>> combination(final int pm, final int pn) {
        int m = pm;
        int n = pn;
        List<List<Integer>> resultList = new ArrayList<>();
        if (pm < pn) {
            throw new IllegalArgumentException("m < n");
        }

        //初始化一个数值集合
        List<Integer> templateList = new LinkedList<>();
        for (int i = 1; i <= m; i++) {
            templateList.add(i);
        }
        //如果m==n或者n==0,则直接返回1
        if (n == 0) {
            resultList.add(templateList);
            return resultList;
        }
        //常规计算
        for (int i = 1; i <= m; i++) {
            //在m个里面拿n个
            //            templateList.
        }

        return null;
    }

    //
    Integer[] template = new Integer[]{1, 2, 3, 4, 5};

    //在集合中取C(m,n)n中取m个数
    private String[] fetch(List<Integer> currentResult,int pm,int pn,List<Integer> srcList) {

        //test C(5,3)
        for (int i = 0; i < srcList.size(); i++) {

        }
        for (int i = 0; i < 6; i++) {
            final Integer integer = template[i];
            currentResult.add(integer);
        }
        return null;
    }

    /*public static void main(String[] args) {
        Integer[] template = new Integer[]{1, 2, 3, 4, 5};

        final int wantedCount = 2;
        int tempCount = 0;
        List<Integer> tempResult;
        List<Integer> tempTemplate = new ArrayList<>();
        Collections.addAll(tempTemplate, template);
        for (int i = 0; i < template.length; i++) {
            //循环取第一个数
            final Integer first = tempTemplate.get(i);
            for (int j = i + 1; j < tempTemplate.size(); j++) {
                final Integer second = tempTemplate.get(j);
                final Integer[] result = {first, second};
                System.out.println(++tempCount + ArrayUtils.toString(result));
            }
        }
    }*/
}
