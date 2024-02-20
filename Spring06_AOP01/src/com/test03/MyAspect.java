package com.test03;

public class MyAspect {
	// Aspect(Advisor) : PointCut  + Advice
	
	
	// advice들
	public void before() {
		System.out.println("QR 코드를 찍는다.");
	}
	
	public void after() {
		System.out.println("침대에 눕는다.");
	}

}
