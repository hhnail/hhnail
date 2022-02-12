package com.hhnail.design.pattern.proxy.cglib;

public class Test {
	public static void main(String[] args) {
		ProxyFactory factory = new ProxyFactory();
		TrainStation proxyObj = factory.getProxyObj();
		proxyObj.sellTicket();
	}
}
