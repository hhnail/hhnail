package com.hhnail.algorithm.leetcode.y2022.m11.d25;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// 15 三数之和
//给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k
// ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
//
// 你返回所有和为 0 且不重复的三元组。
//
// 注意：答案中不可以包含重复的三元组。
//
//
//
//
//
// 示例 1：
//
//
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
//解释：
//nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
//nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
//nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
//不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
//注意，输出的顺序和三元组的顺序并不重要。
//
//
// 示例 2：
//
//
//输入：nums = [0,1,1]
//输出：[]
//解释：唯一可能的三元组和不为 0 。
//
//
// 示例 3：
//
//
//输入：nums = [0,0,0]
//输出：[[0,0,0]]
//解释：唯一可能的三元组和为 0 。
//
//
//
//
// 提示：
//
//
// 3 <= nums.length <= 3000
// -105 <= nums[i] <= 105
//
// Related Topics 数组 双指针 排序
// 👍 5407 👎 0

/**
 * @author r221587
 * @version 1.0
 * @description: 15 三数之和
 * @date 2022/11/24 13:17
 */
public class Solution {

    public static void main(String[] args) {
        // int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        // int[] nums = new int[]{-2, 0, 1, 1, 2};
        // int[] nums = new int[]{-2, 0, 0, 2, 2};
        // int[] nums = new int[]{-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4};
        // int[] nums = new int[]{-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6};
        int[] nums = new int[]{34, 55, 79, 28, 46, 33, 2, 48, 31, -3, 84, 71, 52, -3, 93, 15, 21,
                -43, 57, -6, 86, 56, 94, 74, 83, -14, 28, -66, 46,
                -49, 62, -11, 43, 65, 77, 12, 47, 61, 26, 1, 13, 29, 55,
                -82, 76, 26, 15, -29, 36, -29, 10, -70, 69, 17, 49};
        // [[-82,-11,93],[-82,13,69],[-82,17,65],[-82,21,61],[-82,26,56],[-82,33,49],[-82,34,48],[-82,36,46],
        // [-70,-14,84],[-70,-6,76],[-70,1,69],[-70,13,57],[-70,15,55],[-70,21,49],[-70,34,36],[-66,-11,77],
        // [-66,-3,69],[-66,1,65],[-66,10,56],[-66,17,49],[-49,-6,55],[-49,-3,52],[-49,1,48],[-49,2,47],[-49,13,36],
        // [-49,15,34],[-49,21,28],[-43,-14,57],[-43,-6,49],[-43,-3,46],[-43,10,33],[-43,12,31],[-43,15,28],[-43,17,26],
        // [-29,-14,43],[-29,1,28],[-29,12,17],[-14,-3,17],[-14,1,13],[-14,2,12],[-11,-6,17],[-11,1,10],[-3,1,2]]
        // int[] nums = new int[]{0, 1, 1};
        // int[] nums = new int[]{0, 0, 0};
        // int[] nums = new int[]{0, 0, 0};
        new Solution().threeSum(nums).forEach(item -> System.out.println(item));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<Integer> source = new ArrayList<>();
        Arrays.stream(nums).sorted().forEach(item -> {
            source.add(item);
        });

        System.out.println("=================source===========================");
        System.out.println(source);

        List<List<Integer>> result = new ArrayList<>();
        int l = 0;
        int m = source.size() - 2;
        int r = source.size() - 1;
        while (l <= r - 2) {
            int v1 = source.get(l);
            int v2 = source.get(m);
            int v3 = source.get(r);
            if(v2 == -29){
                System.out.println("");
            }
            int threeSum = v1 + v2 + v3;
            if (threeSum == 0) {
                List<Integer> resultItem = new ArrayList<>();
                resultItem.add(v1);
                resultItem.add(v2);
                resultItem.add(v3);
                result.add(resultItem);
                r--;
                m = r - 1;
            } else if (threeSum > 0) {
                m--;
            } else {
                l++;
                m = source.size() - 2;
                r = source.size() - 1;
            }

            if (l >= m) {
                r--;
                m = r - 1;
            }
        }
        // System.out.println("=================result===========================");
        // result.forEach(System.out::println);
        System.out.println("=================distinct===========================");
        return result.stream().distinct().collect(Collectors.toList());
    }
}
