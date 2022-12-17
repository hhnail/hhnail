package com.hhnail.test.collection;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class ListTest {

    @Test
    public void testJoin() {
        List<String> employeeNoList = new ArrayList<>();
        employeeNoList.add("v1");
        employeeNoList.add("v2");
        employeeNoList.add("v3");
        String robam_users = employeeNoList.stream().collect(Collectors.joining(","));
        System.out.println(robam_users);
    }

    @Test
    public void testJoin2() {
        List<Map<String, Object>> employeeNoList = new ArrayList<>();
        for (int i = 1; i < 4; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("employeeNo", "v" + i);
            employeeNoList.add(map);
        }


    }

    @Test
    public void testEmpty() {
        List<String> employeeNoList = new ArrayList<>();
        employeeNoList.forEach(item -> System.out.println(item));
    }


    @Test
    public void testEqual() {
        List<Integer> list1 = new ArrayList<>();
        list1.add(-1);
        list1.add(0);
        list1.add(1);

        List<Integer> list2 = new ArrayList<>();
        list2.add(-1);
        list2.add(0);
        list2.add(1);

        System.out.println(list1.equals(list2));

    }

    @Test
    public void testRemoveLast() {
        LinkedList<String> linkedList = new LinkedList<String>() {{
            add("1");
            add("3");
            add("5");
        }};
        System.out.println(linkedList);
        System.out.println(linkedList.removeFirst());
        System.out.println(linkedList);
        linkedList.removeLast();
        System.out.println(linkedList);


        ArrayList<String> arrayList = new ArrayList<String>() {{
            add("1");
            add("3");
            add("5");
        }};
        // arrayList.removeLast();

    }


}
