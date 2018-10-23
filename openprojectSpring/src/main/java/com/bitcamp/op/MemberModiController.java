package com.bitcamp.op;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bitcamp.op.member.model.MemberInfo;
import com.bitcamp.op.member.service.MemberModiService;


@Controller
@RequestMapping("/member/modify")
public class MemberModiController {
	
	@Autowired
	private MemberModiService modiService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String modiForm(Model model, @RequestParam("id") String id) throws SQLException {
		
		MemberInfo member = modiService.getMember(id);
		
		model.addAttribute("modiId", id);
		model.addAttribute("modiPwd", member.getPassword());
		model.addAttribute("modiName", member.getUserName());
		model.addAttribute("modiPhoto", member.getUserPhoto());
		
		return "member/modiForm";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	// 데이터를 받아서 사용하는법 : HttpServletRequest, memberInfo(객체), @RequestParam
	public ModelAndView membermodi(MemberInfo member, 
			HttpServletRequest request) {
		
		ModelAndView modelAndView = new ModelAndView();
		
		//regok에서 memberInfo라는 타입의 이름으로 데이터 공유 가능

		try {
			
			int resultCnt = modiService.modiMember(member, request);
		
			if(resultCnt < 1) {
				
				modelAndView.setViewName("member/modifail");
				
			}
			
			modelAndView.setViewName("member/modiok");
			
		} catch (SQLException e) {

			modelAndView.setViewName("member/modifail");
			e.printStackTrace();
			
		} catch (IllegalStateException e) {
			
			modelAndView.setViewName("member/modifail");
			e.printStackTrace();
			
		} catch (IOException e) {
			
			modelAndView.setViewName("member/modifail");
			e.printStackTrace();
			
		}
		
		modelAndView.addObject("MemberInfo",member);
		
		return modelAndView;
	}
}
