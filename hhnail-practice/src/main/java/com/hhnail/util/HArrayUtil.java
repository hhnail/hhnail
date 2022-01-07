package com.hhnail.util;

import java.util.Arrays;
import java.util.Random;

public class HArrayUtil {

	private static final Random random = new Random();

	/**
	 * getOrderedIntArr
	 * 获取有序 int 数组
	 */
	public static int[] getOrderedIntArr() {
		return getOrderedIntArr(10, false, false);
	}

	public static int[] getOrderedIntArr(boolean needPrint) {
		return getOrderedIntArr(10, false, needPrint);
	}

	public static int[] getOrderedIntArr(int length) {
		return getOrderedIntArr(length, false, false);
	}

	public static int[] getOrderedIntArr(int length, boolean lower, boolean needPrint) {
		int[] orderedArr = new int[length];
		for (int i = 0; i < length; i++) {
			int maxGap = 1000;
			int randomInt = random.nextInt(maxGap);
			if (i - 1 >= 0) {
				orderedArr[i] = orderedArr[i - 1] + (lower ? (-randomInt) : randomInt);
			} else {
				orderedArr[i] = randomInt;
			}
		}
		if (needPrint) {
			printIntArr(orderedArr);
		}
		return orderedArr;
	}


	public static void printIntArr(int[] arr) {
		System.out.println(Arrays.toString(arr));
	}

	public static void printIntArr(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
	}

	public static void printCharArr(char[] arr) {
		System.out.println(Arrays.toString(arr));
	}

	public static String printIntArr(int[] arr, boolean needString) {
		return Arrays.toString(arr);
	}

	public static void printIntArr(double[] arr) {
		System.out.println(Arrays.toString(arr));
	}
}
