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
        // String str = "eabcb";
        String str = "bcbea";
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
            if (tmpL < tmpR) {
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
                /**
                 * 写到这才发现这个思路走不通。
                 * 错误思路：从两边逐渐往中间判断，第一个符合回文的是最长的
                 * 因为要从最小的回文往外判断才行，不走到最小谁都不知道是不是回文
                 * 所以两边指针往中间走的时候，这里会判断到底左右指针谁往中间靠。
                 * 我本来向判断这个字符是否在范围内，然后谁离这个边界远（谁就越【可能】是最长回文）
                 * 但是这个判断是不准确的，因为上面这个“可能”，导致最长的字符不一定是回文，反而短的那个才是回文。
                 */
                if (s.substring(tmpL, tmpR - 1).contains(lC + "")) {
                    tmpL++;
                } else if (s.substring(tmpL + 1, tmpR).contains(rC + "")) {
                    tmpR--;
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
