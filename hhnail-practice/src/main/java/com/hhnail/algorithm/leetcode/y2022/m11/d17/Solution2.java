package com.hhnail.algorithm.leetcode.y2022.m11.d17;

import com.hhnail.algorithm.leetcode.bean.ListNode;

import java.math.BigDecimal;

/**
 * @author r221587
 * @version 1.0
 * @description: 2 两数相加
 * @date 2022/11/17 16:59
 */
public class Solution2 {

    public static void main(String[] args) {
        // case1
        // ListNode l1 = new ListNode(2);
        // l1.add2Tail(l1,4);
        // l1.add2Tail(l1,3);
        //
        // ListNode l2 = new ListNode(5);
        // l2.add2Tail(l2,6);
        // l2.add2Tail(l2,4);

        // case2
        // ListNode l1 = new ListNode(2);
        // l1.add2Tail(l1, 4);
        // l1.add2Tail(l1, 9);
        //
        // ListNode l2 = new ListNode(5);
        // l2.add2Tail(l2, 6);
        // l2.add2Tail(l2, 4);
        // l2.add2Tail(l2, 9);


        // case3
        ListNode l1 = new ListNode(9);
        // [1,9,9,9,9,9,9,9,9,9]
        ListNode l2 = new ListNode(1);
        l2.add2Tail(l2, 9);
        l2.add2Tail(l2, 9);
        l2.add2Tail(l2, 9);
        l2.add2Tail(l2, 9);
        l2.add2Tail(l2, 9);
        l2.add2Tail(l2, 9);
        l2.add2Tail(l2, 9);
        l2.add2Tail(l2, 9);
        l2.add2Tail(l2, 9);


        System.out.println(new Solution2().addTwoNumbers(l1, l2));

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuffer sb1 = new StringBuffer();
        StringBuffer sb2 = new StringBuffer();
        ListNode p1 = l1;
        ListNode p2 = l2;
        while (p1 != null || p2 != null) {
            if (p1 != null) {
                sb1.append(p1.val);
                p1 = p1.next;
            }
            if (p2 != null) {
                sb2.append(p2.val);
                p2 = p2.next;
            }

        }

        BigDecimal i1 = new BigDecimal(sb1.reverse().toString());
        BigDecimal i2 = new BigDecimal(sb2.reverse().toString());
        BigDecimal resLong = i1.add(i2);
        String resStr = resLong.toString();

        ListNode res = new ListNode(Character.getNumericValue(resStr.charAt(resStr.length() - 1)));
        for (int i = resStr.length() - 2; i >= 0; i--) {
            ListNode tmpNode = new ListNode(Character.getNumericValue(resStr.charAt(i)));
            ListNode p = res;
            while (p.next != null) {
                p = p.next;
            }
            p.next = tmpNode;
        }
        return res;
    }


}
