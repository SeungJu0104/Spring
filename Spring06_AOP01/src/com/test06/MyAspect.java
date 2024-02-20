package com.test06;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
// Annotation 통해 Aspect 지정한 클래스도 Annotation 통한 bean 생성 가능하다.
@Aspect
public class MyAspect {
	
	@Pointcut("execution(public * *(..))")
	// test 메소드를 pointcut으로 설정
	public void test() {}
	
	// advice 메소드들
	@Before("test()")
	// test 메소드 실행 전에 동작
	// pointcut으로 test 메소드 사용
	public void before() { // 매개변수로 JoinPoint 객체 넣는 것은 필수는 아니다.
		// JoinPoint 객체에는 실행되는 타겟에 대한 정보가 들어가 있다.
		System.out.println("QR 코드를 찍는다.");
	}
	
	@After("test()")
	// test 메소드 실행 직후에 test 메소드 성공 실패 여부 무관하게 동작
	// pointcut으로 test 메소드 사용
	public void after(JoinPoint join) { // 매개변수로 JoinPoint 객체 넣는 것은 필수는 아니다.
		// JoinPoint 객체에는 실행되는 타겟에 대한 정보가 들어가 있다.
		System.out.println("침대에 눕는다.");
	}

}
