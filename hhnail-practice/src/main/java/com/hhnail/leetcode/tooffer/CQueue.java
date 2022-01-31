package com.hhnail.leetcode.tooffer;

import java.util.Stack;

/**
 * 用两个栈实现一个队列。队列的声明如下，
 * 请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。
 * (若队列中没有元素，deleteHead 操作返回 -1 )
 * https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 */
public class CQueue {

	public Stack<Integer> stack1 = new Stack<>();
	public Stack<Integer> stack2 = new Stack<>();

	public static void main(String[] args) {

		CQueue c = new CQueue();
		c.stack1.push(1);
		System.out.println(c.stack1);

	}

	public CQueue() {

	}

	public void appendTail(int value) {

	}

	public int deleteHead() {
		return -1;
	}
}
