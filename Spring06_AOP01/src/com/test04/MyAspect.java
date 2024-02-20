package com.test04;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
// Aspect로 지정하는 Annotation
// 사용하려면 xml에 적어도 객체 생성까지는 해야한다.
public class MyAspect {
	
	// 공통부분(advice) 메소드들
	@Before("execution(public * *(..))")
	// public 모든 리턴타입 모든 메소드명(모든 매개변수) 형태
	// 해당 형태의 타겟 메소드가 실행하기 전에 before라는 advice 메소드를 실행한다.
	// 내가 원하는 형태의 메소드만 실행시키려면 execution 안의 ()에 정확히 메소드를 적어줘야한다.
	// @Before("pointcut")
	public void before(JoinPoint join) {
		System.out.println(join.getTarget().getClass());
		System.out.println(join.getSignature().getName());
		// join에는 실행되는 타겟에 대한 정보가 들어가 있다.
		System.out.println("QR 코드를 찍는다.");
	}
	
	@After("execution(public * *(..))")
	// 해당 형태의 타겟 메소드가 실행된 후에 after라는 advice 메소드를 실행한다.
	// @After("pointcut")
	public void after(JoinPoint join) {
		System.out.println("침대에 눕는다.");
	}
	
	@AfterReturning(pointcut="execution(public * *(..))", returning="returnVal")
	// 해당 형태의 타겟 메소드가 정상적으로 실행된 후에 리턴 값을 돌려받아 returning이라는 advice 메소드를 실행한다.
	// After와 차이점은 타겟 메소드의 정상 실행 여부와 상관없이 실행되고, AfterReturning은 타겟 메소드가 정상 실행될 때만 동작한다.
	// @AfterReturning(pointcut="pointcut", returning="리턴 값 받을 변수명")(returning 굳이 안받아도 상관없다.)
	public void returning(JoinPoint join, Object returnVal) { // 타겟 메소드 리턴 후에 리턴 값을 받아서
		// Object returnVal은 타겟 메소드의 리턴 값을 받는 매개변수
		System.out.println(returnVal + " 공부하는 날이었다.");
	}
	
	@AfterThrowing("execution(public * *(..))")
	// 해당 형태의 타겟 메소드 실행 중 예외가 발생하면 throwing이라는 advice 메소드를 실행한다.
	// @AfterThrowing(pointcut="pointcut", throwing="발생한 예외 받을 변수명")
	public void throwing(JoinPoint join) {
		System.out.println("주말이었다.");
	}
	
}
