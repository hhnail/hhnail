package com.hhnail.algorithm.leetcode.plan01.day03;

import com.hhnail.util.HArrayUtil;

public class TwoSum {

	public static void main(String[] args) {
		TwoSum t = new TwoSum();

		// int[] arr = {2, 7, 11, 15};
		// HArrayUtil.printIntArr(t.twoSum(arr, 9));
		int[] arr = {-1, 0};
		HArrayUtil.printIntArr(t.twoSum(arr, -1));


	}

	// [2,7,11,15] 9 --> [1,2]
	public int[] twoSum(int[] numbers, int target) {
		int[] res = new int[2];
		int lp = 0;
		int rp = numbers.length - 1;
		// 扫描右边的指针
		while (rp > 0) {
			// 如果比target大了，由于数组是升序排列的，所以说明右边的这个值不可能与 数组中任何值相加都不可能等于target
			if ((numbers[lp] + numbers[rp]) > target) {
				rp--;
				lp = 0;
				continue;
			}
			// 扫描左边的指针
			while (lp < rp) {
				if ((numbers[lp] + numbers[rp]) == target) {
					res[0] = lp + 1;
					res[1] = rp + 1;
					break;
				}
				lp++;
			}
			rp--;
			lp = 0;
		}
		return res;
	}
}
