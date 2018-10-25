package com.bitcamp.pc.message.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bitcamp.pc.message.MybatisMessageDao;
import com.bitcamp.pc.message.model.Message;

public class MessageGetListService {

	@Autowired
	private MybatisMessageDao messageDao;
	
	public List<Message> getMessage(Message message) {
		
		List<Message> list = messageDao.selectList(message);
		
		return list;
	}
}
