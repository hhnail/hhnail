package com.hhnail.algorithm.leetcode220718;

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

    }


    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int line1 = 0;
        int line2 = 0;
        int count = distance.length;
        while (start % count < destination || (distance.length - start - 1) % count >= destination) {
            if (start < destination) {
                line1 += distance[start];
            }
            if ((distance.length - start - 1) >= destination) {
                line2 += distance[distance.length - start - 1];
            }
            start++;
        }
        return Math.min(line1, line2);
    }
}
