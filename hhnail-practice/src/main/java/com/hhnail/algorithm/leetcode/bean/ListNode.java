package com.hhnail.algorithm.leetcode.bean;

/**
 * 链表题目：节点类
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    // 默认当前节点为head
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        ListNode current = this;
        // 拼接内容
        sb.append("[");
        while (current != null) {
            boolean isTail = current.next == null;
            sb.append(current.val).append(isTail ? "" : ", ");
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }

    public void add2Tail(ListNode head,int val){
        ListNode elem = new ListNode(val);
        ListNode p = head;
        while (p.next != null){
            p = p.next;
        }
        p.next = elem;
    }
}
