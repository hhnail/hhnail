package com.hhnail.design.pattern.singleton;

/**
 * 最简单高效的写法，能够保证线程安全
 * 细究的话有很小的一个瑕疵，就是类一旦装载这个实例就new出来了
 * （但是没有使用它，我们又何必要装载呢？所以问题真的很小）
 */
public class Mgr01 {

	private static final Mgr01 INSTANCE = new Mgr01();

	private Mgr01() {

	}

	public Mgr01 getInstance() {
		return INSTANCE;
	}

	public void m(){

	}


}
