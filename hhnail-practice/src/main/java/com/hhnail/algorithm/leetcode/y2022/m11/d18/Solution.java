package com.hhnail.algorithm.leetcode.y2022.m11.d18;

/**
 * @author r221587
 * @version 1.0
 * @description: 5 最长回文子串
 * @date 2022/11/18 13:47
 */
public class Solution {

    public static void main(String[] args) {
        // String str = "babad";
        // String str = "abba";
        String str = "eabcb";
        System.out.println(new Solution().longestPalindrome(str));
    }

    public String longestPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        int tmpL = l;
        int tmpR = r;
        StringBuffer lSb = new StringBuffer();
        StringBuffer rSb = new StringBuffer();
        while (l <= r) {
            char lC = s.charAt(tmpL);
            char rC = s.charAt(tmpR);
            lSb.append(lC);
            if (tmpL != tmpR) {
                rSb.append(rC);
            } else {
                break;
            }
            if (lC == rC) {
                tmpL++;
                tmpR--;
                if (tmpL > tmpR) {
                    break;
                }
            } else {
                if (lC == s.charAt(tmpR - 1)) {
                    tmpR--;
                } else if (rC == s.charAt(tmpL + 1)) {
                    tmpL++;
                } else {
                    tmpR--;
                    tmpL++;
                    r--;
                    l++;
                }
                lSb = new StringBuffer();
                rSb = new StringBuffer();
            }
        }
        return lSb.append(rSb.reverse().toString()).toString();
    }


}
