package com.hhnail.datastructure;

/**
 * @author Hhnail
 * 实现单链表
 */
public class HIntLinkedList {

	public static void main(String[] args) {
		HIntLinkedList list = new HIntLinkedList(1);
		list.add(3);
		list.add(4);
		System.out.println(list);
	}

	public Integer value;

	public HIntLinkedList next;

	public HIntLinkedList head;

	public HIntLinkedList() {
	}

	public HIntLinkedList(Integer value) {
		this.value = value;
		this.next = null;
		// key line !!!
		if (this.head == null) {
			head = this;
		}
	}

	public void add(Integer value) {
		if (head == null) {
			head = new HIntLinkedList(value);
			return;
		}
		HIntLinkedList current = head;
		while (current.next != null) {
			current = current.next;
		}
		HIntLinkedList newNode = new HIntLinkedList(value);
		current.next = newNode;
	}

	@Override
	public String toString() {

		if (this.head == null) {
			return null;
		}

		HIntLinkedList current = this.head.next;
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		sb.append(head.value);
		while (current != null) {
			sb.append(", ").append(current.value);
			current = current.next;
		}
		sb.append("];");
		return sb.toString();
	}
}
