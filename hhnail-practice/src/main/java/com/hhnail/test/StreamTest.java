package com.hhnail.test;

import org.junit.Assert;
import org.junit.Test;

import java.util.function.IntSupplier;
import java.util.stream.IntStream;

/**
 * @author r221587
 * @version 1.0
 * @description: Stream
 * @date 2022/11/24 13:26
 */
public class StreamTest {

    @Test
    public void test01() {
        // 传入IntSupplier ，这里永远返回1
        int sum = IntStream.generate(() -> 1).limit(1).sum();
        // assertEquals（param1，param2）。如果param2和”期待的“param1，不一致，程序终止
        Assert.assertEquals(2, sum);

        System.out.println("assert 1 over");

        // 当然还可以这样
        // 供给者（无入参，有出参）
        IntSupplier intSupplier = () -> 1;
        sum = IntStream.generate(intSupplier).limit(1).sum();
        Assert.assertEquals(1, sum);

        System.out.println("assert 2 over");

    }

}
