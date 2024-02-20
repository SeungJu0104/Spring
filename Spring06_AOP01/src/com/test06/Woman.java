package com.test06;

import org.springframework.stereotype.Component;

@Component
public class Woman implements Person{
	
	// 비공통부분(target 메소드 작성)
	@Override
	public String classWork() {
		System.out.println("컴퓨터를 켜서 이클립스를 실행한다.");
		return "스프링";
	}
	
	

}
