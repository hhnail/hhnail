package com.hhnail.algorithm.leetcode.y2022.m7.d220723;

/**
 * @Tags:动态规划、递归
剑指 Offer 10- I. 斐波那契数列
https://leetcode.cn/problems/fei-bo-na-qi-shu-lie-lcof/

F(0) = 0,   F(1) = 1
F(N) = F(N - 1) + F(N - 2), 其中 N > 1.

规定超过1000000007取模，例如1000000008取模得到1
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(fib(2));
        System.out.println(fib2(2));
        System.out.println(fib(5));
        System.out.println(fib2(5));
        long l1 = System.currentTimeMillis();
        System.out.println(fib(44));
        System.out.println(System.currentTimeMillis() - l1);

        long l2 = System.currentTimeMillis();
        System.out.println(fib2(44));
        System.out.println(System.currentTimeMillis() - l2);

    }

    /**
     * 写法1：递归
     */
    public static int fib(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return (fib(n - 1) + fib((n - 2))) % 1000000007;
        }

    }

    /**
     * 写法2：动态规划
     * 受题解开导
     */
    public static int fib2(int n) {
        if (n < 2) {
            return n;
        }
        int p1 = 0;
        int p2 = 0;
        int result = 1;
        /*
        0  1 1 2 3 ——> 3
        0  1 1 2 3 5 ——> 4
         */
        for (int i = 2; i <= n; i++) {
            p1 = p2;
            p2 = result;
            result = p1 + p2;
            if (result > 1000000007) {
                result -= 1000000007;
            }
        }
        return result;
    }


}
