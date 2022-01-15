package com.hhnail.datastructure;

public class HSingleList<T> {

	public T value;

	public HSingleList<T> next;

	public HSingleList() {
		this.value = null;
		this.next = null;
	}

	public HSingleList(T headValue) {
		this.value = headValue;
		this.next = null;
	}

	@Override
	public String toString() {
		return "HSingleList{" + "value=" + value + ", next=" + next + '}';
	}
}
