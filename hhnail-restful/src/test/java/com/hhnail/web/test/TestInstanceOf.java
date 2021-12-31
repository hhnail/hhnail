package com.hhnail.web.test;

import org.junit.Test;

public class TestInstanceOf {
	public static void main(String[] args) {
		// Integer i = 0;
		// System.out.println(i instanceof Integer);
		// System.out.println(i instanceof TestInstanceOf);
		A a = new A();
		B b = new B();
		A a1 = new A();
		System.out.println(a.getClass().equals(b.getClass()));
		System.out.println(a.getClass().equals(a1.getClass()));


	}

	@Test
	public void test01(){
		A a = new A();
		B b = new B();
		A a1 = new A();
		System.out.println(a.getClass().equals(A.class));
	}
}

class A{

}

class B{

}
