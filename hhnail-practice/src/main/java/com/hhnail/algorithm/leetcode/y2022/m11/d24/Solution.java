package com.hhnail.algorithm.leetcode.y2022.m11.d24;

/**
 * @author r221587
 * @version 1.0
 * @description: 9 回文数
 * @date 2022/11/24 13:07
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome(123321));
        System.out.println(new Solution().isPalindrome(1234321));
        System.out.println(new Solution().isPalindrome(-1234321));
        System.out.println(new Solution().isPalindrome(-134321));
    }

    public boolean isPalindrome(int x) {
        String str = "" + x;
        if (str.indexOf("-") > 0) {
            return false;
        }
        int length = str.length();
        for (int i = 0; i < length / 2; i++) {
            if (str.charAt(i) != str.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
