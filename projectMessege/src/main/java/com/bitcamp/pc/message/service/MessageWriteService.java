package com.bitcamp.pc.message.service;


import org.springframework.beans.factory.annotation.Autowired;

import com.bitcamp.pc.message.MybatisMessageDao;
import com.bitcamp.pc.message.model.Message;

public class MessageWriteService {

	@Autowired
	private MybatisMessageDao messageDao;
	
	public void write(Message message, String userId) {
		
			message.setUserId(userId);
			messageDao.insert(message);
	}
}
