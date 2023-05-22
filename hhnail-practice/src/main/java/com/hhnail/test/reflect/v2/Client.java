package com.hhnail.test.reflect.v2;

import java.util.HashMap;
import java.util.Map;

public class Client {
    public static void main(String[] args) {
        Object object = ReflectFactory.create(StrategyC.class.getName());
        if (object instanceof Strategy) {
            Map<String, Object> param = new HashMap<>();
            param.put("k1", "v1");
            ((Strategy) object).execute(param);
        }
    }
}
