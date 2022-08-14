package com.hhnail.algorithm.leetcode.d220722;

/*
剑指 Offer II 077. 链表排序
https://leetcode.cn/problems/7WHec2/
 */
public class Solution2 {

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        s.sortList(null);


        // List<String> test = new ArrayList<>();
        // test.add("a");
        // test.add("b");
        // test.add("a");
        // System.out.println(test);

    }

    public ListNode sortList(ListNode head) {

        return null;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}