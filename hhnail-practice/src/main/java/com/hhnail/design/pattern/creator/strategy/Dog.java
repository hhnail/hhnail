package com.hhnail.design.pattern.creator.strategy;

import com.hhnail.util.HArrayUtil;

import java.util.Arrays;

public class Dog implements HComparable<Dog> {

	public static void main(String[] args) {
		Dog[] dogArr = {new Dog(6), new Dog(3), new Dog(8)};
		System.out.println(Arrays.toString(dogArr));

		HArrayUtil.selectionSort(dogArr);
		System.out.println(Arrays.toString(dogArr));

	}

	private int age;

	public Dog(int age) {
		this.age = age;
	}

	@Override
	public int compareTo(Dog dag) {
		return this.age - dag.age;
	}

	@Override
	public String toString() {
		return "Dag{" +
				"age=" + age +
				'}';
	}
}
