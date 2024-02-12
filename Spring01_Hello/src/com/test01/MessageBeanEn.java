package com.test01;

public class MessageBeanEn implements MessageBean {

	@Override
	public void sayHello(String name) {
		System.out.println("Hi, My name is " + name + ".");
	}

}
