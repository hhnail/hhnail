package com.hhnail.designmode.strategy;

import com.hhnail.util.HArrayUtil;
import lombok.Data;

import java.util.Arrays;

@Data
public class Cat implements HComparable<Cat> {

	public static void main(String[] args) {

		Cat[] cats = {new Cat(10), new Cat(20), new Cat(15)};
		System.out.println(Arrays.toString(cats));

		HArrayUtil.selectionSort(cats);
		System.out.println(Arrays.toString(cats));
	}

	private double speed;

	private int age;

	public Cat(double speed) {
		this.speed = speed;
	}

	public Cat(double speed, int age) {
		this.speed = speed;
		this.age = age;
	}

	@Override
	public int compareTo(Cat cat) {
		if (this.speed - cat.speed < 0) {
			return -1;
		} else if (this.speed - cat.speed > 0) {
			return 1;
		}
		return 0;
	}

}
