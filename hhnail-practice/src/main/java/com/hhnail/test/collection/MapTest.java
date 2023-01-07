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
        ConcurrentSkipListMap<String, Object> map = new ConcurrentSkipListMap();

        map.put("name", "zhangsan");
        map.put("age", 19);
        map.put("join_date", new Date());

        System.out.println(map);
        System.out.println("======================华丽的分割线======================");

        map.remove("name");
        System.out.println(map);
        System.out.println("======================华丽的分割线======================");
        ConcurrentNavigableMap<String, Object> concurrentNavigableMap = map.headMap("age");
        System.out.println(map);
        System.out.println("======================华丽的分割线======================");
        System.out.println(concurrentNavigableMap);


    }

}
