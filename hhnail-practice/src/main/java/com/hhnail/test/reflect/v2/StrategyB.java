package com.hhnail.test.reflect.v2;

import java.util.Map;

public class StrategyB implements Strategy {
    @Override
    public void execute(Map<String, Object> param) {


        System.out.println("执行策略B");
    }
}