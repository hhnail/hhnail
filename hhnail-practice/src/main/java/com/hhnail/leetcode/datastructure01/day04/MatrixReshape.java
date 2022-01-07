package com.hhnail.leetcode.datastructure01.day04;

import com.hhnail.util.HArrayUtil;

/**
 * leetcode 566. 重塑矩阵
 * https://leetcode-cn.com/problems/reshape-the-matrix/
 */
public class MatrixReshape {
	public static void main(String[] args) {
		int[][] mat = {{1, 2}, {3, 4}};
		int r = 1;
		int c = 4;
		int[][] res = MatrixReshape.matrixReshape(mat, r, c);
		HArrayUtil.printIntArr(res);
	}


	/**
	 * @param mat 待重构的矩阵
	 * @param r   重构的矩阵的行数
	 * @param c   重构的矩阵的列数
	 * @return
	 */
	public static int[][] matrixReshape(int[][] mat, int r, int c) {
		int rowNum = mat.length;
		int columnNum = mat[0].length;
		if (rowNum * columnNum != r * c) {
			return mat;
		}
		// 记录扫描到mat的横、纵坐标
		int x = 0;
		int y = 0;
		int[][] res = new int[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				res[i][j] = mat[y][x++];
				// 扫描原始矩阵的下一行
				if (x >= columnNum) {
					x = 0;
					y++;
				}
			}
		}
		return res;
	}
}
