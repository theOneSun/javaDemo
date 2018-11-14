package study.compare;

import org.junit.Test;
import study.utils.UUIDUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 不同场景使用map和list的比较
 * @author sunjian.
 */
public class MapListCompare
{
    /**
     * 测试list遍历匹配取值和map.get取值的速度
     */
    @Test
    public void compareSpeedListAndMapGet(){
        /*
        设计思路
        list匹配学生的code
        map.get学生的code(时间还需要包含)
        -----------
        设置所有的某个属性
         */
        //初始化数据集合
        int dataMax=100000;
        List<Programmer> list = new ArrayList<>();
        for (int i = 0; i < dataMax; i++)
        {
            if (i / 2 == 0)
            {
                list.add(new Programmer(UUIDUtils.getUUID(), "呵呵" + i, Programmer.Gender.male));
            } else
            {
                list.add(new Programmer(UUIDUtils.getUUID(), "呵呵" + i, Programmer.Gender.female));
            }
        }
        //姓名集合
        List<Programmer> templateList = new ArrayList<>();
        for (int i = 0; i < dataMax; i++)
        {
            templateList.add(new Programmer(UUIDUtils.getUUID(), "呵呵" + i));
        }
        //-----操作list
        long listStart = System.currentTimeMillis();
        System.out.println("list开始:"+listStart);
        String name;
        for (Programmer programmer: templateList)
        {
            name = programmer.getName();
            for (Programmer p: list)
            {
                if (name.equals(p.getName())){
                    programmer.setGender(p.getGender());
                }
            }
        }
        long listEnd = System.currentTimeMillis();
        System.out.println("list结束:"+listEnd);
        System.out.println("list耗时:"+(listEnd - listStart));
        //-----操作map
        //转成map
        long mapStart = System.currentTimeMillis();
        System.out.println("map开始:"+mapStart);

        Map<String,Programmer> map = new HashMap<>();
        for (Programmer programmer : list)
        {
            map.put(programmer.getName(), programmer);
        }

        for (Programmer programmer : templateList)
        {
            name = programmer.getName();
            programmer.setGender(map.get(name).getGender());
        }
        long mapEnd = System.currentTimeMillis();
        System.out.println("map结束:"+mapEnd);
        System.out.println("map耗时:"+(mapEnd-mapStart));
    }
}
