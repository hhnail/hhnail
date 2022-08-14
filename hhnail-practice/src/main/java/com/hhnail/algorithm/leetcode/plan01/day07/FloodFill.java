package com.hhnail.algorithm.leetcode.plan01.day07;

import com.hhnail.util.HArrayUtil;

/**
 * https://leetcode-cn.com/problems/flood-fill/
 * @leetcode 733. 图像渲染
 *
 */
public class FloodFill {

	public static void main(String[] args) {
		int[][] image = {
				{1, 1, 1},
				{1, 1, 0},
				{1, 0, 1}
		};
		HArrayUtil.printIntArr(image);
		System.out.println("=================================");
		int[][] newImage = floodFill(image, 1, 1, 2);
		HArrayUtil.printIntArr(newImage);
	}

	public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		int height = image.length;
		int width = image[0].length;
		if (sr < 0 || sr >= height || sc < 0 || sc >= width) {
			return null;
		}
		floodFill(image, sr - 1, sc, newColor);
		floodFill(image, sr + 1, sc, newColor);
		floodFill(image, sr, sc - 1, newColor);
		floodFill(image, sr, sc + 1, newColor);
		if (sr < height && sc < width) {
			image[sr][sc] = newColor;
			return image;
		}
		return image;
	}
}
