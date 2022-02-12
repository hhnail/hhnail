package com.hhnail.design.pattern.structural.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Vtag
 * 代理对象工厂
 */
public class ProxyFactory implements MethodInterceptor {

	private TrainStation trainStation = new TrainStation();

	public TrainStation getProxyObj(){
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(TrainStation.class);
		// 设置回调函数
		enhancer.setCallback(this);
		// 创建代理对象
		TrainStation proxyObj = (TrainStation) enhancer.create();
		return proxyObj;
	}

	/**
	 *
	 * @param o
	 * @param method
	 * @param objects 代理方法需要的入参
	 * @param methodProxy
	 * @return
	 * @throws Throwable
	 */
	@Override
	public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
		System.out.println("代理车票售卖并收取服务费（cglib代理）");
		// trainStation.sellTicket();
		// 反射调用
		Object res = method.invoke(trainStation, objects);
		return res;
	}
}
