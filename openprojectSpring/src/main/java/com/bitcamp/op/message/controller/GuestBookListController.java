package com.bitcamp.op.message.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bitcamp.op.message.model.MessageListView;
import com.bitcamp.op.message.service.GetMessageListService;
import com.bitcamp.op.message.service.ServiceException;


@Controller
public class GuestBookListController {
	
	@Autowired
	private GetMessageListService service;
	
	@RequestMapping("/guest/messageList")   //guest/list?page=1의 형식
	public ModelAndView getGuestList(HttpServletRequest request) throws ServiceException {
		
		String pageNumberStr = request.getParameter("page");
		int pageNumber = 1;
		
		if (pageNumberStr != null) {
			pageNumber = Integer.parseInt(pageNumberStr);
		}
		
		//view의 데이터를 담음
		MessageListView viewData = service.getMessageList(pageNumber);
		
		ModelAndView modelAndView = new ModelAndView();

		//viewName 설정
		modelAndView.setViewName("guest/messageList");
		
		//view에 결과 데이터를 전달(공유)
		modelAndView.addObject("viewData",viewData);
		System.out.println(viewData);
		System.out.println(modelAndView);
		return modelAndView;
	}
	
	/*@RequestMapping("/guestbook/list")
	public ModelAndView getList(
			@RequestParam(value="page",defaultValue="1")int pageNumber) throws ServiceException {
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("guestbook/list");
		
		MessageListView listView = service.getMessageList(pageNumber);
		
		modelAndView.addObject("listView",listView);
		
		return modelAndView;
	}*/
}
