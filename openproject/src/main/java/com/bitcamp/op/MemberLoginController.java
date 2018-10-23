package com.bitcamp.op;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bitcamp.op.member.service.MemberLoginService;

@Controller
@RequestMapping("member/login")
public class MemberLoginController {
	
	@Autowired
	private MemberLoginService loginService;
	
	//login에 들어와서 get이나 post방식에 따라 다르게 처리가능
	//컨트롤러에 접속해서 get방식으로 처리할수 있는지?
	//@RequestMapping("member/login")
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView getLoginForm(@RequestParam(value = "no", required = false) String i) {
		
		return new ModelAndView("member/loginForm");
	}
	
	//컨트롤러에 접속해서 post방식으로 처리할수 있는지?
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView loginProcess(
			//파라미터값이 없으면 기본설정 aaa로 설정됨
			//로그인폼에 입력된 아이디와 비밀번호를 파라미터값으로 가져옴
			@RequestParam(value = "userId", required = false) String userId, 
			@RequestParam(value = "password", required=true) String password,
			HttpSession session
			) throws SQLException {
		
		ModelAndView modelAndView = new ModelAndView();
		
		
		//fail페이지를 기본페이지로 설정하므로 else 필요 x
		modelAndView.setViewName("member/loginfail");
		
		if(userId != null && password != null) {
			//로그인이 정상처리 됐을경우
			if(loginService.login(userId, password, session)) {
				
				modelAndView.setViewName("member/loginok");
											//redirect:/
			} else {
				
			}
			

		}
		
		System.out.println(userId + " : " + password);
		
		return modelAndView;
	}
	
}
