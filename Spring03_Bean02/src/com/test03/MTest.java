package com.test03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	
	public static void main(String [] args) {
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test03/applicationContext.xml");
		
		Developer dev = (Developer)factory.getBean("leecj");
		System.out.println(dev);
		// Emp lee = new Emp("이창진", 200);
		// Developer leecj = new Developer(lee, "개발");
		// Developer dev = leecj;
		// dev.toString();
		
		System.out.println(factory.getBean("kimcj"));
		// Emp kim = new Emp("김창진", 300);
		// Enginner kimcj = new Enginner(kim, "기술");
		// kimcj.toString();
	}
	
}
