package com.hhnail.algorithm.leetcode.y2022.m7.d220718;

import java.util.Arrays;

/*
1913. 两个数对之间的最大乘积差
https://leetcode.cn/problems/maximum-product-difference-between-two-pairs/
 */
public class Solution {

    public static void main(String[] args) {
        int[] testData = {5, 6, 2, 7, 4};
        int result = maxProductDifference(testData);
        System.out.println(result);
    }

    public static int maxProductDifference(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length - 1] * nums[nums.length - 2] - nums[0] * nums[1];
    }
}
