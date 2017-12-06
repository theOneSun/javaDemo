package study.baseTest;

import org.junit.Test;

import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author sunjian.
 */
public class MapTest
{
    private HashMap<String, Integer> hashMap = new HashMap<>();
    private ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();

    @Test
    public void testAdd()
    {
        hashAdd("hehe");
        conCurrentAdd("hehe");
        Set<String> keySet = hashMap.keySet();
        ConcurrentHashMap.KeySetView<String, Integer> conKeySet = concurrentHashMap.keySet();
        for (String key : keySet)
        {
            System.out.println(key+"--------"+hashMap.get(key));
        }

        for (String key : conKeySet)
        {
            System.out.println(key+"-----------"+hashMap.get(key));
        }
    }

    private synchronized void hashAdd(String key)
    {
        Integer value = hashMap.get(key);
        if (value == null)
        {
            hashMap.put(key, 1);
        } else
        {
            hashMap.put(key, value + 1);
        }
    }

    private void conCurrentAdd(String key)
    {
        Integer value = concurrentHashMap.get(key);
        if (value == null)
        {
            concurrentHashMap.put(key, 1);
        } else
        {
            concurrentHashMap.put(key, value + 1);
        }
    }


}
