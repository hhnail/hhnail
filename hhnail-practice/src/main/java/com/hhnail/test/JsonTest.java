package com.hhnail.test;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.HashMap;
import java.util.Map;

/**
 * @author r221587
 * @version 1.0
 * @description: 阿里巴巴JSON测试
 * @date 2023/4/17 14:53
 */
public class JsonTest {

    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();

        map.put("k1", "v1");
        map.put("obj", new Object());
        map.put("null", null);

        // 打印map的时候，为null的默认不显示
        System.out.println(JSONObject.toJSONString(map));

        // 打印map的时候，显示为null的
        System.out.println(JSONObject.toJSONString(map, SerializerFeature.WriteMapNullValue));
    }
}
