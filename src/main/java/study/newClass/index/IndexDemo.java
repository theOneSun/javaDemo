package study.newClass.index;

import org.junit.Test;
import study.newClass.domain.IndexTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author sunjian.
 */
public class IndexDemo
{
    @Test
    public void testArrayGroupBy()
    {
        String[] a1 = new String[]{"软件", "职业形象", "着装"};
        String[] a2 = new String[]{"软件", "职业形象", "工牌"};
        String[] a3 = new String[]{"软件", "职业形象", "仪容仪表"};
        String[] a4 = new String[]{"软件", "职业形象", "语言"};
        String[] a5 = new String[]{"软件", "职业形象", "行为举止"};
        String[] a6 = new String[]{"软件", "大堂经理", "大堂经理-亲和力"};
        String[] a7 = new String[]{"软件", "大堂经理", "大堂经理-主动性"};
        String[] a8 = new String[]{"软件", "大堂经理", "大堂经理-业务咨询"};
        String[] a9 = new String[]{"软件", "保安", "保安-履职情况"};
        String[] a10 = new String[]{"软件", "保安", "保安-职业形象"};


        List<String[]> indexList = new ArrayList<>();
        indexList.add(a1);
        indexList.add(a2);
        indexList.add(a3);
        indexList.add(a4);
        indexList.add(a5);
        indexList.add(a6);
        indexList.add(a7);
        indexList.add(a8);
        indexList.add(a9);
        indexList.add(a10);


        //封装tree
        //根节点不管是查一个指标还是下级指标的,根节点都是root
        IndexTree indexRoot = new IndexTree("root");

        fillIndexTree(indexRoot, indexList, null);
        System.out.println(indexRoot);

        //测试获得所有叶子结点
        final List<IndexTree> leafIndex = indexRoot.allLeafChildren();
        leafIndex.forEach(System.out::println);

    }

    private void fillIndexTree(IndexTree indexTree, List<String[]> indexList, List<String> indexParam)
    {
        int indexParamLength = 0;
        //        List<String> indexParamList = new ArrayList<>();
        if (Objects.isNull(indexParam) || indexParam.size() == 0)
        {
            //没有指标参数
            System.out.println("没有指标参数");
            indexParam = new ArrayList<>();
        } else
        {
            //有指标参数
            indexParamLength = indexParam.size();
        }
        if (Objects.isNull(indexTree))
        {
            throw new RuntimeException("wrong");
        }

        if (Objects.isNull(indexList))
        {
            throw new RuntimeException("wrong");
        }

        final int length = indexParamLength;
        //计算分组的指标的位置

        final Map<String, List<String[]>> map = indexList.stream()
                                                         .collect(Collectors.groupingBy(indexes -> indexes[length]));

        for (Map.Entry<String, List<String[]>> entry : map.entrySet())
        {
            final String indexName = entry.getKey();
            final List<String[]> valueList = entry.getValue();
            //创建子对象
            final IndexTree childTree = new IndexTree(indexName);
            //添加孩子节点
            indexTree.addChild(childTree);
            // 指标参数后再追加一个
            if (!Objects.isNull(valueList) && valueList.size() > 0)
            {
                //获取第一个数组的长度
                final int indexLength = valueList.get(0).length - 1;
                if (length < indexLength)
                {
                    List<String> childIndexParam = new ArrayList<>(indexParam);
                    childIndexParam.add(indexName);
                    fillIndexTree(childTree, valueList, childIndexParam);
                }

            }
        }
    }

    @Test
    public void testReference(){

        IndexTree indexRoot = new IndexTree("root");
        IndexTree indexRoot2 = new IndexTree();
        indexRoot2 = indexRoot;
        indexRoot2.setIndexName("as");
        System.out.println(indexRoot.getIndexName());
    }
}
