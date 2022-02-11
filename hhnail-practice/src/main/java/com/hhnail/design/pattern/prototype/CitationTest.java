package com.hhnail.design.pattern.prototype;

public class CitationTest {
	public static void main(String[] args) throws CloneNotSupportedException {
		Citation c = new Citation();
		c.setName("张三");
		c.show();
		Citation c2 = c.clone();
		System.out.println("setter前");
		c2.show();
		c2.setName("李四");
		System.out.println("setter后");
		c2.show();
		System.out.println(c == c2);
		System.out.println(c.getClass() == c2.getClass());
		System.out.println(c.equals(c2));


		System.out.println("==================华丽的分割线===============");
		Citation c3 = new Citation();
		Citation c4 = c3.clone();
		c3.setName("王五");
		c3.show();
		c4.show();
		c4.setName("赵六");
		c4.show();
	}
}
