package com.edu.aop;

public class MyAspect {
	
	// advice 메소드들
	
	public void before() {
		System.out.println("도형의 넓이를 구한다.");
	}
	
	public void after() {
		System.out.println("도형의 넓이를 출력한다.");
	}

}
