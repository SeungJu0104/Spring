package com.test01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	
	public static void main(String [] args) {
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test01/applicationContext.xml");
		
		// AbstractTest today = (AbstractTest)factory.getBean("factory");
		// factory-method 미설정 가정한다.
		// 추상클래스는 객체를 가질 수 없기 때문에 에러가 발생한다.
		
		AbstractTest today = (AbstractTest)factory.getBean("factory");
		// factory-method로 설정한 getInstance 메소드에 의해 하위 클래스인 오늘 날짜의 요일에 맞는 요일 객체가 생성된다.
		// 다형성
		// 오늘이 화요일이라면 DI를 통해 화요일 객체가 만들어지는데, 
		// 이를 다형성을 통해 언박싱하면서 상속관계의 하위 객체인 화요일 객체인 것을 알고 화요일 객체로 뒤의 dayInfo 메소드를 실행한다.
		// 결론적으로 xml 문서에서는 AbstractTest factory = new Tuesday(); 로 객체가 만들어지고,
		// MTest에서 AbstractTest today = (= AbstractTest factory = )new Tuesday(); 가 실행된 것이다.
		System.out.println("오늘은 " + today.dayInfo() + "입니다.");
		
	}

}
