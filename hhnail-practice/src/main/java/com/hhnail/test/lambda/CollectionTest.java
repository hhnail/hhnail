package com.hhnail.test.lambda;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class CollectionTest {

    @Data
    @AllArgsConstructor
    class UserInfo {
        private String id;
        private String name;
        private Integer age;
    }


    @Test
    public void list2Map() {
        List<UserInfo> list = new ArrayList<>();
        list.add(new UserInfo("1", "张三", 29));
        list.add(new UserInfo("2", "李四", 18));
        list.add(new UserInfo("2", "王五", 30));

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


}
