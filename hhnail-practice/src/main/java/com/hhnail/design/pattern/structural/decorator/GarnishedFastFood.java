package com.hhnail.design.pattern.structural.decorator;

/**
 * 装饰者类
 * 以后要加新配料，继承这个类即可
 *
 * @keys:继承 & 聚合 抽象构建角色 FastFood
 * 继承是因为他需要父类的price和desc
 * 聚合是因为他需要fastFood来记录主食
 */
public abstract class GarnishedFastFood extends FastFood {

	private FastFood fastFood;

	public GarnishedFastFood(FastFood fastFood, float price, String desc) {
		super(price, desc);
		this.fastFood = fastFood;
	}

	public FastFood getFastFood() {
		return fastFood;
	}

	public void setFastFood(FastFood fastFood) {
		this.fastFood = fastFood;
	}

	@Override
	public String toString() {
		return this.getDesc() + " " + this.cost() + "元";
	}
}
