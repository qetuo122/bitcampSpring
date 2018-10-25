package com.bitcamp.pc.message.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.pc.message.model.Message;
import com.bitcamp.pc.message.service.MessageWriteService;

@Controller
@RequestMapping("/message/messageForm")
public class MessageWriteController {
	
	@Autowired
	private MessageWriteService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public String messageForm() {
		
		return "message/messageForm";
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String writeMessage(@RequestParam("userId") String userId,
			Message message) {
		
		service.write(message, userId);
		
		return "message/messageForm";
	}
	
	
}
