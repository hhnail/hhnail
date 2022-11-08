package com.hhnail.test.lambda;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import java.util.*;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class CollectionTest {

    @Data
    @AllArgsConstructor
    @ToString
    class UserInfo {
        private String id;
        private String name;
        private Integer age;
        private String city;
    }


    private List<UserInfo> getTestListData() {
        List<UserInfo> list = new ArrayList<>();
        list.add(new UserInfo("1", "张三", 29, "杭州"));
        list.add(new UserInfo("2", "李四", 17, "深圳"));
        list.add(new UserInfo("2", "王五", 30, "杭州"));
        list.add(new UserInfo("2", "王五", 30, "杭州"));
        list.add(list.get(0));
        return list;
    }

    private Map<String, UserInfo> getTestMapData() {
        Map<String, UserInfo> map = new HashMap<>();
        getTestListData().forEach(item -> {
            map.put(item.getName(), item);
        });
        return map;
    }


    /**
     * list转map
     */
    @Test
    public void list2Map() {
        List<UserInfo> list = getTestListData();


        Map<String, UserInfo> map = list.stream()
                .collect(
                        Collectors.toMap(
                                // 取key逻辑：取id为key
                                UserInfo::getId,
                                // 取value逻辑：取userInfo为value。可以省略return和{}
                                userInfo -> {
                                    return userInfo;
                                },
                                // 重复key的处理逻辑：k1如果和k2重复了，取key为k2（k1）的。也就是取最后一个（第一个）key的value
                                (k1, k2) -> k2)
                );


        // 遍历。参数只有一个item，可以省略（）；输出只有一行，可以省略{}
        map.values().forEach(item -> System.out.println(item.getName()));
    }


    /**
     * 过滤
     */
    @Test
    public void filter() {

        List<UserInfo> list = getTestListData();

        List<UserInfo> filtedList = list.stream().filter(user -> user.getAge() > 18).collect(Collectors.toList());

        filtedList.forEach(userInfo -> System.out.println(userInfo.getName()));
    }


    /**
     * foreach遍历map
     */
    @Test
    public void foreachMap() {
        Map<String, UserInfo> map = getTestMapData();
        map.forEach((key, value) -> {
            System.out.println("key:" + key + " value:" + value);
        });
    }


    /**
     * 测试group by
     */
    @Test
    public void groupingBy() {
        List<UserInfo> list = getTestListData();

        Map<String, List<UserInfo>> collect = list.stream().collect(
                Collectors.groupingBy(
                        // 按照什么分组:按照城市分组
                        userInfo -> userInfo.getCity()
                )
        );

        collect.forEach((k, v) -> {
            System.out.println("k:" + k + " v:" + v);
        });


    }


    @Test
    public void order() {
        List<UserInfo> list = getTestListData();

        List<UserInfo> ascOrderList = list.stream().sorted(Comparator.comparing(UserInfo::getAge)).collect(Collectors.toList());
        List<UserInfo> descOrderList = list.stream().sorted(Comparator.comparing(UserInfo::getAge).reversed()).collect(Collectors.toList());


        ascOrderList.forEach(item -> System.out.println(item));
        descOrderList.forEach(item -> System.out.println(item));

    }


    @Test
    public void distinct() {
        List<String> list = Arrays.asList("A", "B", "C", "A");
        List<String> collect = list.stream().distinct().collect(Collectors.toList());
        collect.forEach(item -> System.out.println(item));


        List<UserInfo> list1 = getTestListData();
        list1.forEach(item-> System.out.println(item));

        System.out.println();

        List<UserInfo> collect1 = list1.stream()
                // 对象list的distinct根据不是引用.而是对象里的每一个属性一致,才会标识为重复的
                .distinct()
                .collect(Collectors.toList());
        collect1.forEach(item -> System.out.println(item));
    }


    /**
     * 返回集合的第一个元素
     */
    @Test
    public void findfirst() {
        List<UserInfo> list = getTestListData();
        list.stream().findFirst().ifPresent(System.out::println);

        list.stream().findFirst().ifPresent(item->{
            System.out.println(item);
        });

    }





}
