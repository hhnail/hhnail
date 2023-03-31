package com.hhnail.test.base;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
}
