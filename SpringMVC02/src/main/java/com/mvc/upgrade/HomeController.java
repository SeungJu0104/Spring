package com.mvc.upgrade;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mvc.upgrade.model.biz.BoardBiz;
import com.mvc.upgrade.model.dto.BoardDto;

@Controller
// 컨트롤러 담당하는 단이라고 선언
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private BoardBiz biz;
	// @Service로 비즈 담당하는 단이라고 선언한다.
	// Biz 선언하면 자동으로 bean(객체)가 생성되고, 이 객체를 가져다쓰도록 연결.
	
	// 이전에 Servelt 실습할 때는 if문 썼지만, 이제는 if문 개념으로 각 메소드를 만든다.
	@RequestMapping(value = "/home.do", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping("/list.do") // value= , method= 형태 하지않고, value 내용만 적어서 사용할 수 있다.
	public String list(Model model) {
		
		logger.info("SELECT LIST");
		// 콘솔에 '정보: 내용' 형태로 보여준다.
		// 에러 위치 확인용
		
		model.addAttribute("list", biz.selectList());
		// biz의 selectList 메소드의 리턴 값을 "list"라는 속성으로 model 객체에 저장한다.
		
		return "mvclist"; 
		// 페이지명(view명)을 DispatcherServlet에 리턴 준다.
		// servlet-context.xml에 의해 views 폴더 내에 mvclist.jsp를 찾아 DispatcherServlet으로 돌려준다.
	}
	
	@RequestMapping("/detail.do") // value= , method= 형태 하지않고, value 내용만 적어서 사용할 수 있다.
	public String detail(Model model, int myno) {
		
		logger.info("SELECT ONE");
		// 콘솔에 '정보: 내용' 형태로 보여준다.
		// 에러 위치 확인용
		
		model.addAttribute("dto", biz.selectOne(myno));
		
		return "mvcdetail";
		// 페이지명(view명)을 DispatcherServlet에 리턴 준다.
		// servlet-context.xml에 의해 views 폴더 내에 mvclist.jsp를 찾아 DispatcherServlet으로 돌려준다.
	}
	
	@RequestMapping("/insertform.do") // value= , method= 형태 하지않고, value 내용만 적어서 사용할 수 있다.
	public String insertForm() {
		// 받아올 데이터 없기 때문에 굳이 Model 객체 매개변수나 다른 매개변수를 적을 필요가 없다.
		logger.info("INSERT FORM");
		// 콘솔에 '정보: 내용' 형태로 보여준다.
		// 에러 위치 확인용
		
		return "mvcinsert";
	}
	
	@RequestMapping("/insertres.do")
	public String insertRes(@ModelAttribute BoardDto dto) {
		// 파리미터를 BoardDto로 받아온다. 자세한 내용은 SpringMVC01 프로젝트에 작성한 주석 찾아보기.
		
		logger.info("INSERT RES");
		// 콘솔에 '정보: 내용' 형태로 보여준다.
		// 에러 위치 확인용
		int res = biz.insert(dto);
		
		if(res > 0) {
			return "redirect:list.do";
			// return "mvclist" 하면 컨트롤러 다시 거치치않고, 바로 jsp페이지 이동하므로 아무런 값도 나오지 않는다.
			// return "list.do" 하면 DispatcherServlet은 ViewResolver로 보내므로, 여기서는 servlet-context.xml 거쳐서 /WEB-INF/views에서 list.do.jsp 라는 없는 페이지를 찾게된다.
			// 그래서 redirect: 를 붙여 DispatcherServlet으로 보내면 DispatcherServlet은 ViewResolver로 보내는 것이 아니라 HandlerMapping으로 다시 보내서 컨트롤러로 가도록 만든다.
		}else {
			return "redirect:insertform.do";
			// return "mvcinsert" 하면 컨트롤러 다시 거치치않고, 바로 jsp페이지 이동하므로 아무런 값도 나오지 않는다.
			// return "insertform.do" 하면 DispatcherServlet은 ViewResolver로 보내므로, 여기서는 servlet-context.xml 거쳐서 /WEB-INF/views에서 insertform.do.jsp 라는 없는 페이지를 찾게된다.
			// 그래서 redirect: 를 붙여 DispatcherServlet으로 보내면 DispatcherServlet은 ViewResolver로 보내는 것이 아니라 HandlerMapping으로 다시 보내서 컨트롤러로 가도록 만든다.
		}
	}
	
}
