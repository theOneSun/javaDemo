package study.baseTest;

import org.junit.Test;

import java.text.Collator;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/**
 * @author sunjian.
 */
public class FirstLetterGroupSortTest
{
    @Test
    public void testGroupByFirstLetter(){
        Set<String> nameSet = new HashSet<>();
        nameSet.add("张三");
        nameSet.add("李四");
        nameSet.add("王五");
        nameSet.add("赵六");
        nameSet.add("帕克");
        nameSet.add("梅西");
        nameSet.add("保利尼奥");
        nameSet.add("巴洛特利");
        nameSet.add("巴神");
        nameSet.add("戈麦斯");
        nameSet.add("郜林");

        Comparator comparator = Collator.getInstance(java.util.Locale.CHINA);
        String[] nameArray = nameSet.toArray(new String[nameSet.size()]);
        // 使根据指定比较器产生的顺序对指定对象数组进行排序。
        Arrays.sort(nameArray, comparator);
        for (String aNameArray : nameArray) System.out.println(aNameArray);
    }
}
