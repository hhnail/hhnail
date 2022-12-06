package com.hhnail.test;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author r221587
 * @version 1.0
 * @description: TODO
 * @date 2022/12/6 8:53
 */
public class SetTest {

    @Test
    public void test01(){
        Set<String> set = new HashSet<>();
        set.add("AY2002");
        set.add("XM2033");
        System.out.println(set.contains("AY2002"));
        System.out.println(set.contains("XY2002"));

    }

}
