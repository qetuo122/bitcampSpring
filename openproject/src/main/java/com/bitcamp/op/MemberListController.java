package com.bitcamp.op;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bitcamp.op.member.model.MemberListView;
import com.bitcamp.op.member.service.MemberListService;

@Controller
public class MemberListController {

	@Autowired
	MemberListService listService;
	
	@RequestMapping("/member/memberList")
	public String getMemberList(Model model) {
		
		MemberListView member = listService.getMemberList();
		
		model.addAttribute("member",member.getMemberList());
		
		return "member/memberList";
	}
}
