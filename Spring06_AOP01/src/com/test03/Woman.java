package com.test03;

public class Woman implements Person {

	@Override
	public void classWork() {
		
		System.out.println("컴퓨터를 켜서 이클립스를 실행한다.");
		// test01의 Woman의 핵심 기능(Core Concern)과 관련된 내용만 적고, 
		// 공통 기능(Cross-Cutting Concern)은 따로 적는다.
	}

}
