package study.baseTest;

import com.sun.org.apache.bcel.internal.generic.NEWARRAY;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;
import study.baseTest.domain.Student;
import study.io.User;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

/**
 * @authur sunjian.
 */
public class ListTest {
    @Test
    public void testContainsAll() {
        List<String> openList = new ArrayList<>();
        openList.add("1");
        openList.add("2");
        openList.add("3");
        openList.add("4");
        openList.add("5");
        openList.add("6");
        openList.add("7");
        List<String> checkList = new ArrayList<>();
        checkList.addAll(openList);
        checkList.add("8");

        System.out.println(checkList.containsAll(openList));
        System.out.println(openList.containsAll(checkList));

    }

    @Test
    public void testContains() {
        List<Student> studentList = new ArrayList<>();
        Student messi = new Student(1, "Messi", "男");
        studentList.add(messi);
        studentList.add(new Student(2, "C.Ronaldo", "男"));
        studentList.add(new Student(3, "Havi", "男"));

        Student student = new Student(1, "Messi", "男");

        boolean contains = studentList.contains(student);
        System.out.println(contains);
        System.out.println(messi.equals(student));
        System.out.println(studentList.contains(messi));
    }

    @Test
    public void testRemoveAll() {
        List<Integer> writeList = new ArrayList<>();
        List<Integer> removeList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            writeList.add(i);
            removeList.add(i);
        }
        removeList.remove(0);
        removeList.add(11);

        boolean b = writeList.removeAll(removeList);
        System.out.println(b);
        System.out.println(writeList);
    }

    @Test
    public void testNull() throws Exception {
        List<Double> list = new ArrayList<>();
        list.add(null);
        list.add(null);
        System.out.println(list.size());
    }

    @Test
    public void testInsert() throws Exception {
        //        String searchContent = "奇瑞 路虎 揽胜 路虎";
        String searchContent = "奇瑞 揽胜";

        String[] splitArray = searchContent.split(" ");
        List<String> list = Arrays.asList(splitArray);
        List<String> list2;

        //        List<String> list2 = new ArrayList<>(list.size()+1);
        //        list2.addAll(list);
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i <= list.size(); i++) {
            list2 = new ArrayList<>(list.size() + 1);
            list2.addAll(list);
            list2.add(i, "路虎");
            list2.forEach(System.out::println);
            System.out.println("-----------");
            map.put("路虎" + i, list2);
        }

        Set<Map.Entry<String, List<String>>> entrySet = map.entrySet();
        for (Map.Entry<String, List<String>> entry : entrySet) {
            System.out.println(entry);
        }
        //        list2.add(0,"路虎");
        //        list2.add(1,"路虎");
        //        list2.forEach(System.out::println);
    }

    //测试指定位置插入
    @Test
    public void testAddIndex() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add(0, "0");
        System.out.println(list.size());
    }

    /**
     * 测试final能不能添加
     * 结果可以
     */
    @Test
    public void testFinalAdd() {
        final List<String> list = new ArrayList<>();
        list.add("1");
        list.add(0, "0");
        System.out.println(list.size());
    }

    @Test
    public void testSize(){
        String[] playerArray = {"Messi", "C.罗", "苏亚雷斯", "内马尔", "哈维", "伊涅斯塔", "库蒂尼奥", "布斯克茨", "罗纳尔迪尼奥"};
        List<String> players = new ArrayList<>(playerArray.length);
        Collections.addAll(players,playerArray);

        List<String> list = new ArrayList<>();
//        Collections.copy(players,list);
        //--------------------------------------------------
        String[] roleArray = {"平民", "平民", "平民", "狼人", "狼人", "狼人", "女巫", "猎人", "预言家","守卫"};
        List<String> roles = new ArrayList<>(roleArray.length);
        Collections.addAll(roles,roleArray);
        CollectionUtils.addAll(roles,players);

        Collections.copy(roles,players);
        System.out.println(roles.toString());

        System.out.println(roles.size());
    }

    //测试完了删了
    @Test
    public void distributeRole() {
        final int playerNumber = 9;
        final Random random = new Random();
       /* List<String> players = Arrays.asList("Messi", "C.罗", "苏亚雷斯", "内马尔", "哈维", "伊涅斯塔", "库蒂尼奥", "布斯克茨", "罗纳尔迪尼奥");
        List<String> roles = Arrays.asList("平民", "平民", "平民", "狼人", "狼人", "狼人", "女巫", "猎人", "预言家");*/

        String[] playerArray = {"Messi", "C.罗", "苏亚雷斯", "内马尔", "哈维", "伊涅斯塔", "库蒂尼奥", "布斯克茨", "罗纳尔迪尼奥"};
        String[] roleArray = {"平民", "平民", "平民", "狼人", "狼人", "狼人", "女巫", "猎人", "预言家"};

        List<String> players = new ArrayList<>(playerArray.length);
        List<String> roles = new ArrayList<>(roleArray.length);

        Collections.addAll(players,playerArray);
        Collections.addAll(roles,roleArray);

        Collections.shuffle(players);
        Collections.shuffle(roles);

        Map<String,String> playerRoleMap = new HashMap<>();
        for (int i = 0; i <playerNumber ; i++) {
            final String player = players.get(i);
//            final int roleIndex = random.nextInt(roles.size());
            /*final String role = roles.get(roleIndex);
            roles.remove(role);*/
            final String role = roles.get(i);
            playerRoleMap.put(player,role);
            System.out.println("这是第"+i+"次");
        }
        playerRoleMap.entrySet().forEach(System.out::println);
    }

    //测试removeIf
    @Test
    public void testRemoveIf(){
        List<User> list = new ArrayList<>();
        list.add(new User(UUID.randomUUID(),"hehe"));
        list.add(new User(UUID.randomUUID(),"haha"));
        list.add(new User(UUID.randomUUID(),"heihei"));
        list.add(new User(UUID.randomUUID(),"xixi"));
        list.add(new User(UUID.randomUUID(),"huhu"));
        list.add(new User(UUID.randomUUID(),"houhou"));

        System.out.println("初始化完成:"+list.size());

        list.removeIf(user -> user.getUsername().equals("heh1e"));

        System.out.println("删除完成:"+list.size());
    }
}
