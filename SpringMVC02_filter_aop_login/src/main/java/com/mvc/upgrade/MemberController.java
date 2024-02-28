package com.mvc.upgrade;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mvc.upgrade.model.biz.MemberBiz;
import com.mvc.upgrade.model.dto.MemberDto;

@Controller
// 컨트롤러 단으로 Annotation 통해 선언
// 선언 안하면 컨트롤러 역할 못한다.
public class MemberController {
	
	private Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberBiz biz;
	// Annotation으로 서비스단 선언한 biz 객체와 연결
	// MemberBizImpl로는 선언 못한다. Annotation하면 상속받은 인터페이스로 객체를 만들기 때문이다.
	
	@RequestMapping("/loginform.do")
	public String loginForm() {
		logger.info("LOGIN FORM");
		return "mvclogin"; // view명 리턴
	}
	
	@RequestMapping(value="/ajaxlogin.do", method=RequestMethod.POST) // 정석 방식
	@ResponseBody
	public Map<String, Boolean> ajaxLogin(HttpSession session, @RequestBody MemberDto dto){
		// ajax 방식이기 때문에 view명을 리턴하는게 아니라 데이터를 리턴 줄 것이다.
		// 일반적인 요청은 view명을 리턴주면서, 화면 전환되는게 맞지만 ajax는 적절한 데이터만 리턴 주면 된다.
		// 그래서 다른 페이지로 데이터 넘겨줄 필요 없어서 Model 객체를 매개변수로 받을 필요는 없지만, 
		// 대신 아이디와 비밀번호를 브라우저 내에서 저장할 HttpSession을 매개변수로 받는다.
		// 넘어온 id와 비밀번호를 MemberDto에 담는다. (setter 함수. set 뒤에 이름(일반적으로 필드명) 일치하니 담긴다.)
		// @RequestBody : request 객체로 넘어오는 데이터를 java 객체로 변환해준다. (여기서 안쓰면 id 못 받아온다.)
		// @RequestBody로 request 객체에 넘어오는 데이터를 자바객체로 바꾸고, jackson-databind로 json 데이터를 자바 오브젝트로 바꿔준다.
		// cf. @ResponseBody: 자바 객체를 response 객체에 바인딩해준다.
		// ajax로 넘겨줄 때, jackson-databind와 @ResponseBody를 통해 데이터 변환해 넘겨준다.
		
		logger.info("LOGIN");
		// INFO: 내용 형태로 콘솔에 출력
		// 에러 확인용
		
		MemberDto res = biz.login(dto);
		// id와 pw가 dto에 저장되고, 이걸 매개변수로 넘겨줘 login 메소드 실행한다.
		
		boolean check = false;
		
		if(res != null) {// 객체가 있다. -> 로그인 성공
			session.setAttribute("login", res);
			// session 객체에 login 속성으로 로그인 정보를 저장한다.
			check = true;
		}
		System.out.println("에러 확인용 check : " + check);
		Map <String, Boolean> map = new HashMap<String, Boolean>();
		map.put("check", check); // check가 true면 로그인 성공, false면 로그인 실패
		
		return map; // Map 타입만 리턴 가능하고, @RequestBody와 jackson-databind에 의해 자바에서 json 데이터로 변환된다.
	}
	
	
}
