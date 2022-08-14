package com.hhnail.algorithm.leetcode.d220723;

import com.hhnail.util.HArrayUtil;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @Tags:动态规划 978. 最长湍流子数组
 * https://leetcode.cn/problems/longest-turbulent-subarray/
 */
public class Solution2 {

    public static void main(String[] args) {
        // int[] arr = {9,
        //         4, 2, 10, 7, 8,
        //         8, 1, 9
        // };
        // int[] arr = {4, 8, 12, 16};
        int[] arr = {1, 1};
        // int[] arr = {100};
        // int[] arr = {9, 9};
        System.out.println(maxTurbulenceSize(arr));

        HArrayUtil.printIntArr(Arrays.stream(arr).distinct().toArray());

    }

    /**
     * 写法1：循环嵌套
     */
    public static int maxTurbulenceSize(int[] arr) {
        if (Arrays.stream(arr).distinct().toArray().length == 1) {
            return 1;
        }
        int max = 0;
        for (int j = 0; j < arr.length - 2; j++) {
            int tempMax = 0;
            for (int i = j; i < arr.length - 2; i++) {
                boolean b1 = arr[i] > arr[i + 1] && arr[i + 1] < arr[i + 2];
                boolean b2 = arr[i] < arr[i + 1] && arr[i + 1] > arr[i + 2];
                if (b1 || b2) {
                    tempMax += 1;
                } else {
                    break;
                }
            }
            max = Math.max(max, tempMax);
        }
        return max + 2;
    }


    /**
     * 写法2：动态规划
     * 题解
     */
    public static int maxTurbulenceSize2(int[] arr) {
        int n = arr.length;
        int ret = 1;
        int left = 0, right = 0;

        while (right < n - 1) {
            if (left == right) {
                if (arr[left] == arr[left + 1]) {
                    left++;
                }
                right++;
            } else {
                if (arr[right - 1] < arr[right] && arr[right] > arr[right + 1]) {
                    right++;
                } else if (arr[right - 1] > arr[right] && arr[right] < arr[right + 1]) {
                    right++;
                } else {
                    left = right;
                }
            }
            ret = Math.max(ret, right - left + 1);
        }
        return ret;
    }


}
