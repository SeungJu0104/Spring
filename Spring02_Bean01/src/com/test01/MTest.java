package com.test01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("com.test01.applicationContext.xml");
		// 다형성
		// ClassPathXmlApplicationContext("적용할 xml 파일 경로");
		
		MessageBean Banana = (MessageBean)factory.getBean("banana"); 
		// factory.getBean("banana")의 실행 결과로
		// MessageBeanImpl banana = new MessageBeanImpl(); 이 실행되어
		// banana라는 객체가 생성된다.
		// 다만, 다형성에 의해 Banana에 MessageBean Banana = new MessageBeanImpl();
		// 이라는 결과가 된다.
		Banana.sayHello();
		// 기본 생성자로 저장한 banana, 5000이 출력된다.
		
		MessageBean Apple = (MessageBean)factory.getBean("apple");
		// factory.getBean("apple");만 따지면
		// MessageBeanImpl apple = new MessageBeanImpl("apple", 10000); 이다.
		// 다만, 여기선 다형성에 의해 MessageBean Apple = new MessageBeanImpl("apple", 10000); 라는 결과가 된다.
		// 매개변수 생성자가 동작한다.
		Apple.sayHello();
		
		MessageBean Mango = (MessageBean)factory.getBean("mango");
		Mango.sayHello();
	}

}
