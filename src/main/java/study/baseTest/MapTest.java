package study.baseTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author sunjian.
 */
public class MapTest {
    private HashMap<String, Integer> hashMap = new HashMap<>();
    private ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();

    @Test
    public void testAdd() {
        hashAdd("hehe");
        conCurrentAdd("hehe");
        Set<String> keySet = hashMap.keySet();
        ConcurrentHashMap.KeySetView<String, Integer> conKeySet = concurrentHashMap.keySet();
        for (String key : keySet) {
            System.out.println(key + "--------" + hashMap.get(key));
        }

        for (String key : conKeySet) {
            System.out.println(key + "-----------" + hashMap.get(key));
        }
    }

    private synchronized void hashAdd(String key) {
        Integer value = hashMap.get(key);
        if (value == null) {
            hashMap.put(key, 1);
        } else {
            hashMap.put(key, value + 1);
        }
    }

    private void conCurrentAdd(String key) {
        Integer value = concurrentHashMap.get(key);
        if (value == null) {
            concurrentHashMap.put(key, 1);
        } else {
            concurrentHashMap.put(key, value + 1);
        }
    }

    @Test
    public void testRemove() {
        Map<String, List<String>> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        map.put("a",list);
        List<String> listNull = new ArrayList<>();
        listNull.add("a");
        listNull.add("b");
        listNull.add("c");
        map.put("",listNull);
        map.keySet().forEach(System.out::println);
        System.out.println("----------------");
        map.remove("");
        map.keySet().forEach(System.out::println);

    }

    //测试修改value是否改变顺序
    @Test
    public void testLinkedHashMapAddOrder(){
        Map<String,Boolean> map = new LinkedHashMap<>();
        map.put("1",true);
        map.put("2",false);
        map.put("3",true);
        map.put("4",true);
        printMap(map);

        map.put("3",false);
        printMap(map);

    }

    private void printMap(Map map){
        for (Object entry:map.entrySet()){
            Map.Entry entry1 = (Map.Entry) entry;
            System.out.println(entry1.getKey()+"="+entry1.getValue());
        }
    }
}
