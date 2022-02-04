package com.hhnail.design.pattern.singleton;

/**
 * 能够保证线程安全
 *
 * 能够防止反序列化
 * 因为我们可以通过class文件反射自己new一个实例出来
 * 而枚举类是没有构造方法的，所以可以防止上述问题
 */
public enum Mgr08 {

	INSTANCE;

	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			new Thread(()->{
				System.out.println(Mgr08.INSTANCE.hashCode());
			}).start();
		}
	}
}
