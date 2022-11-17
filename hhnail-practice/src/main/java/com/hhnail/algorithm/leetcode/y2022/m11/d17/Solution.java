package com.hhnail.algorithm.leetcode.y2022.m11.d17;

/**
 * @author r221587
 * @version 1.0
 * @description: 70 爬楼梯
 * @date 2022/11/17 16:34
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(climbStairs(5));
        System.out.println(climbStairs2(5));
    }

    /**
     * 运行超时。因为堆栈也是需要时间的，堆栈太深也会很耗资源
     *
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    /**
     * 动态规划
     * 1 1
     * 2 2
     * 3 3
     * 4 5
     * 5 8
     * 6 13
     */
    public static int climbStairs2(int n) {
        int step1 = 1;
        int step2 = 2;
        // 只有1阶，1种走法。只有2阶，2种走法
        int count = n;
        // 从3阶开始，f(n) = f(n-1) + f(n-2)
        for (int i = 3; i <= n; i++) {
            count = step1 + step2;
            step1 = step2;
            step2 = count;
        }
        return count;
    }


}
