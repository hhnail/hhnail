package com.hhnail.algorithm.leetcode.y2022.m7.d220718;

/*
1184. 公交站间的距离
https://leetcode.cn/problems/distance-between-bus-stops/
 */
public class Solution4 {

    public static void main(String[] args) {
        Solution4 solution = new Solution4();
        int[] distince = {1, 2, 3, 4};
        System.out.println(solution.distanceBetweenBusStops(distince, 0, 1));

        // TODO 用例不通过
        // int[] distince = {7, 10, 1, 12, 11, 14, 5, 0};
        // System.out.println(solution.distanceBetweenBusStops(distince, 7, 2));

        // int[] distince = {1, 2, 3, 4};
        // System.out.println(solution.distanceBetweenBusStops(distince, 0, 2));

    }


    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int length = distance.length;
        int current = start;
        int current2 = start + length - 1;

        int line1 = 0;
        int line2 = 0;
        while (((current % length != destination) && (current2 % length != (destination-1)))) {
            if (current % length != destination) {
                line1 += distance[current % length];
            }
            if (current2 % length != (destination-1)) {
                line2 += distance[current2 % length];
            }
            current++;
            current2 = current2 + length - 1;
        }
        return Math.min(line1, line2);
    }
}
