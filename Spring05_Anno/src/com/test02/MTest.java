package com.test02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	// Annotation을 이용한 bean과 xml에 직접 작성한 bean을 같이 사용할 수 있다.
	public static void main(String [] args) {
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test02/applicationContext.xml");
		
		System.out.println(factory.getBean("mySchool", School.class));
		
	}

}
