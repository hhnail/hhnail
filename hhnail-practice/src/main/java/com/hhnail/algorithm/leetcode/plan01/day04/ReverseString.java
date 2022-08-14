package com.hhnail.algorithm.leetcode.plan01.day04;

import com.hhnail.util.HArrayUtil;

/**
 *
 */
public class ReverseString {

	public static void main(String[] args) {
		char[] chars = "helloworld".toCharArray();
		ReverseString.reverseString(chars);
		HArrayUtil.printCharArr(chars);

	}

	public static void reverseString(char[] s) {
		char temp = 'n';
		int length = s.length;
		for (int i = 0; i < length / 2; i++) {
			temp = s[i];
			s[i] = s[length - i - 1];
			s[length - i - 1] = temp;
		}
	}
}
