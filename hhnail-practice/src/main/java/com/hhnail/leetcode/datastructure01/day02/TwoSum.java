package com.hhnail.leetcode.datastructure01.day02;

import com.hhnail.util.HArrayUtil;

import java.util.HashMap;

public class TwoSum {

	public static void main(String[] args) {
		int[] arr = {2, 7, 11, 15};
		int[] resIndex = TwoSum.twoSum(arr, 9);
		HArrayUtil.printIntArr(resIndex);
	}

	public static int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (hashMap.containsKey((target - nums[i]))) {
				return new int[]{i, hashMap.get((target - nums[i]))};
			}
			hashMap.put(nums[i], i);
		}
		return new int[0];
	}
}
