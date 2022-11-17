package com.hhnail.algorithm.leetcode.y2022.m7.d220724;

import java.util.Arrays;

/**
 * TODO
 * 2335. 装满杯子需要的最短总时长
 * https://leetcode.cn/problems/minimum-amount-of-time-to-fill-cups/
 */
public class Solution {

    public static void main(String[] args) {
        // int[] arr = {1, 4, 2};// 4
        // int[] arr = {5, 4, 4};// 7
        int[] arr = {5, 5, 4};// 7
        /*
        4 4 4
        3 3 4
        2 2 4
        1 2 3
        1 1 2
        0 1 1
        0 0 0
         */
        // int[] arr = {4, 3, 2};// 6
        // int[] arr = {3, 4, 4};// 6
        /*
        3 3 3
        2 2 3
        1 2 2
        1 1 1
        0 0 1
        0 0 0
         */
        System.out.println(fillCups(arr));
    }

    public static int fillCups(int[] amount) {
        Arrays.sort(amount);
        int n1 = (amount[0] + amount[1]) / 2;
        if (amount[2] >= amount[0] + amount[1]) {
            return amount[2];
        } else if (amount[2] < 2 * n1) {
            int result = amount[0] + amount[1] - amount[2] + n1;
            return result;
        } else {
            int result = 2 * n1 + amount[1] - n1;
            return result;
        }
    }
}
