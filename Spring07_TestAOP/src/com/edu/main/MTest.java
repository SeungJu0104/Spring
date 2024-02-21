package com.edu.main;

import com.edu.entity.Rectangle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.edu.entity.Shape;

public class MTest {

	public static void main(String[] args) {
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/edu/main/applicationContext.xml");
		
		Rectangle rect = factory.getBean("rect", Rectangle.class);
		// 인터페이스와 다르게 추상 클래스는 aop 설정해도 하위 클래스 객체 쓸 수 있다.
		// 인터페이스 상속받아 aop 설정하면 하위 클래스 객체 사용 못한다. 인터페이스 객체로 bean이 생성된다.
		Shape tri = factory.getBean("tri", Shape.class);
		
		rect.viewSize();
		System.out.println("--------------------------");
		tri.viewSize();
		
		// rect.tmp(); // pointcut 범위 테스트용
		
	}

}
