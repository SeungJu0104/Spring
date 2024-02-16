package com.test02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {

		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test02/applicationContext.xml");
		// 원래는 따로 작성할 필요없으나, bean을 끌어내서 화면에 보여주기위해 ApplicationContext를 작성
		
		System.out.println(factory.getBean("lee").toString());
		// Emp lee = new Emp("이창진", 2000000);
		// lee.toString();
		
		System.out.println(factory.getBean("kim"));
		// Emp kim = new Emp();
		// kim.setName("김창진");
		// kim.setSalary(3000000);
		// kim.toString();
		// 따로 toString 안써도, 오버라이딩된 toString이 동작한다.
		
		// setter 메소드, 매개변수 생성자 DI 같이 사용할 수 있다.
		System.out.println(factory.getBean("park").toString());
		// Developer park = new Developer("박창진", 4000000);
		// park.setDept("개발");
		// park.toString();
		
		// setter 메소드, 매개변수 생성자 DI 같이 사용할 수 있다.
		System.out.println(factory.getBean("cho"));
		// Enginner cho = new Enginner("조창진", 3500000);
		// cho.setDept("기술");
		// cho.toString();
	}

}
