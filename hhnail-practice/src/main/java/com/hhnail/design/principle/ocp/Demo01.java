package com.hhnail.design.principle.ocp;

/**
 * 设计原则 —— 开闭原则（Open Closed Principle，OCP）
 */
public class Demo01 {
	public static void main(String[] args) {
		// 输入法
		MicrosoftTypeWriting typeWriting = new MicrosoftTypeWriting();
		// 皮肤
		// DefaultSkin defaultSkin = new DefaultSkin();
		// typeWriting.setSkin(defaultSkin);
		// 使用皮肤2
		// MaleSkin maleSkin = new MaleSkin();
		// typeWriting.setSkin(maleSkin);
		// 开发一个新皮肤
		FemaleSkin femaleSkin = new FemaleSkin();
		typeWriting.setSkin(femaleSkin);

		// 展示皮肤
		typeWriting.display();
	}
}
