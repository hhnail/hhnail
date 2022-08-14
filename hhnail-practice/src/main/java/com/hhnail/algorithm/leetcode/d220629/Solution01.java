package com.hhnail.algorithm.leetcode.d220629;

import com.hhnail.util.ByteUtil;

/**
 * 2220. 转换数字的最少位翻转次数
 * https://leetcode.cn/problems/minimum-bit-flips-to-convert-number/
 */
public class Solution01 {

    public static void main(String[] args) {
        // char a = '1';
        // char b = '2';
        // char c = '2';
        // System.out.println(a == b);
        // System.out.println(c == b);


        // int count = minBitFlips(3, 4);
        // System.out.println(count);

        // int cout2 = minBitFlips2(3, 4);
        // int cout2 = minBitFlips2(10, 7);
        // System.out.println(cout2);


        // System.out.println(Byte.parseByte("1011"));
        System.out.println((byte)Integer.valueOf("1011").intValue());

    }

    /**
     * 解法1
     * 思路：对应位置的值不同说明需要翻转，统计不同位置即可
     */
    public static int minBitFlips(int start, int goal) {
        String startStr = Integer.toBinaryString(start);
        String goalStr = Integer.toBinaryString(goal);
        int gap = startStr.length() - goalStr.length();
        // 拼接前缀的0
        StringBuffer prefix = new StringBuffer();
        for (int i = 0; i < Math.abs(gap); i++) {
            prefix.append("0");
        }
        if (gap > 0) {
            goalStr = prefix.append(goalStr).toString();
        } else {
            startStr = prefix.append(startStr).toString();
        }
        // 计算需要翻转的个数
        int count = 0;
        char[] goalChars = goalStr.toCharArray();
        char[] startChars = startStr.toCharArray();
        for (int i = 0; i < goalStr.length(); i++) {
            if (goalChars[i] != startChars[i]) {
                count++;
            }
        }

        return count;
    }

    /**
     * 解法2（未完成，卡在统计1的个数）
     * 思路：不同位置 取抑或（^）即是1，然后统计1的个数
     */
    public static int minBitFlips2(int start, int goal) {
        String s1 = Integer.toBinaryString(start);
        String s2 = Integer.toBinaryString(goal);
        byte b1 = Byte.parseByte(s1);
        byte b2 = Byte.parseByte(s2);
        int count = 0;
        for (String s : ((b1 ^ b2) + "").split("")) {
            if("1".equals(s)){
                count++;
            }
        }
        return count;
    }
}