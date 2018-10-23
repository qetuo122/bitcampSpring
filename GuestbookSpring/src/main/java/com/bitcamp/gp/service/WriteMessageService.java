package com.bitcamp.gp.service;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;

import com.bitcamp.gp.dao.JdbcTemplateMessageDao;
import com.bitcamp.gp.dao.MessageDao;
import com.bitcamp.gp.jdbc.ConnectionProvider;
import com.bitcamp.gp.jdbc.JdbcUtil;
import com.bitcamp.gp.model.Message;

public class WriteMessageService {
	
	/*@Autowired
	MessageDao messageDao;*/
	
	@Autowired
	JdbcTemplateMessageDao messageDao;

	public void write(Message message) throws ServiceException {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			
			messageDao.insert(message);
			
			
		} catch (SQLException e) {
			throw new ServiceException("메시지 등록 실패: " + e.getMessage(), e);
		} finally {
			JdbcUtil.close(conn);
		}
	}
}
