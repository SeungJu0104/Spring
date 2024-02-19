package com.test01.anno;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test01/anno/applicationContext.xml");
		
		System.out.println(factory.getBean("myNickNamePrn", MyNickNamePrn.class));
		// @Component로 자동 설정되는 bean은 첫글자를 소문자로 바꾼 클래스명이 id이다.
	}

}
