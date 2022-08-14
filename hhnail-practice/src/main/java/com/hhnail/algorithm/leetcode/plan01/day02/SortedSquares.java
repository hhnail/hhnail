package com.hhnail.algorithm.leetcode.plan01.day02;

import com.hhnail.util.HArrayUtil;

// 双指针
// https://leetcode-cn.com/problems/squares-of-a-sorted-array/
public class SortedSquares {

	public static void main(String[] args) {
		SortedSquares s = new SortedSquares();
		// int[] source = {-4, -1, 0, 3, 10};
		// int[] source = {-7, -3, 2, 3, 11};
		int[] source = {-10000, -9999, -7, -5, 0, 0, 10000};
		HArrayUtil.printIntArr(s.sortedSquares(source));
	}

	// [-4,-1,0,3,10]
	public int[] sortedSquares(int[] nums) {
		int length = nums.length;
		int[] target = new int[length];
		int leftPoint = 0;
		int rightPoint = length - 1;
		int i = rightPoint;
		while (i >= 0) {
			int leftValue = nums[leftPoint];
			int rightValue = nums[rightPoint];
			int leftValue2 = leftValue * leftValue;
			int rightValue2 = rightValue * rightValue;
			if (rightValue2 > leftValue2) {
				target[i] = rightValue2;
				rightPoint--;
				i--;
			} else if (leftValue2 > rightValue2) {
				target[i] = leftValue2;
				leftPoint++;
				i--;
			} else {
				target[i] = rightValue2;
				if (leftPoint == rightPoint) {
					i--;
					break;
				}
				target[i - 1] = rightValue2;
				i -= 2;
				leftPoint++;
				rightPoint--;
			}
		}
		return target;
	}
}
