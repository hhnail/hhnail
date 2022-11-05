package com.hhnail.test.lambda;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
                                // 取value逻辑：取userInfo为value
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
                        userInfo -> userInfo.getCity()
                )
        );

        collect.forEach((k, v) -> {
            System.out.println("k:" + k + " v:" + v);
        });


    }





}
