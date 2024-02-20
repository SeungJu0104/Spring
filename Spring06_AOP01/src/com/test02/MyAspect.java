package com.test02;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyAspect implements MethodInterceptor{
	
	// Aspect : PointCut + Advice
	// 아주 기초형태의 공통부 작성
	
	// request를 가로챈다.
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		
		// target Object ?
		Object target = null;
		
		System.out.println("QR코드를 찍는다.");
		
		// 부가기능(Cross-Cutting Concern)(공통부분) 작성
		try {
			// 핵심기능(Core Concern)(비공통부분)
			// try문 제외한 나머지는 부가기능(공통부분)
			target = invocation.proceed();
			// 가로챈 request를 계속 수행
		} catch(Throwable e) {
			System.out.println("주말이다.");
		} finally {
			System.out.println("침대에 눕는다.");
		}
		
		return target;
	}
	
}
