package com.edu.entity;

import org.aspectj.lang.annotation.Pointcut;

public class Rectangle extends Shape{

	public Rectangle() {
		super();
	}
	
	public Rectangle(String title, int width, int height) {
		super(title, width, height);
		// 부모클래스 매개변수 생성자로 해당 매개변수들 넘긴다.
		// Shape.title = title;
		// Shape.width = width;
		// Shape.height = height;
		// 와 동일한 내용
	}
	
	// @Pointcut("execution(public * *(..))")
	@Override
	public void viewSize() {
		
		System.out.println(super.getTitle() + "의 넓이 : " + (super.getWidth()*super.getHeight()));
		// 부모클래스에 저장된 title 필드 값 + "의 넓이 : " + (부모클래스에 저장된 width 필드 값 * 부모클래스에 저장된 height 필드 값);
	}

//	@Override
//	public void tmp() {
//		pointcut 범위 테스트용
//		System.out.println("pointcut 테스트용");
//	}
	
}
