package com.hhnail.algorithm.leetcode.y2022.m12.d17;
// 20
//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
//
// 有效字符串需满足：
//
//
// 左括号必须用相同类型的右括号闭合。
// 左括号必须以正确的顺序闭合。
// 每个右括号都有一个对应的相同类型的左括号。
//
//
//
//
// 示例 1：
//
//
//输入：s = "()"
//输出：true
//
//
// 示例 2：
//
//
//输入：s = "()[]{}"
//输出：true
//
//
// 示例 3：
//
//
//输入：s = "(]"
//输出：false
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 104
// s 仅由括号 '()[]{}' 组成
//
// Related Topics 栈 字符串
// 👍 3615 👎 0

// 2022-11-17 16:25:24

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

class Solution {

    private static final Map<Character, Character> map = new HashMap<Character, Character>() {{
        put('{', '}');
        put('[', ']');
        put('(', ')');
        put('?', '?');
    }};

    private final Map<Character, Character> matchMap = new HashMap<Character, Character>() {{
        put('{', '}');
        put('[', ']');
        put('(', ')');
        // put('}', '{');
        // put(']', '[');
        // put(')', '(');
    }};


    public static void main(String[] args) {
        String str = "{}{}[]";
        str = "[]";
        str = "[}";
        str = "([)]";
        str = "(){}}{";
        System.out.println("answer：" + new Solution().isValid(str));
        System.out.println("my：" + new Solution().isValid2(str));
    }


    public boolean isValid2(String s) {
        Stack<Character> stack = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.add(c);
                continue;
            }
            Character peek = stack.peek();
            if (matchMap.containsKey(peek) && matchMap.get(peek).equals(c)) {
                stack.pop();
            } else {
                stack.add(c);
            }
        }
        return stack.size() == 0;
    }


    // leetcode题解
    public boolean isValid(String s) {
        if (s.length() > 0 && !map.containsKey(s.charAt(0))) {
            return false;
        }

        LinkedList<Character> stack = new LinkedList<Character>() {{
            add('?');
        }};
        for (Character c : s.toCharArray()) {
            if (map.containsKey(c)) {
                stack.addLast(c);
            } else if (map.get(stack.removeLast()) != c) {
                return false;
            }
        }
        return stack.size() == 1;
    }
}
