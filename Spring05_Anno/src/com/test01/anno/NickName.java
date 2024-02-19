package com.test01.anno;

import org.springframework.stereotype.Component;

@Component 
// @Component : 자동으로 bean으로 등록해주는 Annotation (import 필요 org.springframework.stereotype.Component)
// component-scan 설정해놓은 xml 문서를 읽어들이면 @Component를 탐색한다.
// @Component로 자동 설정되는 bean은 첫글자를 소문자로 바꾼 클래스명이 id이다.
public class NickName {
	
	@Override
	public String toString() {
		return "nam";
	}

}
