package com.bitcamp.pc.message.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.pc.message.model.Message;
import com.bitcamp.pc.message.service.MessageGetListService;

@Controller
@RequestMapping("message/messageForm")
public class MessageListGetController {
	
	@Autowired
	private MessageGetListService service;
	
	public String getMessage(
			@RequestParam("userId") String userId,
			@RequestParam("adminId") String adminId,
			Message message, Model model) {
		
		message.setAdminId(adminId);
		message.setUserId(userId);
		
		model.addAttribute("data", service.getMessage(message));
		return "message/messageForm";
	}

}
