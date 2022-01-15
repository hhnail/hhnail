package com.hhnail.leetcode.datastructure01.day07;

import com.hhnail.datastructure.HSingleList;
import com.hhnail.leetcode.plan01.day05.ListNode;

import java.util.List;

public class MergeTwoLists {

	public static void main(String[] args) {

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
