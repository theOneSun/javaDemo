package refactoring.replacetypecode.withstrategy;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author sunjian.
 */
public class TreeDemo {
    public static void main(String[] args) {
        Set<String> result = new LinkedHashSet<>();
        result.add("hehe");
        result.add("haha");
        result.add("heihei");
        result.add("aa");
        result.add("ww");
        result.add("ss");
        Set<String> addSet = new HashSet<>();
        addSet.add("hehe");
        addSet.add("haha");
        addSet.add("lalala");
        result.addAll(null);



        result.forEach(System.out::println);
    }
}
