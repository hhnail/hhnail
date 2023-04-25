package com.hhnail.web.util;

import java.util.Arrays;
import java.util.Random;

public class HArrayUtil {

	private static final Random random = new Random();

	/**
	 * getOrderedIntArr
	 * 获取有序 int 数组
	 */
	public static int[] getOrderedIntArr() {
		return getOrderedIntArr(10, false);
	}

	public static int[] getOrderedIntArr(int length) {
		return getOrderedIntArr(length, false);
	}

	public static int[] getOrderedIntArr(int length, boolean lower) {
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
		return orderedArr;
	}


	public static void printIntArr(int[] arr) {
		System.out.println(Arrays.toString(arr));
	}

	public static void printIntArr(double[] arr) {
		System.out.println(Arrays.toString(arr));
	}
}
