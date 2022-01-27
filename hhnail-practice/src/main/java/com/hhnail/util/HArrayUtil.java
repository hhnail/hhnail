package com.hhnail.util;

import java.util.Arrays;
import java.util.Random;

public class HArrayUtil {

	private static final int DEFAULT_LENGTH = 10;

	private static final Random random = new Random();

	/**
	 * getOrderedIntArr
	 * 获取有序 int 数组
	 */
	public static int[] getOrderedIntArr() {
		// 默认长度为10
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

	/**
	 * 获取无序随机 int[]
	 * @param bound 边界值，不包含边界自身  [0,bound)
	 * @return
	 */
	public static int[] getRandomIntArr(int bound) {
		int[] randomIntArr = new int[DEFAULT_LENGTH];
		// 参数校验
		if (bound <= 0) {
			System.err.println("边界值必须为正数！");
			return randomIntArr;
		}

		Random r = new Random();
		for (int i = 0; i < randomIntArr.length; i++) {
			randomIntArr[i] = r.nextInt(bound);
		}
		return randomIntArr;
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
