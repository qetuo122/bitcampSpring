package com.bitcamp.pc.message.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.pc.message.model.Message;
import com.bitcamp.pc.message.service.MessageDetailService;

@Controller
public class MessageDetailController {
	
	@Autowired
	private MessageDetailService service;
	
	@RequestMapping("/message/detail")
	public String detail(@RequestParam("messageId") int messageId,
			Model model) {
		
		Message message = service.select(messageId);
		
		model.addAttribute("data",message);
		
		return "message/detail";
	}

}
