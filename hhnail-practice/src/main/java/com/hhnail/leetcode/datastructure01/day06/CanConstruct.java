package com.hhnail.leetcode.datastructure01.day06;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 383. 赎金信
 * https://leetcode-cn.com/problems/ransom-note/
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 */
public class CanConstruct {

	public static void main(String[] args) {
		System.out.println(canConstruct("aa", "ab"));
	}

	public static boolean canConstruct(String ransomNote, String magazine) {
		Map<Character, Integer> nodeMap = new HashMap<>();
		Map<Character, Integer> magazineMap = new HashMap<>();
		for (int i = 0; i < ransomNote.length(); i++) {
			char value = ransomNote.charAt(i);
			if (nodeMap.containsKey(value)) {
				nodeMap.put(value, (nodeMap.get(value) + 1));
			} else {
				nodeMap.put(value, 1);
			}
		}

		for (int i = 0; i < magazine.length(); i++) {
			char value = magazine.charAt(i);
			if (magazineMap.containsKey(value)) {
				magazineMap.put(value, (magazineMap.get(value) + 1));
			} else {
				magazineMap.put(value, 1);
			}
		}

		if (nodeMap.size() > magazineMap.size()) {
			return false;
		}

		for (Map.Entry<Character, Integer> entry : nodeMap.entrySet()) {
			Integer magazineCount = magazineMap.getOrDefault(entry.getKey(), 0);
			if (magazineCount < entry.getValue()) {
				return false;
			}
		}
		return true;
	}
}
