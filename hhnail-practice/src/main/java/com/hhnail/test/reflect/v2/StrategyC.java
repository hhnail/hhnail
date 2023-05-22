package com.hhnail.test.reflect.v2;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.Map;

public class StrategyC implements Strategy {
    @Override
    public void execute(Map<String, Object> param) {

        System.out.println("执行策略C：" + JSONObject.toJSONString(param));

    }
}