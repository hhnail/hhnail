package com.hhnail.algorithm.leetcode.y2022.m11.d21;

import com.hhnail.util.HArrayUtil;

/**
 * @author r221587
 * @version 1.0
 * @description: 6 Z字形变换
 * @date 2022/11/21 8:46
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().convert("PAYPALISHIRING", 3));
        System.out.println(new Solution().convert("PAYPALISHIRING", 4));
        System.out.println(new Solution().convert("A", 1));
        System.out.println(new Solution().convert("ABCDE", 4));
    }

    public String convert(String s, int numRows) {
        int strLen = s.length();
        char[][] map = new char[strLen][numRows];
        // 1 一行的直接返回本身即可
        if(numRows == 1){
            return s;
        }

        // 2 把字符串摆成题解那样的char二维数组
        int widthIdx = 0;
        for (int i = 0; i < strLen; i++) {
            char c = s.charAt(i);

            // 处理斜放的字符
            if (i % (numRows + (numRows - 2)) >= numRows) {
                int dlt = 0;
                int tempI = i;
                for (int j = numRows - 2; j > 0; j--) {
                    if(tempI + dlt < strLen){
                        map[widthIdx][j] = s.charAt(tempI + dlt);
                    }
                    if (j != 1) {
                        i++;
                    }
                    dlt++;
                    widthIdx++;
                }
                continue;
            }
            // 处理竖着放的字符
            int heighIdx = i % (numRows + (numRows - 2));
            map[widthIdx][heighIdx] = c;
            if (heighIdx == (numRows - 1)) {
                widthIdx++;
            }
        }

        HArrayUtil.printCharArr(map);

        // 3 宽度优先遍历char数组，拼接为字符串即可
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < strLen; j++) {
                sb.append(map[j][i] == 0?"":map[j][i]);
            }
        }
        return sb.toString();
    }

}
