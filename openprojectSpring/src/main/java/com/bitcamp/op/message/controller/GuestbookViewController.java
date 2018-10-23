package com.bitcamp.op.message.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.op.message.model.Message;
import com.bitcamp.op.message.service.GetMessageService;


@Controller
public class GuestbookViewController {

	@Autowired
	GetMessageService service;
	
	@RequestMapping("guest/view")
	public String getView(@RequestParam("id") int id,
			Model model) throws SQLException {
		
		Message message = service.getMessage(id);
		
		System.out.println(message.getUserid_member());
		System.out.println(message.getMessage());
		model.addAttribute("id", id);
		model.addAttribute("userid_member",message.getUserid_member());
		model.addAttribute("message",message.getMessage());
		
		
		return "guest/view";
	}
}
