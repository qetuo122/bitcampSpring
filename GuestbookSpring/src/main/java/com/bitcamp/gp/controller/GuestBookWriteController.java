package com.bitcamp.gp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitcamp.gp.model.Message;
import com.bitcamp.gp.service.ServiceException;
import com.bitcamp.gp.service.WriteMessageService;

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
	public String writeMessage(Message message) throws ServiceException {
		
		service.write(message);
		
		return "guest/write";
	}
}
