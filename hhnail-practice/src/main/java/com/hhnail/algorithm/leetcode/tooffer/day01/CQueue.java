package com.hhnail.algorithm.leetcode.tooffer.day01;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 * 用两个栈实现一个队列。队列的声明如下，
 * 请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。
 * (若队列中没有元素，deleteHead 操作返回 -1 )
 */
public class CQueue {
	// 用于添加
	public Stack<Integer> stack1;
	// 用于删除
	public Stack<Integer> stack2;

	public static void main(String[] args) {
		CQueue cQueue = new CQueue();

		System.out.println(cQueue.deleteHead());

		cQueue.appendTail(1);
		cQueue.appendTail(3);
		cQueue.appendTail(4);

		System.out.println(cQueue.deleteHead());
		System.out.println(cQueue.deleteHead());
		System.out.println(cQueue.deleteHead());
	}

	public CQueue() {
		this.stack1 = new Stack<>();
		this.stack2 = new Stack<>();
	}

	public void appendTail(int value) {
		stack1.push(value);
	}

	public int deleteHead() {
		if (stack2.isEmpty()) {
			if (stack1.isEmpty()) {
				return -1;
			}
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
		return stack2.pop();
	}
}
