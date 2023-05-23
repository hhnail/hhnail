package com.hhnail.test.reflect.v1;

import java.lang.reflect.Method;

/**
 * @author r221587
 * @version 1.0
 * @description: TODO
 * @date 2023/5/20 15:08
 */
public class Test {

    public static void main(String[] args) throws Exception {
        test01();
        // test02();
        // test03();


    }

    /**
     * 创建类并执行指定方法
     * @throws Exception
     */
    private static void test01() throws Exception {
        String[] myArgs = {"com.hhnail.test.reflect.v1.StrategyA", "execute", "Hello"};

        Class<?> clazz = Class.forName(myArgs[0]);
        Method method = clazz.getMethod(
                myArgs[1], // 方法名称
                Object.class // 入参Object类
        );
        method.invoke(
                clazz.newInstance(), // 要反射的类的实例对象
                myArgs[2] // 入参变量
        );
    }

    /**
     * 创建类并执行指定方法
     * @throws Exception
     */
    private static void test02() throws Exception {
        try {
            // 加载指定的类
            Class<?> clazz = Class.forName("com.hhnail.test.reflect.v1.StrategyA");
            // 创建该类的实例
            Object object = clazz.newInstance();
            // 获取需要调用的方法
            Method method = clazz.getMethod("execute", Object.class);
            // 调用方法并获取返回值
            String result = (String) method.invoke(object, "hello");
            // 输出返回值
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 创建类并执行指定方法。封装
     * @throws Exception
     */
    private static void test03() throws Exception {

        String[] myArgs = {"com.hhnail.test.reflect.v1.StrategyA", "execute", "Hello22"};

        String className = myArgs[0];
        String methodName = myArgs[1];
        Object param = myArgs[2];
        Strategy strategy = (Strategy) StrategyFactory.createObjectAndExecute(className, methodName, param);
        // strategy.execute(myArgs[2]);


        myArgs = new String[]{"com.hhnail.test.reflect.v1.StrategyB", "execute", "haloB"};
        className = myArgs[0];
        methodName = myArgs[1];
        param = myArgs[2];
        strategy = (Strategy) StrategyFactory.createObjectAndExecute(className, methodName, param);
    }


}