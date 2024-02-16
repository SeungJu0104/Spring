package com.test04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test04/applicationContext.xml");
		
		Developer lee = factory.getBean("leecj",Developer.class);
		// getBean("가져올 bean의 id명", 클래스명.class); 하면 그 클래스 타입으로 객체를 갖고 온다.
		// getBean의 기본은 Object 타입이다.
		System.out.println(lee);
		
		System.out.println(factory.getBean("kimcj", Enginner.class));
		// getBean("가져올 bean의 id명", 클래스명.class); 하면 그 클래스 타입으로 객체를 갖고 온다.
		// getBean의 기본은 Object 타입이다.
		
	}

}
