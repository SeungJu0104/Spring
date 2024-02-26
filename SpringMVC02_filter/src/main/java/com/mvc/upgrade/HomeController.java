package com.mvc.upgrade;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mvc.upgrade.model.biz.BoardBiz;
import com.mvc.upgrade.model.dto.BoardDto;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private BoardBiz biz;
	
	@RequestMapping(value = "/home.do", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	
	@RequestMapping("/list.do")
	public String list(Model model) {
		logger.info("SELECT LIST");
		model.addAttribute("list",biz.selectList());
		return "mvclist";
	}
	
	@RequestMapping("/detail.do")
	public String detail(Model model, int myno) {
		logger.info("SELECT ONE");
		
		model.addAttribute("dto", biz.selectOne(myno));
		return "mvcdetail";
	}
	
	@RequestMapping("/insertform.do")
	public String insertForm() {
		logger.info("INSERT FORM");
		return "mvcinsert";
	}
	
	@RequestMapping("/insertres.do")
	public String insertRes(BoardDto dto) {
		logger.info("INSERT RES");
		int res = biz.insert(dto);
		
		if(res>0) {
			return "redirect:list.do"; 
		}else {
			return "redirect:insertform.do";
		}
	}
	
	@RequestMapping("/updateform.do")
	public String updateForm(Model model, int myno) {
		
		
		logger.info("UPDATE FORM");
		// 콘솔에 INFO: 내용 형태로 보여준다.
		// 에러 확인용
		
		model.addAttribute("dto", biz.selectOne(myno));
		// selectOne 메소드 결과를 dto라는 속성에 담아 model 객체에 저장한다.
		// view에 데이터를 넘겨줄 필요가 있으니 Model 객체를 매개변수로 선언한다.
		
		return "mvcupdate";
	}
	
	@RequestMapping("/updateres.do")
	public String updateRes(BoardDto dto) {
		
		logger.info("UPDATE RES");
		// 콘솔에 INFO: 내용 형태로 보여준다.
		// 에러 확인용
		
		int res = biz.update(dto);
		
		System.out.println("에러 체크용3");
		
		return (res > 0)?"redirect:detail.do?myno="+dto.getMyno():"redirect:updateform.do?myno="+dto.getMyno();
		// redirect 이용해 DispatcherServlet으로 넘어간 리턴 값이 다시 HandlerMapping 거쳐 컨트롤러로 넘어가도록 한다.
		// detail.do와 updateform.do 모두 myno 값이 매개변수로 필요하므로, url에 파라미터 value로 필요한 myno 값을 넣어준다.
	}
	
	@RequestMapping("/delete.do")
	public String delete(int myno) {
		// view 페이지에 데이터 넘겨줄 필요 없으므로 굳이 Model 객체를 매개변수로 받을 필요가 없다.
		// MyBatis 덕분에 바로 매개변수 타입 따로 변환할 필요없이 갖고 올 수 있다.
		
		logger.info("DELETE");
		// 콘솔에 INFO: 내용 형태로 보여준다.
		// 에러 확인용
		
		int res = biz.delete(myno);
		System.out.println(myno);
		System.out.println("에러 체크용1");
		System.out.println(res);
		return (res > 0)?"redirect:list.do":"redirect:detail.do?myno="+myno;
	}
	
	
	
	
	
	
	
	
	
	
	
}
