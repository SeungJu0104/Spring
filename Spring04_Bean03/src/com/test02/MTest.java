package com.test02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test02/applicationContext.xml");
		
		System.out.println(factory.getBean("myFood"));
		// Food favoriteFood = new Food("삼겹살", 2750);
		// Food unFavoriteFood = new Food();
		// unFavoriteFood.setName = "당근";
		// unFavoriteFood.setPrice = 300;
		// MyFood myFood = new MyFood(favoriteFood, unFavoriteFood);
	}

}
