package com.hhnail.design.pattern.proxy.jdk;

public class Test {
	public static void main(String[] args) {
		ProxyFactory proxyFactory = new ProxyFactory();
		SellTicket proxyObj = proxyFactory.getProxyObj();
		proxyObj.sellTicket();
	}
}
