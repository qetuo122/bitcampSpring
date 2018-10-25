package com.bitcamp.pc.message.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.bitcamp.pc.message.MybatisMessageDao;

public class MessageDeleteService {

	@Autowired
	private MybatisMessageDao messageDao;
	
	public void delete(int messageId) {
		
		messageDao.deleteMessage(messageId);
	}
}
