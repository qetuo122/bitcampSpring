package com.bitcamp.op;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bitcamp.op.member.model.MemberInfo;
import com.bitcamp.op.member.service.MemberRegService;

@Controller
//메뉴를 눌렀을때 해당 주소를 갖도록 주소를 등록해줌
@RequestMapping("/member/memberReg")
public class MemberRegController {
	
	@Autowired
	private MemberRegService regService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView getRegForm() {
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("member/memberRegForm");
					// /WEB-INF/						.jsp
		
		return modelAndView;
		
	}
	@RequestMapping(method=RequestMethod.POST)
	// 데이터를 받아서 사용하는법 : HttpServletRequest, memberInfo(객체), @RequestParam
	public ModelAndView memberReg(MemberInfo member, 
			HttpServletRequest request) {
		
		String userId = request.getParameter("userId");
		
		/*System.out.println(userId);
		System.out.println(member);
		System.out.println(member.getUserId());*/
		
		ModelAndView modelAndView = new ModelAndView();
		
		
		//regok에서 memberInfo라는 타입의 이름으로 데이터 공유 가능

		try {
			
			int resultCnt = regService.memberReg(member, request);
		
			if(resultCnt < 1) {
				
				modelAndView.setViewName("member/regfail");
				
			}
			
			modelAndView.setViewName("member/regok");
			
		} catch (SQLException e) {

			modelAndView.setViewName("member/regfail");
			e.printStackTrace();
			
		} catch (IllegalStateException e) {
			
			modelAndView.setViewName("member/regfail");
			e.printStackTrace();
			
		} catch (IOException e) {
			
			modelAndView.setViewName("member/regfail");
			e.printStackTrace();
			
		}
		
		modelAndView.addObject("MemberInfo",member);
		
		return modelAndView;
	}

}
