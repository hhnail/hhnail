package com.hhnail.leetcode.datastructure01.day01;

import org.junit.Test;

import java.util.Arrays;

/**
 * 最大子数组和
 * https://leetcode-cn.com/problems/maximum-subarray/
 * <p>
 * tip：这题学到了一个很重要的思维
 * 我们要求的是和最大，所以说一组数字的和如果 ≤ 0，则这组数就没有必要纳入到求和最大中了
 * 这就是代码中"<="就遗弃的原因，这也是这题中将时间复杂度从O（n²）降低到O（n）的关键
 */
public class MaxSubArray {
	public static void main(String[] args) {
		int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
		// int[] arr = {5, 4, -1, 7};
		// int[] arr = {-2, -1};
		// int[] arr = {-2, -3, -1};
		// int[] arr = {-1, 1, 2, 1};
		System.out.println(MaxSubArray.maxSubArray(arr));
		System.out.println(MaxSubArray.maxSubArray2(arr));

		// System.out.println(Arrays.stream(arr).max().getAsInt());
	}

	// O(n²)
	// [-2, 1, -3, 4, -1, 2, 1, -5, 4] --> [4, -1, 2, 1]、6
	public static int maxSubArray(int[] nums) {
		int max = nums[0]; // Arrays.stream(nums).max().getAsInt()  --Step1
		for (int i = 0; i < nums.length; i++) {
			// max没有必要在--Step1的步骤中特地计算，因为既然我们都要遍历数组，过程中肯定是可以拿到真正的单值max的
			if (nums[i] > max) {
				max = nums[i];
			}
			if (nums[i] <= 0) {
				continue;
			}
			int temp = 0;
			for (int j = i; j < nums.length; j++) {
				temp += nums[j];
				if (temp > max) {
					max = temp;
				}
			}
		}
		return max;
	}


	public static int maxSubArray2(int[] nums) {
		int maxSingle = nums[0];
		int maxSum = maxSingle;
		int tempSum = 0;
		for (int i = 0; i < nums.length; i++) {
			int currentValue = nums[i];
			maxSingle = currentValue > maxSingle ? currentValue : maxSingle;
			tempSum += currentValue;
			if (tempSum <= 0) {
				tempSum = 0;
				continue;
			}
			maxSum = tempSum > maxSum ? tempSum : maxSum;

		}
		return maxSum > maxSingle ? maxSum : maxSingle;
	}

	@Test
	public void test01() {

	}


}
