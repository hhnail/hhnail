package com.hhnail.design.pattern.structural.decorator;

public class Test {
	public static void main(String[] args) {
		FastFood fastFood = new FriedRice();
		System.out.println(fastFood);

		fastFood = new AddEgg(fastFood);
		System.out.println(fastFood);

		fastFood = new AddEgg(fastFood);
		System.out.println(fastFood);

		fastFood = new AddBacon(fastFood);
		System.out.println(fastFood);
	}
}
