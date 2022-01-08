package com.hhnail.leetcode.plan01.day05;

/**
 * leetcode 876. 链表的中间结点
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/
 */
public class MiddleNode {
	public static void main(String[] args) {

	}

	public ListNode middleNode(ListNode head) {
		double length = 0d;
		ListNode copy = head;
		while (copy.next != null) {
			length += 1d;
			copy = copy.next;
		}
		// (6 4=3+1 3、4 4) (5 3=2+1 2)
		ListNode middleNode = head;
		for (int i = 1; i <= Math.ceil(length / 2); i++) {
			middleNode = middleNode.next;
		}
		return middleNode;
	}
}




