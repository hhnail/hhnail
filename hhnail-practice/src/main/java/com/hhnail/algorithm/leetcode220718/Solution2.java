package com.hhnail.algorithm.leetcode220718;

import com.hhnail.util.HArrayUtil;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
2295. 替换数组中的元素
https://leetcode.cn/problems/replace-elements-in-an-array/
 */
public class Solution2 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 6};
        int[][] operations = {{1, 3}, {4, 7}, {6, 1}};
        int[] ints = arrayChange(nums, operations);
        HArrayUtil.printIntArr(ints);
    }

    public static int[] arrayChange(int[] nums, int[][] operations) {
        // int数组转为map。key为值，value为下标
        Map<Integer, Integer> nums2 = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            nums2.put(nums[i], i);
        }
        // 遍历operation，操作数组
        for (int i = 0; i < operations.length; i++) {
            int source = operations[i][0];
            int target = operations[i][1];
            nums2.put(target, nums2.get(source));
            nums2.remove(source);
        }
        // map遍历覆盖原来的nums
        for (Integer key : nums2.keySet()) {
            nums[nums2.get(key)] = key;
        }

        return nums;
    }
}
