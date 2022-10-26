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

}
