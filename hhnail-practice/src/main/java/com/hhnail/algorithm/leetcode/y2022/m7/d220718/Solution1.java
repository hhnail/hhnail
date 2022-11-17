package com.hhnail.algorithm.leetcode.y2022.m7.d220718;

/*
7. 整数反转
https://leetcode.cn/problems/reverse-integer/
 */
public class Solution1 {

    public static void main(String[] args) {
        // System.out.println(reverse(9646324351));
        // System.out.println(Integer.parseInt("-"+"321"));
        System.out.println(reverse2(-123));
        // System.out.println(Integer.MAX_VALUE);
        // 2147483647
        // 9646324351
    }


    public static int reverse(int x) {
        String s = String.valueOf(x);
        StringBuffer result = new StringBuffer();
        boolean negative = s.contains("-");
        for (int i = s.length() - 1; i >= (negative ? 1 : 0); i--) {
            result.append(s.charAt(i));
        }
        int i = 0;
        try {
            i = Integer.parseInt(result.toString());
            return negative ? (0 - i) : i;
        } catch (Exception e) {
            return 0;
        }
    }


    /**
     * 评论里别人的写法
     *
     * @param x
     * @return
     */
    public static int reverse2(int x) {
        // 用long来记录，因为可能超过int的范围
        long n = 0;
        while (x != 0) {
            // n记录的是上一位的数
            // x记录末尾被截取后的数
            n = n * 10 + x % 10;
            // 从个位开始，依次往前
            x = x / 10;
        }
        // long强转为int，如果不等于原来的值，说明超过范围了
        return (int) n == n ? (int) n : 0;
    }
}
