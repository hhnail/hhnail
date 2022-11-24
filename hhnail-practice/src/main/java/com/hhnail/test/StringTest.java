package com.hhnail.test;

import org.junit.Test;

import java.util.*;

public class StringTest {

    public static void main(String[] args) {
        List<String> habits = Arrays.asList("唱", "跳", "rap", "篮球");
        System.out.println("我是张三，我的爱好是" + String.join(",", habits));
    }

    /**
     * 测试join方法
     */
    @Test
    public void test01() {
        List<String> habits = Arrays.asList("唱", "跳", "rap", "篮球");
        System.out.println("我是张三，我的爱好是" + String.join(",", habits));
    }


    @Test
    public void test02() {
        Object a = null;
        String str = (String) a;
        System.out.println(str);

    }


    @Test
    public void test03() {
        String str = "";
        String str2 = " ";
        System.out.println(str.isEmpty());
        System.out.println(str2.isEmpty());

    }


    @Test
    public void test04() {
        String str = "hello world";
        char c = str.charAt(3);
        System.out.println(c + "");

    }


    @Test
    public void test05() {
        String str1 = "Y";
        Object str2 = "Y";
        System.out.println(str1.equals(str2));

        Map<String, Object> map = new HashMap<>();
        map.put("1", "Y");
        map.put("0", "N");
        System.out.println(map.containsValue("Y"));

    }


    @Test
    public void test06() {
        System.out.println(UUID.randomUUID().toString().length());
    }


}
