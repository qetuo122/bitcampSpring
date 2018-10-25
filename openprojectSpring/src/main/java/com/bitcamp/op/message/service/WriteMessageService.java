package com.bitcamp.op.message.service;


import org.springframework.beans.factory.annotation.Autowired;

import com.bitcamp.op.message.dao.MybatisMessageDao;
import com.bitcamp.op.message.model.Message;


public class WriteMessageService {
	
	/*@Autowired
	MessageDao messageDao;*/
	
	/*@Autowired
	JdbcTemplateMessageDao messageDao;*/
	
	@Autowired
	private MybatisMessageDao messageDao;

	public void write(Message message, String userId) {
			message.setUserid_member(userId);
			messageDao.insert(message);
			
	}
}
