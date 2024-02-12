package com.test01;

public class MTest {

	public static void main(String[] args) {
		
		// 개발자가 직접 Dependency 구현
		// 개발자가 직접 객체를 수동으로 생성
		MessageBean bean = new MessageBeanEn();
		bean.sayHello("Spring");
		
		bean = new MessageBeanKo();
		bean.sayHello("스프링");
		
		// DI 의존성 주입
		// : 개발자가 아닌 프로그램(Spring)이 객체(bean)를 자동으로 생성
	}

}
