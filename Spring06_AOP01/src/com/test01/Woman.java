package com.test01;

public class Woman {
	
	public void classWork() {
		
		System.out.println("QR 코드 찍는다.");
		
		try {
			System.out.println("컴퓨터를 켜서 이클립스를 실행한다.");
		} catch(Exception e){
			System.out.println("주말이다.");
		} finally {
			System.out.println("의자에 앉는다.");
		}
		// try문 외에는 모두 공통 관점(Cross-Cutting Concern)
		// try문은 핵심 관점(Core Concern)
		
	}

}
