package com.hhnail.design.pattern.structural.adapter.object_type;

/**
 * 计算机类
 * 原来只能读取SD卡里的内容
 * 现在通过适配器读取TF卡里的内容
 */
public class Computer {

	public String readSD(SDCard sdCard) {
		if (sdCard == null) throw new NullPointerException("SDCard can't be null");
		return sdCard.readSD();
	}
}
