package com.bitcamp.gp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.gp.service.DeleteMessageService;
import com.bitcamp.gp.service.InvalidMessagePassowrdException;
import com.bitcamp.gp.service.MessageNotFoundException;
import com.bitcamp.gp.service.ServiceException;

@Controller
@RequestMapping("/guest/delete")
public class GuestBookDeleteController {
	
	@Autowired
	private DeleteMessageService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public String getDeleteForm(
			@RequestParam("id") String id, Model model) {

		model.addAttribute("mId",id);
		
		return "guest/confirmDelete";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String deleteMessage(
			@RequestParam("messageId") int messageId,
			@RequestParam("password") String password) {
		
		String viewName = "redirect:/guest/list";
		
		try {
			
			//아이디와 비밀번호값을 받아와서 삭제처리
			service.deleteMessage(messageId, password);
		
			//다시 해당아이디를 삭제클릭했을때 화면으로 리다이렉트
		} catch (ServiceException e) {
			
			viewName = "guest/error";
			
		} catch (InvalidMessagePassowrdException e) {
			
			//비밀번호가 맞지 않을때
			viewName = "redirect:/guest/delete?id=" + messageId;
			
		} catch (MessageNotFoundException e) {
			//게시물이 없을때
			viewName = "redirect:/guest/list";
		}
		
		return viewName;
	}
}
