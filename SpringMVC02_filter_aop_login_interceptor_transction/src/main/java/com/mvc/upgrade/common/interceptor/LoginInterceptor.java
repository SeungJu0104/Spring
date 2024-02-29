package com.mvc.upgrade.common.interceptor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor{
	// Client와 DispatcherServlet 사이의 필터는 Filter를 상속받아 작성하고, (필터)
	// DispatcherServlet과 Controller 사이의 필터는 HandlerInterceptor를 상속받아 작성한다. (인터셉터)
	private Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
	
	// 컨트롤러 실행 요청 전에 수행되는 메소드
	// 리턴 값으로 boolean 타입을 주고, false면 컨트롤러로 요청 넘기지 않고 종료시킨다.
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
		
		logger.info("[Interceptor] : preHandle");
		
		// 로그인 된 상태에서만 요청을 컨트롤러로 넘기겠다.
		// 로그인 정보는 Session 영역에 담겨있을 것이다.
		if(request.getSession().getAttribute("login") != null 
				|| request.getRequestURI().contains("/loginform.do") 
				|| request.getRequestURI().contains("/ajaxlogin.do") 
				|| request.getRequestURI().contains("/test.do")) { 
		// 로그인 한 상태이거나, 로그인 페이지로 넘어가는 요청이거나, 로그인 하기위해 아이디와 비밀번호가 담긴 요청인 경우에는
		// test.do 라는 요청이 넘어가는 경우도 포함(이거는 트랜잭션 예외발생 롤백 실습 위해서)
			return true;
			// 들어온 요청을 컨트롤러로 넘기고 종료한다.
		}
		
		if(request.getSession().getAttribute("login") == null) { // 로그인 하지 않은 상태라면
			
			response.sendRedirect("loginform.do");
			// 여기서는 그냥 예외처리 throws로 넘겼다.
			// 그런데 로그인 하지 않은 경우에 로그인 페이지로 넘어가도록 sendRedirect로 "loginform.do" 넘겨 컨트롤러에 접속하려하는데 인터셉터때문에 컨트롤러에 들어갈 수 없는 무한 반복이 발생한다.
			// 그래서 위의 if문에 request.getRequestURI().contains("/loginform.do") 를 넣어 컨트롤러로 넘어갈 수 있도록 만들어줬다.
			// 컨트롤러에서 다시 컨트롤러로 넘어오도록 return 문에 redirect: 붙인 것과 같은 개념이다.
			
			// index 페이지에서 List...을 누르면 preHandler 동작하고 왜 client와 dispatcherservlet 사이에서 동작하는 LogFilter가 동작하는가?
			// redirect는 엄밀히 따지면 다시 요청을 보내는 것이기 때문에 클라이언트와 dispatcherservlet부터 다시 시작한다. 그래서 필터가 동작한다.
			// 수업시간에는 이해를 위해 dispatcherservlet으로 request가 돌아간다고 설명한 것이다.
			
			return false;
			// 들어온 요청을 컨트롤러로 넘기지 않고, 종료한다.
		}
		
		return false;
		
	}
	
	// View 단으로 forward되기 전에 수행된다.
	// 컨트롤러에서 에러 발생 시 해당 메소드는 동작하지 않는다.
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
		
		logger.info("[Interceptor] : postHandle");
		
	}
	
	// View까지 처리가 완료된 후에 동작한다.
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e) {
		
		logger.info("[Interceptor] : afterCompletion");
		
	}
	
	
	
	
}
