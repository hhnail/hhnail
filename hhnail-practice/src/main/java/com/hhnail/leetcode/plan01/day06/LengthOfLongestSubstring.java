package com.hhnail.leetcode.plan01.day06;

import java.util.HashSet;
import java.util.Set;

/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class LengthOfLongestSubstring {

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abcabcbb"));
	}

	public static int lengthOfLongestSubstring(String s) {
		int maxLength = 0;
		int length = s.length();
		Set<Character> set = new HashSet<>();
		for (int i = 0; i < length; i++) {
			int currentCount = 0;
			// 左指针
			int lp = i;
			// 排除不必要的统计
			if (length - lp <= maxLength) {
				return maxLength;
			}
			while (lp < length) {
				char currentLetter = s.charAt(lp);
				if (set.contains(currentLetter)) {
					break;
				} else {
					lp++;
					currentCount++;
					set.add(currentLetter);
				}
			}
			maxLength = Math.max(maxLength, currentCount);
			set.clear();
		}
		return maxLength;
	}
}
