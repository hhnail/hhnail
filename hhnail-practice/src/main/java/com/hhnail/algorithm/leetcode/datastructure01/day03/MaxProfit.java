package com.hhnail.algorithm.leetcode.datastructure01.day03;

public class MaxProfit {

	public static void main(String[] args) {
		// int[] arr = {7, 1, 5, 3, 6, 4};
		int[] arr = {7, 6, 4, 3, 1};
		System.out.println(MaxProfit.maxProfit(arr));

	}

	public static int maxProfit(int[] prices) {
		int min = prices[0];
		int max = 0;
		for (int i = 1; i < prices.length; i++) {
			int value = prices[i];
			min = Math.min(min, value);
			max = Math.max(max, (value - min));
		}
		return max;
	}
}
