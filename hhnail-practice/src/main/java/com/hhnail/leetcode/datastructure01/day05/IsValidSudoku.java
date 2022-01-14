package com.hhnail.leetcode.datastructure01.day05;

import java.util.HashMap;
import java.util.HashSet;

/*
00 01 02    03 04 05
10 11 12    13 14 15
20 21 22    23 24 25






 */
public class IsValidSudoku {
	public static void main(String[] args) {
		// char[][] board = {
		// 		{'8', '3', '.', '.', '7', '.', '.', '.', '.'},
		// 		{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
		// 		{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
		// 		{'1', '.', '.', '.', '6', '.', '.', '.', '3'},
		// 		{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
		// 		{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
		// 		{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
		// 		{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
		// 		{'.', '.', '.', '.', '8', '.', '.', '7', '9'}
		// };

		// char[][] board = {
		// 		{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
		// 		{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
		// 		{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
		// 		{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
		// 		{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
		// 		{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
		// 		{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
		// 		{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
		// 		{'.', '.', '.', '.', '8', '.', '.', '7', '9'}
		// };

		// char[][] board = {
		// 		{'.', '.', '.', '.', '5', '.', '.', '1', '.'},
		// 		{'.', '4', '.', '3', '.', '.', '.', '.', '.'},
		// 		{'.', '.', '.', '.', '.', '3', '.', '.', '1'},
		// 		{'8', '.', '.', '.', '.', '.', '.', '2', '.'},
		// 		{'.', '.', '2', '.', '7', '.', '.', '.', '.'},
		// 		{'.', '1', '5', '.', '.', '.', '.', '.', '.'},
		// 		{'.', '.', '.', '.', '.', '2', '.', '.', '.'},
		// 		{'.', '2', '.', '9', '.', '.', '.', '.', '.'},
		// 		{'.', '.', '4', '.', '.', '.', '.', '.', '.'}
		// };

		char[][] board = {
				{'.', '.', '.', '.', '.', '.', '5', '.', '.'},
				{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
				{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
				{'9', '3', '.', '.', '2', '.', '4', '.', '.'},
				{'.', '.', '7', '.', '.', '.', '3', '.', '.'},
				{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
				{'.', '.', '.', '3', '4', '.', '.', '.', '.'},
				{'.', '.', '.', '.', '.', '3', '.', '.', '.'},
				{'.', '.', '.', '.', '.', '5', '2', '.', '.'}};

		System.out.println(isValidSudoku(board));
	}

	public static boolean isValidSudoku(char[][] board) {
		int totalLength = 9;
		for (int i = 0; i < totalLength; i++) {
			// 判断每一行（i代表第i行）
			HashSet<Character> rowSet = new HashSet<Character>();
			int rowCount = 0;
			// 判断每一列（i代表第i列）
			HashSet<Character> columnSet = new HashSet<Character>();
			int columnCount = 0;
			for (int j = 0; j < totalLength; j++) {
				char rowVal = board[i][j];
				char colVal = board[j][i];
				if (rowVal != '.') {
					rowSet.add(rowVal);
					rowCount++;
				}
				if (colVal != '.') {
					columnSet.add(colVal);
					columnCount++;
				}
			}
			if (rowSet.size() != rowCount || columnSet.size() != columnCount) {
				return false;
			}
			// 判断每一格（i代表第i块）
			HashSet<Character> bolckSet = new HashSet<Character>();
			int bolckCount = 0;
			int rowIndex = 0;
			if (i > 5) {
				rowIndex = 6;
			} else if (i > 2) {
				rowIndex = 3;
			}
			for (int j = 0; j < totalLength; j++) {
				if (j > 0 && j % 3 == 0) {
					rowIndex++;
				}
				char value = board[rowIndex][(j % 3 + (i % 3) * 3)];
				if (value != '.') {
					bolckSet.add(value);
					bolckCount++;
				}
			}
			if (bolckCount != bolckSet.size()) {
				return false;
			}
		}
		return true;
	}
}