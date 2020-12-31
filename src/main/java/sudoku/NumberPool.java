package sudoku;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Stack;

/**
 * 数池
 * 1~9
 *
 * @author sunjian.
 */
public class NumberPool {
    final private Set<Integer> numbers = new LinkedHashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

    final private Stack<Integer> numberStack = initStack();

    private Stack<Integer> initStack() {
        final Stack<Integer> stack = new Stack<>();
        for (int i = 1; i < 10; i++) {
            stack.push(i);
        }
        return stack;
    }

    //取值
    public void pop(Integer number) {
        if (numbers.contains(number)) {
            numbers.remove(number);
        } else {
            throw new RuntimeException("没这个数了");
        }
    }

    public void put(Integer number) {
        if (numbers.contains(number)) {
            throw new RuntimeException("数已存在");
        } else {
            numbers.add(number);
        }
    }
}
