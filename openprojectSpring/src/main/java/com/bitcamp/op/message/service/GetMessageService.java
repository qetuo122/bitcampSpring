package com.bitcamp.op.message.service;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;

import com.bitcamp.op.jdbc.ConnectionProvider;
import com.bitcamp.op.message.dao.JdbcTemplateMessageDao;
import com.bitcamp.op.message.dao.MessageDao;
import com.bitcamp.op.message.model.Message;


public class GetMessageService {

	/*@Autowired
	MessageDao messageDao;*/
	
	@Autowired
	JdbcTemplateMessageDao messageDao;
	
	public Message getMessage(int id) throws SQLException {
		
		Connection conn = null;
		
		conn = ConnectionProvider.getConnection();
		
		int messageTotalCount = messageDao.selectCount(conn);
		
		Message message = null;
		
		if(messageTotalCount > 0) {
			
			message = messageDao.select(conn,id);
			
		}
		return message;
	}
}
