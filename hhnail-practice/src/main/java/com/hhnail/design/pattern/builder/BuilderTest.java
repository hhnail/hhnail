package com.hhnail.design.pattern.builder;

/**
 * 设计模式之建造者模式
 * 拓展
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
	}
}
