package com.hhnail.design.pattern.structural.proxy.jdk;

public class Test {
	public static void main(String[] args) {
		ProxyFactory proxyFactory = new ProxyFactory();
		SellTicket proxyObj = proxyFactory.getProxyObj();
		proxyObj.sellTicket();
	}
}
