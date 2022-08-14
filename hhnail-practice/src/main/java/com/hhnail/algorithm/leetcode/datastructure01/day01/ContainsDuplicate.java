package com.hhnail.algorithm.leetcode.datastructure01.day01;

import org.junit.Test;

import java.util.HashMap;

public class ContainsDuplicate {
	public static void main(String[] args) {
		ContainsDuplicate c = new ContainsDuplicate();
		int[] arr = {1, 3, 4, 2};
		System.out.println(c.containsDuplicate(arr));

	}

	public boolean containsDuplicate(int[] nums) {
		HashMap<Integer, String> map = new HashMap();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], "");
			if (map.size() - i != 1) {
				return true;
			}
		}
		return false;
	}


	@Test
	public void testMapp() {
		HashMap<Integer, String> map = new HashMap();
		map.put(1, "");
		map.put(1, "");
		System.out.println(map);
		System.out.println(map.size());
	}
}
