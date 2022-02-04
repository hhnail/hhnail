package com.hhnail.design.pattern.strategy;

import java.util.Arrays;

public class TestComparator {

	public static void main(String[] args) {

		Cat[] cats = {
				new Cat(12d, 4),
				new Cat(11d, 2),
				new Cat(15d, 5),
				new Cat(13.5,4)
		};
		System.out.println(Arrays.toString(cats));
		System.out.println("===============================");
		HSorter<Cat> catSorter = new HSorter<>();
		// 按照age排序
		// catSorter.sort(cats, new CatAgeComparator());
		// System.out.println(Arrays.toString(cats));

		// 按照speed排序，并使用lambda表达式（因为接口只有一个抽象方法，可以省略为lambda表达式）
		catSorter.sort(cats, (o1, o2) -> {
			if (o1.getSpeed() - o2.getSpeed() < 0) {
				return -1;
			} else if (o1.getSpeed() > o2.getSpeed()) {
				return 1;
			}
			return 0;
		});
		System.out.println(Arrays.toString(cats));


	}

}
