package com.hhnail.algorithm.leetcode.datastructure01.day03;

import com.hhnail.util.HArrayUtil;

import java.util.Arrays;

public class Intersect {

	public static void main(String[] args) {
		int[] nums1 = {4, 9, 5};
		int[] nums2 = {9, 4, 9, 8, 4};
		HArrayUtil.printIntArr(Intersect.intersect(nums1, nums2));
	}

	public static int[] intersect(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int p1 = 0, p2 = 0, rp = 0;
		int length1 = nums1.length;
		int length2 = nums2.length;
		int[] res = new int[length1 + length2];
		while (p1 < length1 && p2 < length2) {
			int value1 = nums1[p1];
			int value2 = nums2[p2];
			if (value1 == value2) {
				res[rp++] = value1;
				p1++;
				p2++;
			} else if (value1 > value2) {
				p2++;
			} else {
				p1++;
			}
		}
		int[] res2 = new int[rp];
		System.arraycopy(res, 0, res2, 0, rp);
		return res2;
	}
}
