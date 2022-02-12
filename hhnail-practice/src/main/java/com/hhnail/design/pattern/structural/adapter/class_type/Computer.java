package com.hhnail.design.pattern.structural.adapter.class_type;

public class Computer {

	public String readSD(SDCard sdCard) {
		if (sdCard == null) throw new NullPointerException("SDCard can't be null");
		return sdCard.readSD();
	}
}
