package com.hhnail.algorithm.leetcode.linkedlist;

/**
 * leetcode中链表约定的结构
 */
public class ListNode {
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
}
