package com.hhnail.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author phv
 * @description: 工具类
 */
public class VUtil {

    /**
     * 将给定的List按照指定的大小分组，并返回分组后的List。
     *
     * @param list       要分组的List
     * @param groupSize  每个组的大小
     * @param <T>        List中元素的类型
     * @return 分组后的List，其中每个子List包含指定数量的元素（除了最后一个，可能小于指定大小）
     */
    public static <T> List<List<T>> groupList(List<T> list, int groupSize) {
        List<List<T>> groupedLists = new ArrayList<>();
        for (int i = 0; i < list.size(); i += groupSize) {
            int end = Math.min(i + groupSize, list.size());
            groupedLists.add(list.subList(i, end));
        }
        return groupedLists;
    }


}
