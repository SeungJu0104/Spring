package com.test01;

public class MessageBeanImpl implements MessageBean {
	// 필드 선언
	private String fruit;
	private int cost;
	
	// 생성자(기본, 매개변수)
	public MessageBeanImpl() {
		super();
		this.fruit="banana";
		this.cost = 5000;
	}
	
	public MessageBeanImpl(String fruit, int cost) {
		super();
		this.fruit = fruit;
		this.cost = cost;
	}
	
	// 추상 메소드 정의
	@Override
	public void sayHello() {
		System.out.println("과일 : " + fruit + "\t 가격 : " + cost);
	}
	
}
