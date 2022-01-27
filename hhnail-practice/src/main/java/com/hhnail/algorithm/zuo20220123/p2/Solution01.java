package com.hhnail.algorithm.zuo20220123.p2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * https://www.bilibili.com/video/BV1zS4y1o7bz?p=2
 * <p>
 * <p>
 * @Question:给一个int的arr，用arr拼接出一个能被3整除的最大的数字（字符串返回）
 * <p>
 * <p>
 * 因为移除一个数字就是一位数了，所以尽量只移除一位数
 * <p>
 * 个位、十位、百位。。。 加起来 %3 == 1 移除一个 %3 == 1的e
 * 不行就 %3 == 2 的两个（因为2个2就是4，4%3 == 1）
 * <p>
 * 加起来 %3 == 2 移除一个%3 ==2的
 * 不行就两个%3==1的（因为2个1==2）
 */
public class Solution01 {
	public static void main(String[] args) {
		// int[] arr = HArrayUtil.getRandomIntArr(10);
		int[] arr = {3, 3, 1, 1, 1, 2}; // 直接能被3整除
		// HArrayUtil.printIntArr(arr);
		String res = solve(arr);
		System.out.println(res);
	}

	public static String solve(int[] arr) {
		StringBuffer res = new StringBuffer();
		Arrays.sort(arr);
		int sum = Arrays.stream(arr).sum();
		// 提取if条件的判断条件，提高效率
		int moldSum = sum % 3;
		// 全都用上
		if (moldSum == 0) {
			for (int i = arr.length - 1; i >= 0; i--) {
				res.append(arr[i]);
			}
		} else { // 需要移除数字
			// 1、将%3结果进行分类保存
			List<Integer> mold1 = new ArrayList<>();
			List<Integer> mold2 = new ArrayList<>();
			List<Integer> mold3 = new ArrayList<>();
			for (int i = 0; i < arr.length; i++) {
				int value = arr[i];
				if (value % 3 == 1) {
					mold1.add(value);
				} else if (value % 3 == 2) {
					mold2.add(value);
				} else {
					mold3.add(value);
				}
			}

			// 2、开始移除
			if (moldSum == 1) { // 移除1个1或者2个2
				if (mold1.size() > 0) {
					mold1.remove(0);
				} else if (mold2.size() >= 2) {
					mold2.remove(0);
					mold2.remove(0);
				}
			} else if (moldSum == 2) { // 移除1个2或者2个1
				if (mold2.size() > 0) {
					mold2.remove(0);
				} else if (mold1.size() >= 2) {
					mold1.remove(0);
					mold1.remove(0);
				}
			}

			// 3、拼接结果
			mold3.addAll(mold1);
			mold3.addAll(mold2);
			// 升序排列
			mold3.sort(Comparator.reverseOrder());
			for (Integer value : mold3) {
				res.append(value);
			}
		}
		return res.toString();
	}
}
