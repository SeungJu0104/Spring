package com.test01.anno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component 
// @Component : 자동으로 bean 등록해주는 Annotation (import 필요 org.springframework.stereotype.Component)
// component-scan 설정해놓은 xml 문서를 읽어들이면 @Component를 탐색한다.
// @Component로 자동 설정되는 bean은 첫글자를 소문자로 바꾼 클래스명이 id이다.
public class MyNickNamePrn {
	
	@Autowired //(required=false 또는 true)
	// 동일한 타입의 bean을 찾아 넣어준다. (import 필요 org.springframework.beans.factory.annotation.Autowired)
	// 여기서는 NickName 타입의 bean을 찾아 넣어준다.
	// 기본적으로 required=true 설정되어있고, 없는건 안넣으려면 required=false로 설정 바꾼다.
	private NickName nickName;

	public void setNickName(NickName nm) {
		this.nickName = nm;
		// nickName의 toString 리턴 값이 this.nickName이 저장된다.
		System.out.println(this.nickName);
	}
	
	@Override
	public String toString() {
		return "NickName : " + nickName;
	}

}
