package com.hhnail.test;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

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
        Object a  = null;
        String str = (String)a;
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
        String str= "hello world";
        char c = str.charAt(3);
        System.out.println(c+"");

    }


}
