package com.hhnail.algorithm.leetcode.plan01.day01;

import com.hhnail.util.HArrayUtil;

/**
 * 二分算法
 */
public class Dichotomy {
	public static void main(String[] args) {
		// 测试函数
		Dichotomy s = new Dichotomy();
		// 获取随机数组
		// int[] orderedIntArr = HArrayUtil.getOrderedIntArr();
		// int[] orderedIntArr2 = HArrayUtil.getOrderedIntArr(20);
		// int[] orderedIntArr3 = HArrayUtil.getOrderedIntArr(20, true);
		// HArrayUtil.printIntArr(orderedIntArr);
		// HArrayUtil.printIntArr(orderedIntArr2);
		// HArrayUtil.printIntArr(orderedIntArr3);
		int[] orderedIntArr = {842, 1812, 2577, 2900, 3728, 4170, 4666, 4892, 4994, 5565, 5579, 5772, 6505, 7162, 7769};
		// int[] orderedIntArr = {5};
		// int[] orderedIntArr = {2, 5};
		HArrayUtil.printIntArr(orderedIntArr);


		// 测试算法
		System.out.println("target index:" + s.search(orderedIntArr, 7769));
		// System.out.println("target index:" + s.search2(orderedIntArr, 3899));
	}

	// solution
	public int search(int[] nums, int target) {
		// 初始化左右边界
		int leftBound = 0;
		int rightBound = nums.length - 1;
		// 判断边界值
		if (target > nums[rightBound] || target < nums[leftBound]) {
			return -1;
		}
		// 开始二分
		while (leftBound <= rightBound) {
			int mid = (leftBound + rightBound) / 2;
			if (nums[mid] == target) {
				return mid;
			}
			if (mid == leftBound) {
				return nums[rightBound] == target ? rightBound : -1;
			}
			if (nums[mid] > target) {
				rightBound = mid;
			} else if (nums[mid] < target) {
				leftBound = mid;
			}
		}
		// 找不到则返回-1
		return -1;
	}

	// 链接：https://leetcode-cn.com/problems/binary-search/solution/er-fen-cha-zhao-by-leetcode-solution-f0xw/
	public int search2(int[] nums, int target) {
		int low = 0, high = nums.length - 1;
		while (low <= high) {
			// TODO 为什么
			int mid = (high - low) / 2 + low;
			int num = nums[mid];
			if (num == target) {
				return mid;
			} else if (num > target) {
				// 确实，比num大了，就从他的旁边的数开始比较就可以了
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}
}
