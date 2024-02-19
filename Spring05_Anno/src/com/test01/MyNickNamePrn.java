package com.test01;

public class MyNickNamePrn {
	
	private NickName nickName;

	public void setNickName(NickName nickName) {
		this.nickName = nickName;
		// nickName의 toString 리턴 값이 this.nickName이 저장된다.
		System.out.println(this.nickName);
	}
	
	@Override
	public String toString() {
		return "NickName : " + nickName;
	}

}
