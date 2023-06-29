package com.hhnail.test.base;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.hhnail.util.VStringUtil;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author r221587
 * @version 1.0
 * @description: TODO
 * @date 2023/3/29 15:54
 */
public class MapTest {

    @Test
    public void print() {
        Map<String, Object> map = new HashMap<>();
        map.put("k1", "v1");
        map.put("k2", "v2");
        map.put("k3", "v3");

        Map<String, Object> map2 = new HashMap<>();
        map2.put("k1", "v1");
        map2.put("k2", "v2");
        map2.put("k3", "v3");

        map.put("map", map2);

        System.out.println("log:" + map);
        System.out.println("json log:" + JSONObject.toJSONString(map));
    }


    @Test
    public void distinct() {
        Map<String, Object> map = new HashMap<>();
        map.put("k1", "v1");
        map.put("k2", "v2");
        map.put("k3", "v3");

        List<Map<String, Object>> list = new ArrayList<>();
        list.add(map);
        list.add(map);
        list.add(map);

        List<Map<String, Object>> newList = list.stream().distinct().collect(Collectors.toList());
        System.out.println(newList);
    }


    @Test
    public void test() {

        List<Map<String, Object>> list = new ArrayList<>();
        list.add(new HashMap<String, Object>() {{
            put("id", "1");
            put("gender", "男");
            put("name", "张三");
        }});
        list.add(new HashMap<String, Object>() {{
            put("id", "2");
            put("gender", "男");
            put("name", "李四");
        }});
        list.add(new HashMap<String, Object>() {{
            put("id", "3");
            put("gender", "女");
            put("name", "王五");
        }});
        list.add(new HashMap<String, Object>() {{
            put("id", "4");
            put("gender", "未知");
            put("name", "哈哈哈");
        }});

        // 将list分组。分组过后是个map，key是按照什么分组，value是对应的组（List集合）
        Map<String, List<Map<String, Object>>> group = list.stream()
                .collect(
                        Collectors.groupingBy(
                                // 依据性别分组
                                x -> x.get("gender").toString()
                        )
                );
        // map的entry set。可以拿来遍历
        Set<Map.Entry<String, List<Map<String, Object>>>> entries = group.entrySet();
        // 将entry set拿来遍历。Java8的流可以遍历entry set，先转为流然后map即可
        Stream<Map<String, Object>> mapStream = entries.stream().map(x2 -> {
            Map<String, Object> temp = new HashMap<>();
            temp.put("gender", x2.getKey());
            temp.put("emp", x2.getValue());
            return temp;
        });

        // 转化为List
        List<Map<String, Object>> newList = mapStream.collect(Collectors.toList());

        System.out.println(JSONObject.toJSONString(newList, SerializerFeature.WriteMapNullValue));
    }

    @Test
    public void removeAll() {
        Map<String, Object> map = new HashMap<>();
        map.put("a", "b");
        map.put("a1", "b1");
        map.put("a2", "b2");
        System.out.println(map);
        VStringUtil.printSplitLine();

        Map<String, Object> map2 = new HashMap<>();
        map2.put("a1", "b2");
        map2.put("a2", "b2");
        System.out.println(map2);
        VStringUtil.printSplitLine();

        map.replaceAll((key, value) -> map2.get(key));
        System.out.println(map);
    }

}
