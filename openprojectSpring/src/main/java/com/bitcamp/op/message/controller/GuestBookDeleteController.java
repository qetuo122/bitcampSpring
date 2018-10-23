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
			@RequestParam("id") int messageId) {
		
		String viewName = "redirect:/guest/messageList";
		
		try {
			
			//클릭한 메세지번호(id)를 불러와 삭제처리
			service.deleteMessage(messageId);
		
		} catch (ServiceException e) {
			
			viewName = "guest/error";
			
		} catch (InvalidMessagePassowrdException e) {
			
			//비밀번호가 맞지 않을때
			viewName = "redirect:/guest/delete?id=" + messageId;
			
		} catch (MessageNotFoundException e) {
			//게시물이 없을때
			viewName = "redirect:/guest/messageList";
		}
		
		return viewName;
	}
}
