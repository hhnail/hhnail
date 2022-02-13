package com.hhnail.design.pattern.structural.decorator;

public class FriedNoodles extends FastFood {

	/**
	 * 每一个构造方法都会存在一个隐藏的super()去调用父类的无参构造器
	 */
	public FriedNoodles() {
		super(12, "炒面");
	}

	@Override
	public float cost() {
		return getPrice();
	}
}
