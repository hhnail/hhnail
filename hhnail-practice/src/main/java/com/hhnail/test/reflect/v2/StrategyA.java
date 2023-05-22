package com.hhnail.test.reflect.v2;

import com.alibaba.fastjson.JSONObject;

import java.util.Map;

public class StrategyA implements Strategy {
    @Override
    public void execute(Map<String, Object> param) {

        System.out.println("执行策略A:" + JSONObject.toJSONString(param));
    }
}

