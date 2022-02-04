package com.hhnail.design.pattern.strategy;

public class CatAgeComparator implements HComparator<Cat> {

	@Override
	public int compare(Cat o1, Cat o2) {
		return o1.getAge() - o2.getAge();
	}
}
