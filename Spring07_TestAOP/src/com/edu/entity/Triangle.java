package com.edu.entity;

public class Triangle extends Shape{
	
	public Triangle() {
		super();
	}

	public Triangle(String title, int width, int height) {
		super(title, width, height);
	}
	
	// getter setter 메소드도 상속된다.
	
	@Override
	public void viewSize() {
		System.out.println(super.getTitle() + "의 넓이 : " + ((super.getHeight() * super.getWidth())/2));
	}
	
}
