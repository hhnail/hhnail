package com.hhnail.test;

import org.junit.Test;

/**
 * @author r221587
 * @version 1.0
 * @description: 异常测试类
 * @date 2022/11/29 16:43
 */
public class ExceptionTest {

    @Test
    public void test() {
        try {
            throw new RuntimeException("param非法");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
