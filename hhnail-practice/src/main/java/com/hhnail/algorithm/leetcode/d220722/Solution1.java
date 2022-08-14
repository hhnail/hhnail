package com.hhnail.algorithm.leetcode.d220722;

import com.hhnail.util.HArrayUtil;

import java.util.Arrays;

/*
剑指 Offer II 076. 数组中的第 k 大的数字
https://leetcode.cn/problems/xx4gT2/
 */
public class Solution1 {

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        int[] arr = HArrayUtil.getRandomIntArr(30);
        HArrayUtil.printIntArr(arr);

        System.out.println(s.findKthLargest(arr,2));

    }

    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
