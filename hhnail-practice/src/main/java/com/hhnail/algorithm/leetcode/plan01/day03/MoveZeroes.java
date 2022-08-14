package com.hhnail.algorithm.leetcode.plan01.day03;

import com.hhnail.util.HArrayUtil;

// 移动零：给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
// https://leetcode-cn.com/problems/move-zeroes/
public class MoveZeroes {

	public static void main(String[] args) {
		MoveZeroes m = new MoveZeroes();
		// int[] arr = {0, 1, 0, 3, 12};
		// int[] arr = {1, 0, 1};
		int[] arr = {1, 0};
		m.moveZeroes(arr);
	}

	// 输入: [1,1,0,3,0]
	// 1 0 0 3 0
	// 1 3 0 0 0
	// 输出: [1,3,0,0,0]
	public void moveZeroes(int[] nums) {
		int lp = 0;
		int rp = lp + 1;
		while (rp < nums.length) {
			if (nums[lp] != 0) {
				lp++;
				rp++;
				continue;
			}
			if (nums[lp] == 0 && nums[rp] != 0) {
				// swap
				int temp = nums[lp];
				nums[lp] = nums[rp];
				nums[rp] = temp;
				lp++;
			}
			rp++;
		}
		HArrayUtil.printIntArr(nums);
	}
}
