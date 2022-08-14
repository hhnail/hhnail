package com.hhnail.algorithm.leetcode.datastructure01.day04;

import java.util.ArrayList;
import java.util.List;

public class Generate {
	public static void main(String[] args) {
		generate(5);
	}

	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> res = new ArrayList<>();
		for (int i = 0; i < numRows; i++) {
			List<Integer> row = new ArrayList<>();
			// 头两层
			if (i < 2) {
				int k = 0;
				while (k <= i) {
					row.add(1);
					k++;
				}
			} else { // 第三层开始
				row.add(1);
				for (int j = 1; j < i; j++) {
					List<Integer> preRow = res.get(i - 1);
					row.add(preRow.get(j-1) + preRow.get(j));
				}
				row.add(1);
			}
			res.add(row);
		}
		return res;
	}
}
