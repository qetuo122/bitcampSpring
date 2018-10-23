package com.bitcamp.gp.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bitcamp.gp.model.Message;
import com.bitcamp.gp.service.GetMessageService;

@Controller
public class GuestbookViewController {

	@Autowired
	GetMessageService service;
	
	@RequestMapping("/guest/view/{id}")
	public String getView(@PathVariable("id") int id,
			Model model) throws SQLException {
		
		Message message = service.getMessage(id);
		
		model.addAttribute("id", id);
		model.addAttribute("guestName",message.getGuestName());
		model.addAttribute("message",message.getMessage());
		
		return "guest/view";
	}
}
