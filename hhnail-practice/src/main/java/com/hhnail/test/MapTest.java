package com.hhnail.test;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(1, 3);
        map.put(12, 3);
        map.put(12, 3);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());

        }
    }

    @Test
    public void test01(){
        Map<String,Object> map = new HashMap<>();
        map.put("b",false);
        if(!(boolean)map.get("b")){
            System.out.println((boolean)map.get("b"));
        }
        map.put("b",true);
        if((boolean)map.get("b")){
            System.out.println((boolean)map.get("b"));
        }
    }
}
