package com.hhnail.algorithm.leetcode.y2022.m11.d17;

import com.hhnail.algorithm.leetcode.bean.ListNode;

/**
 * @author r221587
 * @version 1.0
 * @description: 链表常见操作
 * @date 2022/11/18 9:08
 */
public class ListNodeTest {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
        l1.next.next.next = new ListNode(9);

        ListNodeTest action = new ListNodeTest();
        action.print(l1);


        // action.add2Tail(l1,0);
        // action.print(l1);

        ListNode listNode = action.add2Head(l1, 1);
        action.print(listNode);


    }


    /**
     * 添加元素到尾巴
     */
    public void add2Tail(ListNode head, int val) {
        ListNode elem = new ListNode(val);
        ListNode p = head;
        while (p.next != null){
            p = p.next;
        }
        p.next = elem;
    }

    /**
     * 添加元素到头
     */
    public ListNode add2Head(ListNode head, int val) {
        ListNode elem = new ListNode(val);
        elem.next = head;
        return elem;
    }


    /**
     * 打印
     *
     * @param head
     */
    public void print(ListNode head) {
        StringBuffer sb = new StringBuffer();
        ListNode current = head;
        // 拼接内容
        sb.append("[");
        while (current != null) {
            boolean isTail = current.next == null;
            sb.append(current.val).append(isTail ? "" : ", ");
            current = current.next;
        }
        sb.append("]");
        System.out.println(sb.toString());
    }


}
