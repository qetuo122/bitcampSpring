package com.bitcamp.pc.message.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.pc.message.model.Message;
import com.bitcamp.pc.message.service.MessageDetailService;
import com.bitcamp.pc.message.service.MessageGetListService;

@Controller
public class MessageListGetController {
	
	@Autowired
	private MessageGetListService service;
	
	@Autowired
	private MessageDetailService service2;
	
	@RequestMapping("message/messageList")
	public String getMessage(Model model, HttpServletRequest request) {
		
		String messageId = request.getParameter("messageId");
		
		Message message = service2.select(messageId);
		List<Message> list = service.getMessage();
		
		model.addAttribute("list", list);
		model.addAttribute("detail", message);
		
		return "message/messageList";
	}

}
