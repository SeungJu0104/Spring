package com.test04;

public class Man implements Person {
	
	// 비공통부분(target 메소드 작성)
	@Override
	public String classWork() {
		
		// 예외 발생시킬 목적의 코드 2줄
		// advice 메소드들 중 afterthrowing 실행시킬 목적
		// after는 정상 실행여부와 상관없이 동작하고, afterreturning은 정상 실행되어야 동작한다.
		// 그래서 이 경우에는 afterreturning은 동작하지 않는다.
		String s = null;
		s.length();
		
		
		System.out.println("컴퓨터를 켜서 MLP에 접속한다.");
		return "스프링";
	}

}
