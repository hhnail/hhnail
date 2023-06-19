package com.hhnail.test;

/**
 * @author r221587
 * @version 1.0
 * @description: TODO
 * @date 2023/6/19 13:14
 */
public class CurrentMethodTest {

    public static void main(String[] args) {
        test01();
    }

    private static void test01() {
        test02();
    }

    private static void test02() {
        test03("123");
    }

    private static void test03(String str) {
        // System.out.println("test03");
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        System.out.println(methodName);
    }

}
