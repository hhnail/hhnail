package com.hhnail.design.pattern.structural.adapter.object_type;

/**
 * 设计模式之适配器模式（类式）
 */
public class Test {
	public static void main(String[] args) {
		// 创建计算机对象
		Computer computer = new Computer();
		// 常规读取SD卡
		String msg = computer.readSD(new SDCardImpl());
		System.out.println(msg);

		System.out.println("====================================");

		// 从TFCard读取内容到SDCard
		SDAdapterTF adapter = new SDAdapterTF(new TFCardImpl());
		String data1 = computer.readSD(adapter);
		System.out.println(data1);
		adapter.writeSD("啦啦啦");
	}
}
