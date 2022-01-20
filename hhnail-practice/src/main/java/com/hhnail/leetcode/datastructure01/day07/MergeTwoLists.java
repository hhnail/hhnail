package com.hhnail.leetcode.datastructure01.day07;

import com.hhnail.leetcode.plan01.day05.ListNode;

import java.util.List;


// TODO
public class MergeTwoLists {

	public static void main(String[] args) {
		ListNode node4 = new ListNode(4);
		ListNode node3 = new ListNode(3, node4);
		ListNode node1 = new ListNode(1, node3);

		ListNode listNode4 = new ListNode(4);
		ListNode listNode2 = new ListNode(2, listNode4);
		ListNode listNode1 = new ListNode(1, listNode2);

		ListNode listNode = mergeTwoLists(node1, listNode1);
		System.out.println(listNode);
	}

	public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		ListNode newHead = new ListNode();
		while (list1.next != null || list2.next != null) {
			if (list1.val <= list2.val) {
				if (newHead == null) {
					newHead = list1;
					newHead.next = list2;
				} else {
					newHead.next = list1;
					newHead.next.next = list2;
				}
			} else {
				if (newHead == null) {
					newHead = list2;
					newHead.next = list1;
				} else {
					newHead.next = list2;
					newHead.next.next = list1;
				}
			}
			list1 = list1.next;
			list2 = list2.next;
			if (list1.next == null || list2.next == null) {
				newHead.next = (list1 == null ? list2 : list1);
				return newHead;
			}
		}
		return newHead;
	}
}
