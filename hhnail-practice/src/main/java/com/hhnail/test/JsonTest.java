package com.hhnail.test;

import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JsonTest {

    private String id;
    private String name;

    public static void main(String[] args) {
        System.out.println(JSONObject.toJSONString(new JsonTest("1", "张三")));
    }

}
