package com.bitcamp.pc.message.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.bitcamp.pc.message.MybatisMessageDao;
import com.bitcamp.pc.message.model.Message;

public class MessageDetailService {

	@Autowired
	private MybatisMessageDao messageDao;
	
	public Message select(String messageId) {
		
		return messageDao.selectOne(messageId);
		
	}
	
}
