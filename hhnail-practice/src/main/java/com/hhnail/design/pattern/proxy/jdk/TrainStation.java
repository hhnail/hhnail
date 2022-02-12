package com.hhnail.design.pattern.proxy.jdk;

/**
 * 火车站类
 */
public class TrainStation implements SellTicket {

	@Override
	public void sellTicket() {
		System.out.println("车站买票啦");
	}
}
