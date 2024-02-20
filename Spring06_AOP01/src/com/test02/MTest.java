package com.test02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test02/applicationContext.xml");
		
		Person w = factory.getBean("woman", Person.class);
		Person m = factory.getBean("man", Person.class);
		// 인터페이스로 구현된 클래스는 aop 설정 시 인터페이스의 타입으로 bean이 생성된다.
		System.out.println("여학생 기상");
		w.classWork();
		System.out.println("---------------------------");
		System.out.println("남학생 기상");
		m.classWork();
	}

}
