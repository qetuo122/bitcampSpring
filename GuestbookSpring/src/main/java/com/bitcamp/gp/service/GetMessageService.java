package com.bitcamp.gp.service;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;

import com.bitcamp.gp.dao.MessageDao;
import com.bitcamp.gp.jdbc.ConnectionProvider;
import com.bitcamp.gp.model.Message;

public class GetMessageService {

	@Autowired
	MessageDao messageDao;
	
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
