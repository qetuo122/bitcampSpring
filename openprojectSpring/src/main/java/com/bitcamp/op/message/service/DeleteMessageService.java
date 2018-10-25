package com.bitcamp.op.message.service;


import org.springframework.beans.factory.annotation.Autowired;

import com.bitcamp.op.message.dao.MybatisMessageDao;


public class DeleteMessageService {

	/*@Autowired
	MessageDao messageDao;*/
	
	@Autowired
	private MybatisMessageDao messageDao;

	public void deleteMessage(int messageId) {

			messageDao.delete(messageId);

	}

}
