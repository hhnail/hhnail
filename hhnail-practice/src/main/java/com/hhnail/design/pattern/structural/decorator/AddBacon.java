package com.hhnail.design.pattern.structural.decorator;

/**
 * 加了培根的食物
 */
public class AddBacon extends GarnishedFastFood {

	public AddBacon(FastFood fastFood) {
		super(fastFood, 2, "培根");
	}

	// @Override
	// public float cost() {
	// 	// 主食 + 配料
	// 	return getFastFood().cost() + getPrice();
	// }

	@Override
	public String getDesc() {
		// 从父类继承过来的描述（子类自己也有描述） + 主食的描述
		return super.getDesc() + getFastFood().getDesc();
	}
}
