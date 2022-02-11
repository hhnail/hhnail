package com.hhnail.design.pattern.prototype;

import lombok.Data;

/**
 * 设计模式之原型模式
 * 奖状类
 * 可复制
 */
@Data
public class Citation implements Cloneable {

	private String name;

	public Citation() {
		System.out.println(Citation.class.getName() + "构造方法调用！");
	}

	@Override
	public Citation clone() throws CloneNotSupportedException {
		return (Citation) super.clone();
	}

	public void show() {
		System.out.println(name + "在本学期表现良好，特发此状，以示鼓励！");
	}
}
