package com.hhnail.algorithm.zuo.zuo20220123.p2;

import java.util.LinkedList;
import java.util.List;

public class TestLinkedList01 {
	public static void main(String[] args) {
		List<Integer> list = new LinkedList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);

		list.remove(0);
		list.remove(0);
		System.out.println(list);
	}
}
