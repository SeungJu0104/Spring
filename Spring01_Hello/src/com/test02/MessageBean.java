package com.test02;

public interface MessageBean {
	
	// 따로 abstract 선언 안해도 인터페이스 내에서는 묵시적으로 추상 메소드 선언된다.
	public void sayHello(String name);
	
}
