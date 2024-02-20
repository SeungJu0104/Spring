package com.test06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test06/applicationContext.xml");
		
		System.out.println("여학생 기상");
		factory.getBean("woman", Person.class).classWork();
		System.out.println("-------------------------------------");
		System.out.println("남학생 기상");
		Person woman = factory.getBean("man", Person.class);
		woman.classWork();
		// 인터페이스로 구현된 클래스는 aop 설정 시 인터페이스의 타입으로 bean이 생성된다.
		// 그래서 하위 클래스로 불러올 수 없다.
	}

}
