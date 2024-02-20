package com.test02;

public class Man implements Person {

	@Override
	public void classWork() {
		
		System.out.println("컴퓨터를 켜서 MLP에 접속한다.");
		// test01 Man 클래스의 핵심 기능(Core Concern)과 관련된 내용만 적고, 
		// 공통 기능(Cross-Cutting Concern)은 따로 적는다.

	}

}
