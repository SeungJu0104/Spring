package com.test04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	// Annotation을 이용한 AOP
	
	public static void main(String[] args) {
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test04/applicationContext.xml");
		
		System.out.println("여학생 기상");
		factory.getBean("woman", Person.class).classWork();
		System.out.println("------------------------------");
		System.out.println("남학생 기상");
		factory.getBean("man", Person.class).classWork();
		// 인터페이스로 구현된 클래스는 aop 설정 시 인터페이스의 타입으로 bean이 생성된다.
	}

}
