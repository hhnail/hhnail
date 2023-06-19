package com.hhnail.algorithm.leetcode.greedy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author r221587
 * @version 1.0
 * @description: LeetCode-11 盛最多水的容器
 * @date 2023/6/3 16:11
 */
public class MaxWaterContainer {

    public static void main(String[] args) {
        // int[] arr = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        int[] arr = new int[]{2, 3, 4, 5, 18, 17, 6};
        System.out.println(maxArea(arr));

    }

    public static int maxArea(int[] height) {
        int maxContain = -1;

        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int contain = height[left] > height[right]
                    ? height[right] * (right - left) : height[left] * (right - left);
            maxContain = maxContain > contain ? maxContain : contain;
            left++;
        }
        left = 0;
        right = height.length - 1;
        while (left < right) {
            int contain = height[left] > height[right]
                    ? height[right] * (right - left) : height[left] * (right - left);
            maxContain = maxContain > contain ? maxContain : contain;
            right--;
        }


        return maxContain;

    }

}
