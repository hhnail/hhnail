package com.hhnail.algorithm.leetcode.d220814;

import com.hhnail.algorithm.leetcode.bean.ListNode;

/**
 * 148. 排序链表
 * https://leetcode.cn/problems/sort-list/
 * @Status 未解决
 */
public class Solution {
    public static void main(String[] args) {
        ListNode node4 = new ListNode(4);
        ListNode node3 = new ListNode(3, node4);
        ListNode node1 = new ListNode(1, node3);
        ListNode node2 = new ListNode(2, node1);

        System.out.println(node2);

        // sortList(node2);

    }

    public static ListNode sortList(ListNode head) {
        // 获取长度
        int length = 1;
        ListNode current = head;
        while (current.next != null) {
            length++;
            current = current.next;
        }

        // 排序
        current = head;
        ListNode[] arr = new ListNode[length];
        while (current.next != null) {
            arr[current.val] = current;
            current = current.next;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                System.out.println(arr[i].val);
            }
        }


        return null;
    }
}
