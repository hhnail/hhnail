package com.hhnail.design.pattern.structural.adapter.object_type;

/**
 * 适配器类
 * 把 TFCardImpl 转成 SDCard
 */
public class SDAdapterTF implements SDCard {

	// 聚合TFCard
	private TFCard tfCard;

	public SDAdapterTF(TFCard tfCard) {
		this.tfCard = tfCard;
	}

	@Override
	public String readSD() {
		System.out.println("adapter is reading TF Card...");
		return this.tfCard.readTF();
	}

	@Override
	public void writeSD(String data) {
		System.out.println("adapter is writing TF Card...");
		this.tfCard.writeTF(data);
	}
}
