package com.hhnail.leetcode.plan01.day05;

/**
 * leetcode 19. 删除链表的倒数第 N 个结点
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/submissions/
 */
public class RemoveNthFromEnd {
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		int length = 1;
		ListNode current = head;
		while (current.next != null) {
			length++;
			current = current.next;
		}
		ListNode current2 = head;
		// l5n2=2
		for (int i = 1; i < (length - n); i++) {
			current2 = current2.next;
		}
		if (current2 == head && length == n) {
			return current2.next;
		}
		current2.next = current2.next.next;
		return head;
	}
}
