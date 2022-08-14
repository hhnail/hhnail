package com.hhnail.algorithm.leetcode.plan01.day06;

public class TestFor {
	public static void main(String[] args) {

		int fre = 500000000;

		// 预热一下
		for (int i = 0; i < fre; i++) {
			// System.out.println(i);
		}

		long time1 = System.nanoTime();
		for (int i = 0; i < fre; i++) {
			for (int j = 0; j < fre; j++) {
			}
		}
		long time2 = System.nanoTime();
		System.out.println(time2 - time1);

		System.out.println("======================");

		// 据说++i效率更高 ？？ 为什么我测试的永远的i++效率更高呢
		long time3 = System.nanoTime();
		for (int i = 0; i < fre; ++i) {
			for (int j = 0; j < fre; ++j) {
			}
		}
		long time4 = System.nanoTime();
		System.out.println(time4 - time3);
	}
}
