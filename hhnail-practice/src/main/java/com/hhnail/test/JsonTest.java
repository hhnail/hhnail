package com.hhnail.test;

import com.alibaba.fastjson.JSONObject;
import lombok.*;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
// @AllArgsConstructor
// @NoArgsConstructor
public class JsonTest {

    // private String id;
    // private String name;
    //
    // public static void main(String[] args) {
    //     System.out.println(new JsonTest("1", "张三"));
    //     System.out.println(JSONObject.toJSONString(new JsonTest("1", "张三")));
    // }

    @Test
    public void test(){
        Map<String,Object> map = new HashMap<>();
        map.put("name","张三");
        System.out.println(JSONObject.toJSONString(map.toString()));
    }

}
