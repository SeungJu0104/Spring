package com.test03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test03/applicationContext.xml");
		
		factory.getBean("LG", LgTV.class).powerOn();
		// @Component로 생성된 bean의 이름은 기본적으로 클래스명과 동일하다. 다만, 첫글자는 소문자이다.
		// 다만, @Component("생성할 객체명") 하면 원하는 이름으로 객체(bean)을 생성할 수 있다.
		factory.getBean("LG", LgTV.class).powerOff();
		// @Component로 생성된 bean의 이름은 기본적으로 클래스명과 동일하다. 다만, 첫글자는 소문자이다.
		// 다만, @Component("생성할 객체명") 하면 원하는 이름으로 객체(bean)을 생성할 수 있다.
		
	}

}
