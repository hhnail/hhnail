package com.hhnail.algorithm.leetcode.plan01.day01;

// https://leetcode-cn.com/problems/search-insert-position/submissions/
public class SearchInsert {

	public static void main(String[] args) {
		SearchInsert s = new SearchInsert();
		// int[] orderedIntArr = HArrayUtil.getOrderedIntArr(true);
		// int[] orderedIntArr = {760, 1439, 2023, 2794, 3038, 3248, 4183, 4925, 5092, 5917};
		// int[] orderedIntArr = {1};
		// int[] orderedIntArr = {1, 3, 5, 6};
		int[] orderedIntArr = {3,5,7,9,10};

		System.out.println(s.searchInsert(orderedIntArr, 8));
	}

	public int searchInsert(int[] nums, int target) {
		int leftBound = 0;
		int rightBound = nums.length - 1;
		if (target <= nums[leftBound]) {
			return 0;
		} else if (target > nums[rightBound]) {
			return (rightBound + 1);
		}
		while (rightBound - leftBound >= 0) {
			int mid = leftBound + (rightBound - leftBound) / 2; // == l + r/2 - l/2 == r/2 + l/2 = (r+l)/2
			// 如果与target不相等
			if (mid == leftBound) {
				return target > nums[leftBound] ? (leftBound + 1) : leftBound;
			}

			// 如果与target相等
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] > target) {
				rightBound = mid;
			} else {
				leftBound = mid;
			}
		}
		return -1;
	}
}
