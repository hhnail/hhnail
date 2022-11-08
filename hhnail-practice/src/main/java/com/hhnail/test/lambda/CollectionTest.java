package com.hhnail.test.lambda;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        private Integer noseCount;

        public Integer growUp() {
            return this.getAge() + 10;
        }
    }


    private List<UserInfo> getTestListData() {
        List<UserInfo> list = new ArrayList<>();
        list.add(new UserInfo("1", "张三", 29, "杭州", 1));
        list.add(new UserInfo("2", "李四", 17, "深圳", 1));
        list.add(new UserInfo("2", "王五", 30, "杭州", 1));
        list.add(new UserInfo("2", "王五", 30, "杭州", 1));
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
        list1.forEach(item -> System.out.println(item));

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

        list.stream().findFirst().ifPresent(item -> {
            System.out.println(item);
        });

    }


    // private class Item{
    //     public void sout(){
    //         System.out.println("Item sout...");
    //     }
    // }


    @Test
    public void map() {
        List<String> list = Arrays.asList("a", "const", "param");
        List<Object> collect = list.stream().map(String::toUpperCase).collect(Collectors.toList());
        collect.forEach(System.out::println);


        // 不仅可以uppercase。
        // 理论上这个东西的作用是可以遍历list里面的item，然后执行item对象上有的方法,并将该方法的返回值封装为list返回
        List<UserInfo> list2 = getTestListData();
        List<Integer> collect2 = list2.stream().map(UserInfo::growUp).collect(Collectors.toList());
        collect2.forEach(System.out::println);

        // map里面调用的方法可以有两种，"xx".toUpperCase这样的，也可以是Integer.parseInt(String xx)
        List<String> list3 = Arrays.asList("1", "2", "3");
        List<Integer> collect3 = list3.stream().map(Integer::parseInt).collect(Collectors.toList());
        collect3.forEach(System.out::println);

    }


    @Test
    public void reduce() {
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4);
        Integer reduce = integerStream.reduce(0, (a, b) -> a + b);
        System.out.println(reduce);


        List<UserInfo> list = getTestListData();
        Stream<UserInfo> userInfoStream = Stream.of(
                new UserInfo("1", "张三", 29, "杭州", 1),
                new UserInfo("2", "李四", 29, "杭州", 1),
                new UserInfo("1", "王五", 29, "杭州", 1)
        );
        UserInfo reduce1 = userInfoStream.reduce(new UserInfo("sum", "sum", 0, "sum", 0),
                (a, b) -> new UserInfo(
                        a.getId() + "," + b.getId(),
                        a.getName() + "," + b.getName(),
                        a.getAge() + b.getAge(),
                        a.getCity() + "," + b.getCity(),
                        a.getNoseCount() + b.getNoseCount()
                ));
        System.out.println(reduce1);
    }


    // 打印日志可以用
    @Test
    public void peek() {
        List<String> collect = Stream.of("error code:400", "error msg code illegal", "user password : 123445")
                .filter(item -> item.contains("error"))
                .peek(
                        item -> System.out.println(
                                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + " " + item
                        )
                )
                .collect(Collectors.toList());


    }


    @Test
    public void max() {
        List<UserInfo> list = getTestListData();

        list.forEach(item->System.out.println(item));

        System.out.println("");

        list.stream()
                .max(Comparator.comparing(UserInfo::getAge))
                .ifPresent(item -> System.out.println(item));

        list.stream()
                .min(Comparator.comparing(UserInfo::getAge))
                .ifPresent(item -> System.out.println(item));
    }


}
