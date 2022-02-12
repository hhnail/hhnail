package com.hhnail.design.pattern.creator.builder;

/**
 * 建造者模式拓展
 * 链式编程
 */
public class BuilderTest {
	public static void main(String[] args) {
		Phone phone = new Phone.Builder()
				.setCpu("cpu1")
				.setMainBoard("mainboard1")
				.setMemory("memory1")
				.setScreen("screen1")
				.build();
		System.out.println(phone);

		Phone phone2 = new Phone.Builder()
				.setMainBoard("mainboard1")
				.setMemory("memory1")
				.setScreen("screen1")
				.build();
		System.out.println(phone2);

	}
}
