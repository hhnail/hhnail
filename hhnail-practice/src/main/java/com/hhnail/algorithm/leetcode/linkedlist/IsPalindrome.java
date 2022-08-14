package com.hhnail.algorithm.leetcode.linkedlist;

import java.util.Stack;

/**
 * 剑指 Offer II 027. 回文链表
 * @Vtag：栈、快慢指针
 * https://leetcode-cn.com/problems/aMhZSa/
 */
public class IsPalindrome {

	public static void main(String[] args) {
		ListNode head = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));
		// ListNode head = new ListNode(1, new ListNode(0, new ListNode(0, null)));
		System.out.println(head);
		// System.out.println(isPalindrome(head));
		System.out.println(isPalindrome2(head));
	}

	/**
	 * 解法1：利用栈结构
	 *
	 * @param head 头节点
	 * @return 是否是回文链表
	 */
	public static boolean isPalindrome(ListNode head) {
		// 无节点或单节点
		if (head == null || head.next == null) {
			return true;
		}
		ListNode current = head;
		Stack<ListNode> stack = new Stack<>();
		int listSize = 0;
		// 依次入栈
		while (current != null) {
			stack.push(current);
			current = current.next;
			listSize++;
		}
		// 判断回文
		current = head; // 复用指针
		int pastHalf = listSize / 2; // 减少判断次数，判断半段即可
		while (!stack.isEmpty() && pastHalf-- > 0) { // pastHalf先判断，再--
			ListNode node = stack.pop();
			// 注意要判断val，而不是判断node（因为回文是用头和尾在比较，他们val相同，但是对象不是一个对象）
			if (node.val != current.val) {
				return false;
			}
			current = current.next;
		}
		return true;
	}

	/**
	 * 解法2：快慢指针
	 * 快指针走两步，慢指针走一步。这样快指针走到头时，慢指针刚好走到一半的位置，刚好开始入栈
	 * @param head
	 * @return
	 */
	public static boolean isPalindrome2(ListNode head) {
		// 无节点或单节点
		if (head == null || head.next == null) {
			return true;
		}
		// 将slow指针指向后半段的第一个节点
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			if (fast.next == null) {
				slow = slow.next;
				break;
			}
			fast = fast.next.next;
		}
		// 将后半段入栈
		Stack<ListNode> stack = new Stack<>();
		while (slow != null) {
			stack.push(slow);
			slow = slow.next;
		}
		// 判断回文
		slow = head;
		while (!stack.isEmpty()) {
			ListNode node = stack.pop();
			if (slow.val != node.val) {
				return false;
			}
			slow = slow.next;
		}
		return true;
	}


}
