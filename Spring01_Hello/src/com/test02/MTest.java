package com.test02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		// DI를 이용한 객체(bean) 생성
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test02/beans.xml");
		// 다형성
		// ApplicationContext 인터페이스 이용해 xml을 읽어온다.
		// 실제 DI를 이용해 객체 생성할 때는 이럴 필요 없으나 지금은 읽어와야하므로 작성했다.
		
		// 나중에 실제 DI 이용해 객체 생성할 때는 이럴 필요 없다.
		// 지금은 자동이더라도 일부러 갖고와야 실행할 수 있다.
		MessageBean bean = (MessageBean)factory.getBean("korean"); // id가 korean인 bean을 갖고온다.
		bean.sayHello("스프링");
		
		bean = (MessageBean)factory.getBean("english"); // id가 english인 bean을 갖고온다.
		bean.sayHello("Spring");
		
	}

}
