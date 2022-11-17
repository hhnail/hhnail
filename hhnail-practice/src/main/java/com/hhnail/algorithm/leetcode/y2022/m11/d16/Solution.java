package com.hhnail.algorithm.leetcode.y2022.m11.d16;

import java.util.*;

// 最长公共前缀：编写一个函数来查找字符串数组中的最长公共前缀。
// https://leetcode.cn/problems/longest-common-prefix/description/
// 如果不存在公共前缀，返回空字符串 ""。
//
//
//
// 示例 1：
//
//
//输入：strs = ["flower","flow","flight"]
//输出："fl"
//
//
// 示例 2：
//
//
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。
//
//
//
// 提示：
//
//
// 1 <= strs.length <= 200
// 0 <= strs[i].length <= 200
// strs[i] 仅由小写英文字母组成
//
// Related Topics 字符串
// 👍 2551 👎 0
public class Solution {

    public static void main(String[] args) {
        // String[] strs = new String[]{"flower", "flow", "flight"};
        String[] strs = new String[]{"a"};
        System.out.println(new Solution().longestCommonPrefix(strs));
    }

    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 1){
            return strs[0];
        }

        int maxLength = Arrays.stream(strs).min(Comparator.comparing(String::length)).get().length();
        StringBuffer longestCommonPrefix = new StringBuffer();
        for (int i = 0; i < maxLength; i++) {
            for (int j = 0; j < strs.length - 1; j++) {
                char c1 = strs[j].charAt(i);
                char c2 = strs[j + 1].charAt(i);
                if (c1 != c2) {
                    return longestCommonPrefix.toString();
                }
                longestCommonPrefix.append(j == strs.length - 2 ? c1 : "");

            }
        }
        return longestCommonPrefix.toString();
    }
}
