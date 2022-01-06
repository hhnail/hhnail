package com.hhnail.leetcode.plan01.day02;

import com.hhnail.util.HArrayUtil;

public class Rotate {
	public static void main(String[] args) {
		Rotate r = new Rotate();
		System.out.print("我是原数组");
		int[] orderedIntArr = HArrayUtil.getOrderedIntArr(true);
		// r.rotate(orderedIntArr, 3);
		// HArrayUtil.printIntArr(orderedIntArr);

		r.valuePassTest01(orderedIntArr);
		System.out.print("我是方法调用后的数组引用：");
		HArrayUtil.printIntArr(orderedIntArr);

		// r.valuePassTest02(orderedIntArr);
		// System.out.print("我是方法调用后（arrayCopy）的数组引用：");
		// HArrayUtil.printIntArr(orderedIntArr);
	}

	public void rotate(int[] nums, int k) {
		int length = nums.length;
		int left = length - (k % length);
		int right = k % length;
		int[] newArr = new int[length];
		// 移动右部分
		System.arraycopy(nums, left, newArr, 0, right);
		// 移动左部分
		System.arraycopy(nums, 0, newArr, right, left);
		System.arraycopy(newArr, 0, nums, 0, length);
	}

	public void valuePassTest01(int[] nums) {
		// System.out.println("我是方法内的值传递：" + HArrayUtil.printIntArr(nums, true));
		// nums = new int[nums.length];
		nums[0] = 999;
		// System.out.print("我是方法内的引用重新赋值：");
		// HArrayUtil.printIntArr(nums);
	}

	public void valuePassTest02(int[] nums) {
		int[] newArr = new int[nums.length];
		System.arraycopy(newArr, 0, nums, 0, nums.length);
	}


}
