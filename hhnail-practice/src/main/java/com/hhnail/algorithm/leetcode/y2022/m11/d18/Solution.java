package com.hhnail.algorithm.leetcode.y2022.m11.d18;

/**
 * @author hhnail
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


    /**
     * 作者：力扣官方题解
     * 链接：https://leetcode.cn/problems/longest-palindromic-substring/solutions/255195/zui-chang-hui-wen-zi-chuan-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param s
     * @return
     */
    public String longestPalindrome2(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;
        // dp[i][j] 表示 s[i..j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        // 初始化：所有长度为 1 的子串都是回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();
        // 递推开始
        // 先枚举子串长度
        for (int L = 2; L <= len; L++) {
            // 枚举左边界，左边界的上限设置可以宽松一些
            for (int i = 0; i < len; i++) {
                // 由 L 和 i 可以确定右边界，即 j - i + 1 = L 得
                int j = L + i - 1;
                // 如果右边界越界，就可以退出当前循环
                if (j >= len) {
                    break;
                }

                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 只要 dp[i][L] == true 成立，就表示子串 s[i..L] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

}
