package com.hhnail.test.base;

import com.hhnail.util.VStringUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author r221587
 * @version 1.0
 * @description: TODO
 * @date 2023/6/29 16:34
 */
public class ListTest {


    @Test
    public void removeAll() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("a2");
        list.add("a3");
        System.out.println(list);
        VStringUtil.printSplitLine();

        List<String> list2 = new ArrayList<>();
        list2.add("a1");
        list2.add("a2");
        System.out.println(list2);
        VStringUtil.printSplitLine();

        list.removeAll(list2);
        System.out.println(list);
    }
}
