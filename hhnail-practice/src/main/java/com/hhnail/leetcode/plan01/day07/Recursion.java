package com.hhnail.leetcode.plan01.day07;

public class Recursion {

	public static void main(String[] args) {
		int i = countSum(4);
		System.out.println(i);
	}

	public static int countSum(int n) {
		if (n <= 1) {
			return 1;
		}
		return countSum(n - 1) + n;
	}
}
