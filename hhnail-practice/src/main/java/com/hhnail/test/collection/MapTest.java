package com.hhnail.test.collection;

import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class MapTest {
    public static void main(String[] args) {

    }

    /**
     * value为Object的boolean
     */
    @Test
    public void test01() {
        Map<String, Object> map = new HashMap<>();
        map.put("b", false);
        if (!(boolean) map.get("b")) {
            System.out.println((boolean) map.get("b"));
        }
        map.put("b", true);
        if ((boolean) map.get("b")) {
            System.out.println((boolean) map.get("b"));
        }
    }

    /**
     * remove不存在的key
     */
    @Test
    public void test02() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "张三");

        map.remove("age");
        map.forEach((key, value) -> System.out.println(key + ":" + value));

    }

    @Test
    public void test03() {
        Map<String, Object> map = new HashMap<>();

        map.put(null, "zero");
        map.put("0", "zero");
        map.put("1", "one");
        System.out.println(map.get(null));


    }

    /**
     * 遍历map
     */
    @Test
    public void test04() {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(1, 3);
        map.put(12, 3);
        map.put(12, 3);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }
    }


    /**
     * 创建并初始化Map
     */
    @Test
    public void test05() {
        Map<String, String> map = new HashMap<String, String>() {{
            put("id", "2022121701");
            put("name", "张三");
            put("age", "19");
        }};
        map.forEach((key, value) -> System.out.println(key + ":" + value));
    }

    /**
     * ConcurrentSkipListMap
     */
    @Test
    public void test06() {
        ConcurrentSkipListMap<Long, Object> map = new ConcurrentSkipListMap();

        map.put(1L, "zhangsan");
        map.put(2L, 19);
        map.put(3L, new Date());
        map.put(4L, new Date());

        System.out.println(map);
        System.out.println("======================华丽的分割线======================");

        // map.remove("name");
        map.remove(4L);
        System.out.println(map);
        System.out.println("======================华丽的分割线======================");
        /**
         * headMap保留key小于key的
         * tailMap保留key大于key的
         * ConcurrentSkipListMap相当于一个支持批量操作的map
         */
        ConcurrentNavigableMap<Long, Object> concurrentNavigableMap = map.headMap(2L);
        System.out.println("concurrentNavigableMap:" + concurrentNavigableMap);
        System.out.println("map:" + map);
        System.out.println("======================华丽的分割线======================");
        concurrentNavigableMap.clear();
        System.out.println("concurrentNavigableMap:" + concurrentNavigableMap);
        System.out.println("map:" + map);


    }

}
