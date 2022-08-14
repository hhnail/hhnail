package com.hhnail.algorithm.leetcode.datastructure01.day07;

import com.hhnail.algorithm.leetcode.plan01.day05.ListNode;

import java.util.HashSet;
import java.util.Set;

public class HasCycle {

	public static void main(String[] args) {
		ListNode node = new ListNode();
		System.out.println(hasCycle(node));
	}

	public static boolean hasCycle(ListNode head) {
		ListNode point = head;
		Set<ListNode> set = new HashSet<>();
		while (point != null) {
			if (!set.add(point)) {
				return true;
			}
			point = point.next;
		}
		return false;
	}
}
