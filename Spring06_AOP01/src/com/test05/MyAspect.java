package com.test05;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/* 특정 메소드를 pointcut으로 지정
 * @Pointcut("pointcut")
 * 해당 특정 메소드 작성
 * 
 * : 특정 메소드를 pointcut으로 작성할 수 있다.
 * 
 * @Before("특정 메소드명()")
 * advice 메소드 작성
 * 
 * 
 */

// Annotation으로 aspect 클래스 설정
@Aspect
public class MyAspect {
	
	@Pointcut("execution(public * *(..))")
	// 특정 메소드를 pointcut으로 설정
	// 이러면 아래에 있는 메소드 자체가 pointcut이 된다.
	// 중복되고, 길이가 긴 pointcut을 짧게 작성할 수 있다.
	// 이런식으로 여러개 작성도 가능하다.
	public void myClass () {}
	
	// advice 메소드들
	@Before("myClass()")
	// 실행 시점(pointcut 지정)
	// @Pointcut으로 myClass 메소드를 pointcut으로 지정했다.
	public void before(JoinPoint join) {
		System.out.println("QR코드를 찍는다.");
	}
	
	@After("myClass()")
	// 실행 시점(pointcut 지정)
	// @Pointcut으로 myClass 메소드를 pointcut으로 지정했다.
	public void after(JoinPoint join) {
		System.out.println("침대에 눕는다.");
	}

}
