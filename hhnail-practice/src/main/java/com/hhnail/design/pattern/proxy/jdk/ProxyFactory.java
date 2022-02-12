package com.hhnail.design.pattern.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {

	// 目标对象
	private TrainStation trainStation = new TrainStation();

	// 获取代理对象
	public SellTicket getProxyObj() {
		/**
		 * ClassLoader loader,目标对象类加载器
		 * Class<?>[] interfaces,代理类实现接口的字节码对象
		 * InvocationHandler h,代理对象调用处理程序
		 */
		SellTicket proxyObject = (SellTicket) Proxy.newProxyInstance(
				trainStation.getClass().getClassLoader(),
				trainStation.getClass().getInterfaces(),
				new InvocationHandler() {
					/**
					 * @param proxy 代理对象
					 * @param method 接口中定义的method
					 * @param args 调用方法的参数
					 * @return 方法的返回值
					 */
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						System.out.println("代理售票");
						Object res = method.invoke(trainStation, args);
						return res;
					}
				}
		);
		return proxyObject;
	}

}
