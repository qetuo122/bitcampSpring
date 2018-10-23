package com.bitcamp.op;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.op.member.service.InvalidmemberPassowrdException;
import com.bitcamp.op.member.service.MemberDeleteService;


@Controller
@RequestMapping("/member/delete")
public class MemberDeleteController {
	
	@Autowired
	private MemberDeleteService deleteService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String deleteForm(Model model, @RequestParam("id") String id) {
		
		model.addAttribute("id",id);
		
		return "member/delete";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String delete(
			@RequestParam("userId") String userId,
			@RequestParam("password") String password,
			HttpSession session) {
		
		String viewName = "redirect:/member/memberList";
		
		try {
			
			//아이디와 비밀번호값을 받아와서 삭제처리
			deleteService.deleteMember(userId, password);
			//세션의 종료
			session.invalidate();

		} catch (InvalidmemberPassowrdException e) {
			
			//비밀번호가 맞지 않을때
			viewName = "redirect:/member/delete?id=" + userId;
		}
		return viewName;
	}

}
