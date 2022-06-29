package com.hhnail.design.pattern.structural.decorator;

/**
 * 加了鸡蛋的食物
 */
public class AddEgg extends GarnishedFastFood {

	public AddEgg(FastFood fastFood) {
		// 此时price是egg的价格
		super(fastFood, 1, "鸡蛋");
	}


	@Override
	public String getDesc() {
		// 此时是egg的描述 + 主食的描述
		return super.getDesc() + getFastFood().getDesc();
	}
}
