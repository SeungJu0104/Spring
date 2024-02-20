package com.test05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test05/applicationContext.xml");
		
		System.out.println("여학생 기상");
		factory.getBean("woman", Person.class).classWork();
		System.out.println("------------------------------------");
		System.out.println("남학생 기상");
		factory.getBean("man", Person.class).classWork();

	}

}
