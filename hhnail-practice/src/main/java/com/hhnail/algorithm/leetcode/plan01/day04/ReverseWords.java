package com.hhnail.algorithm.leetcode.plan01.day04;

/**
 * leetcode
 * 557. 反转字符串中的单词 III
 * https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/
 */
public class ReverseWords {

	public static void main(String[] args) {
		System.out.println(ReverseWords.reverseWords2("Let's take LeetCode contest"));
	}

	// 思路一：用空格分隔，单独翻转每个单词
	public static String reverseWords(String s) {


		return null;
	}

	// 思路二：翻转整个句子，然后调整单词顺序
	public static String reverseWords2(String s) {
		char[] chars = s.toCharArray();
		int length = chars.length;
		char temp;
		// 翻转整个句子
		for (int i = 0; i < length / 2; i++) {
			temp = chars[i];
			chars[i] = chars[length - i - 1];
			chars[length - i - 1] = temp;
		}
		// 调整单词顺序
		String str = String.valueOf(chars);
		String[] strArr = str.split(" ");
		StringBuffer sb = new StringBuffer();
		for (int i = strArr.length - 1; i >= 0; i--) {
			sb.append(strArr[i]).append(" ");
		}
		return sb.substring(0, sb.length() - 1);
	}


}
