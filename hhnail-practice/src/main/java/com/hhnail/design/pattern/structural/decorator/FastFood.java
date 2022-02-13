package com.hhnail.design.pattern.structural.decorator;

/**
 * 快餐类
 * 以后要新加主食，继承这个类即可
 */
public abstract class FastFood {

	// 当前产品的价格
	private float price;
	private String desc;

	public FastFood(){}
	public FastFood(float price, String desc) {
		this.price = price;
		this.desc = desc;
	}

	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}

	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}

	// 当前产品的总价（主食 + 配料）。我们只有知道了具体的主食和配料，才知道总价格
	public abstract float cost();

	@Override
	public String toString() {
		return this.getDesc() + " " + this.cost() + "元";
	}

}
