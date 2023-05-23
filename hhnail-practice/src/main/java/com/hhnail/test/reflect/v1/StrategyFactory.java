package com.hhnail.test.reflect.v1;

import java.lang.reflect.Method;

public class StrategyFactory {
    public static Object createObjectAndExecute(String className, String methodName, Object param) throws Exception {
        Class<?> clazz = Class.forName(className);
        Object object = clazz.getDeclaredConstructor().newInstance();
        Method method = clazz.getMethod(methodName, Object.class);
        return method.invoke(object, param);
    }
}
