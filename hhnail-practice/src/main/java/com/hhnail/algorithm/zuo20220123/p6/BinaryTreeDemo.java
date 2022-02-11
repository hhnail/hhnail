package com.hhnail.algorithm.zuo20220123.p6;

import java.util.Stack;

public class BinaryTreeDemo {
	public static void main(String[] args) {
		VTreeNode node1 = new VTreeNode(1);
		VTreeNode node2 = new VTreeNode(2);
		VTreeNode node3 = new VTreeNode(3);
		VTreeNode node4 = new VTreeNode(4);
		VTreeNode node5 = new VTreeNode(5);

		node2.left = node4;
		node2.right = node5;
		node1.left = node2;
		node1.right = node3;

		// 先/前序遍历
		// preOrderUnRecur(node1);
		// 中序遍历
		inOrderUnRecur(node1);
		// 后序遍历
		// posOrderUnRecur(node1);

	}

	// 前序遍历/先序遍历/深度优先遍历(非递归)
	public static void preOrderUnRecur(VTreeNode head) {
		if (head == null) return;
		System.out.println("非递归前序遍历：");
		Stack<VTreeNode> stack = new Stack<>();
		stack.push(head);
		while (!stack.empty()) {
			// 1、弹栈并处理（打印等）
			VTreeNode cur = stack.pop();
			System.out.println(cur.value);
			// 2、先右入栈
			if (cur.right != null) {
				stack.push(cur.right);
			}
			// 3、后左入栈
			if (cur.left != null) {
				stack.push(cur.left);
			}
		}
	}

	// 非递归 中序遍历
	public static void inOrderUnRecur(VTreeNode head) {
		if (head == null) return;
		System.out.println("非递归中序遍历：");
		Stack<VTreeNode> stack = new Stack<>();
		VTreeNode current = head;
		while (!stack.empty() || current != null) {
			if (current != null) {
				// 遍历左边界
				stack.push(current);
				current = current.left;
			} else { // 此时current已经为null了！所以从栈里面拿节点
				current = stack.pop();
				System.out.println(current.value);
				current = current.right;
			}
		}
	}


	// 非递归 后序遍历
	public static void posOrderUnRecur(VTreeNode head) {
		if (head == null) return;
		System.out.println("非递归后序遍历：");
		Stack<VTreeNode> stack1 = new Stack<>();
		Stack<VTreeNode> stack2 = new Stack<>(); // 收集栈
		stack1.push(head);
		while (!stack1.isEmpty()) {
			// 1、出栈，入收集栈
			VTreeNode cur = stack1.pop();
			stack2.push(cur);
			// 2、先左
			if (cur.left != null) {
				stack1.push(cur.left);
			}
			// 3、后右
			if (cur.right != null) {
				stack1.push(cur.right);
			}
		}
		// 弹空收集栈
		while (!stack2.empty()) {
			System.out.println(stack2.pop().value);
		}
	}
}
