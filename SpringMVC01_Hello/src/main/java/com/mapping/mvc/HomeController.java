package com.mapping.mvc;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mapping.mvc.dto.AddressDto;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/home.do", method = RequestMethod.GET)
	// value에 / 쓴다.
	// home.do라는 요청이 들어오고, 들어온 요청의 method가 GET 방식일 때만 매핑된 메소드를 실행시키고,
	// 그 결과를 DispatcherSerlvet으로 넘겨준다.
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
		// 메소드 실행 결과 DispatcherServlet에 home이라는 view명을 넘겨주고, 
		// DispatcherServlet은 ViewResolver로 view명을 넘겨 view를 갖고온다.
	}
	
	@RequestMapping(value="/command.do", method=RequestMethod.GET)
	// value에 / 쓴다.
	// command.do라는 GET 방식의 요청이 들어오면 getCommand 메소드를 실행한다.
	public String getCommand(Model model, String name, String addr, String phone) {
		// DispatcherServlet은 Model 객체를 컨트롤러 단에 넘겨준다.
		// 반드시 Model 객체를 받을 필요는 없다.
		// 원래는 파라미터 갖고오기위해서 Request, Response 객체를 매개변수로 받아서 getParameter를 했어야했겠지만,
		// Spring에서는 파라미터 이름을 매개변수로 적으면 그 파라미터의 value를 넘겨준다.
		// 작성한 파리미터 이름과 매개변수의 이름이 다르면 기본적으로는 value를 못 갖고 온다.
		// 하지만, 매개변수 앞에 @RequestParam("갖고올 파리미터명")을 붙이면 이름이 달라도 갖고올 수 있다.
		System.out.println(name);
		System.out.println(addr);
		System.out.println(phone);
		// command.do?name=spring&addr=서울&phone=010-1234-5678
		
		model.addAttribute("dto", new AddressDto(name, addr, phone));
		// 매개변수로 받은 model 객체에 AddressDto 생성자를 이용해 저장한 데이터를 dto라는 속성에 담아 저장한다.
		// @RequestParam으로 다른 매개변수명해서 갖고온거 AddressDto 생성자에 저장시킨 다음에 getCommand.jsp에서 EL로 갖고오는데 왜 못 갖고와??
		return "getCommand"; // getCommand라는 String 값을 리턴준다.(View 명)
	}
	
	@RequestMapping(value="/command.do", method=RequestMethod.POST)
	public String postCommand(Model model, @ModelAttribute AddressDto dto ) {
		// form 태그 통해 url에 넘긴 파리미터와 그 value를 매개변수에 setter getter가 설정된 클래스의 객체를 하나 만들어 
		// 거기에 넘어오는 파리미터 value들을 저장할 수 있다.
		// (매개변수 생성자 사용하는게 아닌 기본 생성자로 객체를 만든 다음에, 
		// setter로 setter 메소드의 set 뒷 부분 이름과 파리미터 이름을 비교해 저장한다.)
		// 정석은 @ModelAttribute를 앞에 붙이는 것이나 안붙여도 동작한다.
		// homecontroller.java의 postCommand 메소드를 실행할 때,
		// index.html에서 form태그에 파리미터와 value들이 넘어오면서 postCommand의 매개변수인 AddressDto dto에 담긴다.
		// 이때, 매개변수 생성자로 담는게 아니라 기본 생성자로 객체를 생성해서 set 뒷부분의 이름이 파라미터 이름과 일치하는 setter로 value들을 저장한다.
		System.out.println(dto.getName());
		System.out.println(dto.getAddr());
		System.out.println(dto.getPhone());
		
		model.addAttribute("dto",dto);
		// 매개변수 dto를 model 객체의 dto 속성에 담는다.
		return "postCommand"; // view명을 DispatcherServlet에 리턴 준다.
		// ViewResolver에서 이 view명을 넘겨받아 그 view를 찾아 DispatcherServlet을 통해 클라이언트한테 넘겨준다.
		// servlet-context.xml에서 view명에 경로를 붙여준다.
	}
	
}
