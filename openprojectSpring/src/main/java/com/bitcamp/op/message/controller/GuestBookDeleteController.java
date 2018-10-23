package com.bitcamp.op.message.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.op.message.service.DeleteMessageService;
import com.bitcamp.op.message.service.InvalidMessagePassowrdException;
import com.bitcamp.op.message.service.MessageNotFoundException;
import com.bitcamp.op.message.service.ServiceException;


@Controller
public class GuestBookDeleteController {
	
	@Autowired
	private DeleteMessageService service;

	@RequestMapping("/guest/delete")
	public String deleteMessage(
			@RequestParam("id") int messageId) throws ServiceException, InvalidMessagePassowrdException, MessageNotFoundException {
		
		//클릭한 메세지번호(id)를 불러와 삭제처리
		service.deleteMessage(messageId);
		
		
		return "redirect:/guest/messageList";
		
	}
}
