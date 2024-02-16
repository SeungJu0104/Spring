package com.test02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test02/applicationContext.xml");
		
		Address kim = (Address)factory.getBean("kim");
		// 매개변수 생성자
		// Address kim = new Address("김창진", "서울시 광진구", "010-4578-1234");
		System.out.println(kim.toString());
		
		Address park = (Address)factory.getBean("park");
		System.out.println(park); // toString 출력

	}

}
