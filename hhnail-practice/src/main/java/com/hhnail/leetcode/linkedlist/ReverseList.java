package com.hhnail.leetcode.linkedlist;

import java.util.Stack;

/**
 * 206. 反转链表
 *
 * https://leetcode-cn.com/problems/reverse-linked-list/
 *
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

public class ReverseList {

	public static void main(String[] args) {
		// ListNode newHead = reverseList(new ListNode(1, new ListNode(3, new ListNode(4, null))));
		ListNode newHead = reverseList2(new ListNode(1, new ListNode(3, new ListNode(4, null))));
		System.out.println(newHead);
	}

	/**
	 * 解法1
	 * 利用数据结构 —— 栈
	 */
	public static ListNode reverseList(ListNode head) {
		// 入栈，则将链表反转
		Stack<ListNode> stack = new Stack<>();
		ListNode current = head;
		while (current != null) {
			stack.push(current);
			current = current.next;
		}

		// 依次出栈构建链表
		ListNode newHead = null;
		while (!stack.isEmpty()) {
			ListNode node = stack.pop();
			// 将节点间断连，防止尾节点（即之前的头节点）保留旧的引用
			node.next = null;
			if (newHead == null) {
				newHead = node;
				current = newHead;
			} else {
				current.next = node;
				current = current.next;
			}
		}
		return newHead;
	}

	/**
	 * 解法2：leetcode官网
	 * 双指针
	 * 一个保留上个节点引用，一个用于遍历
	 */
	public static ListNode reverseList2(ListNode head) {
		// 当前位置：用于遍历
		ListNode current = head;
		// 前一节点：用于保留前节点引用（初始话则为首节点的前面，即为null）
		ListNode pre = null;
		while (current != null) {
			// 保留下一个节点的引用
			ListNode next = current.next;
			// 将当前节点下一个指向上一个节点
			current.next = pre;
			// 当前节点就是新list的新头，所以pre保留的是上一个节点，但也是新的头节点
			pre = current;
			// 因为next节点的引用是没有被破坏过的，所以current继续遍历下一个节点
			current = next;
		}
		return pre;
	}

	/**
	 * 解法3：leetcode官网
	 * 递归
	 */
	public static ListNode reverseList3(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode newHead = reverseList(head.next);
		head.next.next = head;
		head.next = null;
		return newHead;
	}

}