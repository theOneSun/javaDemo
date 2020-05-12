package study.middleware;

import org.junit.Test;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author sunjian.
 */
public class ConcurrentTest {
    private HashMap<String,Integer> hashMap = new HashMap<>();
    private ConcurrentHashMap<String,Integer> concurrentHashMap = new ConcurrentHashMap<>();

    /**
     * 测试map和concurrentHashMap的添加
     */
    @Test
    public void testMapAdd(){
        final ConcurrentTest concurrentTest = new ConcurrentTest();
        final DemoThread demoThread1 = new DemoThread(concurrentTest);
        final DemoThread demoThread2 = new DemoThread(concurrentTest);
        demoThread1.run();
        demoThread2.run();
    }

    public synchronized void mapAdd(String key){
        final Integer value = hashMap.get(key);
        if (null== value){
            hashMap.put(key,1);
        }else{
            hashMap.put(key,value+1);
        }
        System.out.println("mapAdd:" + hashMap);
    }

    public  void currentMapAdd(String key){
        final Integer value = concurrentHashMap.get(key);
        if (null== value){
            concurrentHashMap.put(key,1);
        }else{
            concurrentHashMap.put(key,value+1);
        }
        System.out.println("currentMapAdd:" + concurrentHashMap);

    }


}
