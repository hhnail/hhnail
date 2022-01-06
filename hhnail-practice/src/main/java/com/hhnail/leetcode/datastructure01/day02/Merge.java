package com.hhnail.leetcode.datastructure01.day02;

import com.hhnail.util.HArrayUtil;

import java.util.Arrays;

/**
 * leetcode
 * 88. 合并两个有序数组
 * https://leetcode-cn.com/problems/merge-sorted-array/
 */
public class Merge {
	public static void main(String[] args) {
		// case 1
		// int[] nums1 = {1, 2, 3, 0, 0, 0};
		// int[] nums2 = {2, 5, 6};
		// int m = 3;
		// int n = 3;

		// case 2
		// int[] nums1 = {1};
		// int m = 1;
		// int[] nums2 = {};
		// int n = 0;

		// case 3
		int[] nums1 = {2, 0};
		int m = 1;
		int[] nums2 = {1};
		int n = 1;

		Merge.merge(nums1, m, nums2, n);
		HArrayUtil.printIntArr(nums1);
	}

	// 输入：nums1 =,m =3,nums2 =,n =3
	// 思路一，指针扫描依次复制到新数组
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		if (n <= 0) {
			return;
		}
		int totalLength = m + n;
		int[] resArr = new int[totalLength];
		int n1p = 0;
		int n2p = 0;
		int rp = 0;
		while (rp < totalLength) {
			// 数组1扫描完毕
			if (n1p >= m) {
				System.arraycopy(nums2, n2p, resArr, rp, (n - n2p));
				break;
			}
			int value1 = nums1[n1p];
			int value2 = nums2[n2p];

			// 比较后放入结果数组
			if (value1 < value2) {
				resArr[rp] = value1;
				n1p++;
			} else if (value1 > value2) {
				resArr[rp] = value2;
				n2p++;
			} else {
				resArr[rp++] = value1;
				resArr[rp] = value2;
				n1p++;
				n2p++;
			}
			rp++;
			// 数组2扫描完毕
			if (n2p >= n) {
				System.arraycopy(nums1, n1p, resArr, rp, (m - n1p));
				break;
			}
		}
		System.arraycopy(resArr, 0, nums1, 0, resArr.length);
		// HArrayUtil.printIntArr(resArr);
		HArrayUtil.printIntArr(nums1);
	}

	// 思路二：直接合并后排序
}
