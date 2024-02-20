package com.test05;

public class Man implements Person {

	// 비공통부분(target 메소드 작성)
	@Override
	public void classWork() {
		System.out.println("컴퓨터를 켜서 MLP에 접속한다.");
	}

}
