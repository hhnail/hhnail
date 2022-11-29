package com.hhnail.test.lambda;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * @author r221587
 * @version 1.0
 * @description: TODO
 * @date 2022/11/29 17:03
 */
public class FunctionInterfaceTest {

    @Data
    @AllArgsConstructor
    @ToString
    private class UserInfo {
        private String id;
        private String name;
        private Integer age;
        private String city;
        private Integer noseCount;
    }

    private java.util.List<UserInfo> getTestListDataAndPrint() {
        java.util.List<UserInfo> list = getTestListData();
        list.forEach(i -> System.out.println(i));
        return list;
    }


    private java.util.List<UserInfo> getTestListData() {
        List<UserInfo> list = new ArrayList<>();
        list.add(new UserInfo("1", "张三", 29, "杭州", 1));
        list.add(new UserInfo("2", "李四", 17, "深圳", 1));
        list.add(new UserInfo("2", "王五", 30, "杭州", 1));
        list.add(new UserInfo("2", "王五", 30, "杭州", 1));
        list.add(list.get(0));
        return list;
    }


    /**
     * 生产型接口：生产变量，并作为返回值返回
     * 消费型接口：消费变量，没有返回值
     */
    @Test
    public void functionInterface() {
        // 生产型接口。生产一个stream可以用的函数（封装了一些操作）
        Function<String, Integer> function = String::length;
        Stream<String> stream = Stream.of("天下相亲与相爱", "仰泰山之高", "相聚东入海");
        Stream<Integer> resultStream = stream.map(function);


        // 消费型接口。消费stream里面的item
        Consumer consumer = System.out::println;
        resultStream.forEach(consumer);
    }


    /**
     * 判断型接口，返回布尔结果
     */
    @Test
    public void functionInterface2() {
        Predicate<Integer> predicate = a -> a > 18;
        UserInfo userInfo = new UserInfo("1", "张三", 29, "杭州", 1);
        System.out.println(predicate.test(userInfo.getAge()));
    }


    /**
     * 供给型接口，没有入参，有返回结果
     */
    @Test
    public void functionInterface3() {
        Supplier<Integer> supplier = () -> Integer.valueOf("666");
        System.out.println(supplier.get());
    }


}
