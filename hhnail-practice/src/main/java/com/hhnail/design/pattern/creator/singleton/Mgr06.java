package com.hhnail.design.pattern.creator.singleton;

/**
 * 懒汉式
 */
public class Mgr06 {

	// volatile 防止指令重排。。。？
	private static volatile Mgr06 INSTANCE;

	private Mgr06() {

	}

	public static Mgr06 getInstance() {
		if (INSTANCE == null) {
			// 缩小锁的范围，提高效率
			synchronized (Mgr06.class) {
				// 双重检查
				if (INSTANCE == null) {
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					INSTANCE = new Mgr06();
				}
			}
		}
		return INSTANCE;
	}

}
