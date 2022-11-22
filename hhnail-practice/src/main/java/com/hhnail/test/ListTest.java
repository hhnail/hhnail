package com.hhnail.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    public void testEmpty(){
        List<String> employeeNoList = new ArrayList<>();
        employeeNoList.forEach(item-> System.out.println(item));
    }


}
