package com.mvc.upgrade.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* Filter : 클라이언트와 DispatcherServlet 사이에서 처리.
 * Log : 기록 작성을 의미
 * doFilter 메소드 처리와 web.xml에서 Filter 등록을 해줘야 필터로서 동작할 수 있다.
 */

// 클래스로 필터 작성
public class LogFilter implements Filter{ // javax.servlet.Filter
	// Filter를 상속 받는다.
	
	// logger 객체 생성
	// org.slf4j.Logger
	private Logger logger = LoggerFactory.getLogger(LogFilter.class);
	// LoggerFactory에서 Logger 객체를 생성해서 LogFilter 클래스로 갖고온다.

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// init() : 필터 인스턴스 초기화
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// doFilter() : 전 / 후 처리, 필터를 통해 처리하고자하는 내용
		// request, response를 매개변수로 받는다.
		
		// 여기서 사용하기위해 HttpServletRequest 타입으로 변환. 필수 아니다.
		HttpServletRequest req = (HttpServletRequest) request;
		
		// 필요한 정보를 저장한다.
		String remoteAddr = req.getRemoteAddr() + "\n"; // localhost의 ip 주소
		String uri = req.getRequestURI() + "\n";
		String url = req.getRequestURL() + "\n";
		String queryString = req.getQueryString() + "\n";
		
		String referer = req.getHeader("referer") + "\n";
		
		String str = remoteAddr + uri + url + queryString + referer;
		
		// 로그 찍는다.
		logger.info("LOG FILTER \n" + str + "\n");
		
		// 해당 필터의 처리결과를 다음으로 넘겨준다.
		// 만약 다음 필터가 있다면 다음 필터로 없다면 DispatcherServlet으로 넘겨준다.
		// doFilter 안하면 request, response를 넘기지도 주지도 못한다.
		chain.doFilter(req, response);
		
		// web.xml에서 필터 등록 해줘야한다.
	}

	@Override
	public void destroy() {
		// destroy() : 필터 인스턴스 종료
		
	}
	
	
	
	
	
	
	
}
