package com.bitcamp.pc.message.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.pc.message.service.MessageDeleteService;

@Controller
@RequestMapping("message/delete")
public class MessageDeleteController {
	
	@Autowired
	private MessageDeleteService service;
	
	public String delete(@RequestParam("messageId") int messageId) {
		
		service.delete(messageId);
		
		return "message/delete";
	}

}
