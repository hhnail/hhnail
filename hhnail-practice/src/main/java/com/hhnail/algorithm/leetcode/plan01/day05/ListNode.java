package com.hhnail.algorithm.leetcode.plan01.day05;

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

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		ListNode cur = this;
		while (cur != null) {
			sb.append(cur.val);
			if (cur.next != null) {
				sb.append(", ");
			}
		}
		sb.append("]");
		return sb.toString();
	}
}
