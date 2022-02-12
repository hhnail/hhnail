package com.hhnail.design.pattern.structural.adapter.class_type;

/**
 * 适配器类
 * 把 TFCardImpl 转成 SDCard
 */
public class SDAdapterTF extends TFCardImpl implements SDCard {

	@Override
	public String readSD() {
		System.out.println("adapter is reading TF Card...");
		return readTF();
	}

	@Override
	public void writeSD(String data) {
		System.out.println("adapter is writing TF Card...");
		writeTF(data);
	}
}
