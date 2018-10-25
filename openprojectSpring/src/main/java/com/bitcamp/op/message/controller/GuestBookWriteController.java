package com.bitcamp.op.message.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.op.message.model.Message;
import com.bitcamp.op.message.service.WriteMessageService;


@Controller
@RequestMapping("/guest/write")
public class GuestBookWriteController {
	
	@Autowired
	private WriteMessageService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public String getWriteForm() {
		
		return "guest/writeForm";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String writeMessage(Message message, 
			@RequestParam("userId") String userId) {
		
		service.write(message,userId);
		
		return "guest/write";
	}
}
