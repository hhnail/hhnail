package com.hhnail.leetcode.datastructure01.day06;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 387. 字符串中的第一个唯一字符
 * https://leetcode-cn.com/problems/first-unique-character-in-a-string/
 */
public class FirstUniqChar {

	public static void main(String[] args) {
		int firstUniqueIndex = firstUniqChar("loveleetcode");
		System.out.println(firstUniqueIndex);
	}

	public static int firstUniqChar(String s) {
		char[] chars = s.toCharArray();
		Map<Character, Integer> map = new HashMap();
		for (int i = 0; i < chars.length; i++) {
			char value = chars[i];
			if (map.containsKey(value)) {
				Integer count = map.get(value);
				map.replace(value, (count + 1));
			} else {
				map.put(chars[i], 1);
			}
		}
		// System.out.println(map);
		for (int i = 0; i < chars.length; i++) {
			char value = chars[i];
			// 若有key，判断count；若无key，说明他是重复的，已经排除判断了
			if (map.containsKey(value)) {
				if (map.get(value) == 1) {
					return i;
				} else {
					map.remove(value);
				}
			}
		}
		return -1;
	}

	@Test
	public void testCharEqual() {
		char a = 'a';
		char a2 = 'a';
		char b = 'b';
		System.out.println(a == a);
		System.out.println(a == a2);
		System.out.println(a == b);
	}
}
