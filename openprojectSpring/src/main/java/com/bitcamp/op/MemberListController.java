package com.bitcamp.op;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bitcamp.op.member.model.MemberInfo;
import com.bitcamp.op.member.service.MemberListService;

@Controller
public class MemberListController {

	@Autowired
	MemberListService listService;
	
	@RequestMapping("/member/memberList")
	public String getMemberList(Model model) {
		
		List<MemberInfo> member = new ArrayList<MemberInfo>();
		member = listService.getMemberList();
		
		model.addAttribute("members",member);
		
		return "member/memberList";
	}
}
