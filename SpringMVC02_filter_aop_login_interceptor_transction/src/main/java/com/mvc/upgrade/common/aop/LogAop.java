package com.mvc.upgrade.common.aop;

import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogAop {
	
	// advice 메소드들
	
	public void before(JoinPoint join) {
		// 로그를 찍어줄 것이기 때문에 Logger 객체를 생성한다.
		// getLogger()의 ()안에 작성한 클래스가 콘솔 창에 기본적으로 나온다.
		Logger logger = LoggerFactory.getLogger(join.getTarget() + "");
		// JoinPoint는 target에 대한 정보를 갖고 있다.
		
		logger.info("----Aop Start----");
		
		Object [] args = join.getArgs(); // 타겟 실행시 파라미터의 값을 갖고온다.
		
		if(args != null) {
			logger.info("method : " + join.getSignature().getName()); // 타겟 메소드명
			
			for(int i = 0; i < args.length; i++) {
				logger.info(i + "번째 : " + args[i]);
			}
		}
	}
	
	
	public void after(JoinPoint join) {
		Logger logger = LoggerFactory.getLogger(join.getTarget() + "");
		
		logger.info("----Aop End----");
	}
	
	
	public void afterThrowing(JoinPoint join) {
		Logger logger = LoggerFactory.getLogger(join.getTarget() + "");
		
		logger.info("----Error Log----");
		logger.info("ERROR : " + join.getArgs());
		logger.info("ERROR : " + join.toString());
	}

}
