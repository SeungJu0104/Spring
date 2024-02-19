package com.test03;

import org.springframework.stereotype.Component;

@Component("LG")
// @Component로 생성되는 bean의 기본 이름은 첫 글자가 소문자인 클래스명이다.
// @Component("생성할 객체명(=bean id명)") 하면 원하는 이름으로 객체를 생성할 수 있다.
public class LgTV {
	
	public void powerOn() {
		System.out.println("LG TV On");
	}
	
	public void powerOff() {
		System.out.println("LG TV Off");
	}

}
