package com.edu.entity;

public abstract class Shape {
	
	// 필드
	private String title;
	private int width;
	private int height;
	
	// 생성자
	public Shape() {}

	public Shape(String title, int width, int height) {
		super();
		this.title = title;
		this.width = width;
		this.height = height;
	}
	
	// getter setter
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	// 추상 메소드
	public abstract void viewSize();
	
	// public abstract void tmp(); //pointcut 범위 테스트용
	
}
