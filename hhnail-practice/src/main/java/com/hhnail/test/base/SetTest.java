package com.hhnail.test.base;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author r221587
 * @version 1.0
 * @description: TODO
 * @date 2023/5/3 15:49
 */
public class SetTest {

    @Test
    public void test() {
        Set<String> set = new HashSet<>();
        set.add("1");
        set.add("12");
        set.add("1");
        System.out.println(set);
    }
}
