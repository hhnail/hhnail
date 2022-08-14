package com.hhnail.algorithm.leetcode.plan01.day12;

/**
 * https://leetcode-cn.com/problems/climbing-stairs/
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 到n的前一步可能是迈了1个，可能是迈了2个
 * 所以 f（n） = f（n-1）+f（n-2）
 */
public class ClimbStairs {

	public static void main(String[] args) {

		// long time1 = System.currentTimeMillis();
		// System.out.println(climbStairs(45));
		// long time2 = System.currentTimeMillis();
		// System.out.println("======================");
		// System.out.println(time2 - time1);

		System.out.println(climbStairs2(3));

	}

	/**
	 * 递归
	 * 结果正确，但是时间复杂度不符合要求
	 */
	public static int climbStairs(int n) {
		if (n == 1) {
			return 1;
		} else if (n == 2) {
			return 2;
		}
		return climbStairs(n - 1) + climbStairs(n - 2);
	}

	/**
	 * 动态规划
	 * 1 1
	 * 2 2
	 * 3 3
	 * 4 5
	 * 5 8
	 * 6 13
	 */
	public static int climbStairs2(int n) {
		int step1 = 1;
		int step2 = 2;
		// 只有1阶，1种走法。只有2阶，2种走法
		int count = n;
		// 从3阶开始，f(n) = f(n-1) + f(n-2)
		for (int i = 3; i <= n; i++) {
			count = step1 + step2;
			step1 = step2;
			step2 = count;
		}
		return count;
	}

}
