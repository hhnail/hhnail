package com.hhnail.algorithm.leetcode.datastructure01.day05;

import com.hhnail.util.HArrayUtil;

import java.util.HashSet;
import java.util.Vector;

/**
 * leetcode 73. 矩阵置零
 * https://leetcode-cn.com/problems/set-matrix-zeroes/
 */
public class SetZeroes {

	public static void main(String[] args) {
		int[][] matrix = {
				{0, 1, 2, 0},
				{3, 4, 5, 2},
				{1, 3, 1, 5}
		};
		setZeroes(matrix);
	}

	public static void setZeroes(int[][] matrix) {
		int height = matrix.length;
		HashSet<Integer> unDupRow = new HashSet();
		HashSet<Integer> unDupColumn = new HashSet();
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == 0) {
					unDupRow.add(i);
					unDupColumn.add(j);
				}
			}
		}
		int[] emptyArr = new int[matrix[0].length];
		unDupRow.forEach(item -> {
			matrix[item] = emptyArr;
		});
		unDupColumn.forEach(item -> {
			for (int i = 0; i < height; i++) {
				matrix[i][item] = 0;
			}
		});
		// System.out.println(unDupRow);
		// System.out.println(unDupColumn);
		// HArrayUtil.printIntArr(matrix);
	}
}
