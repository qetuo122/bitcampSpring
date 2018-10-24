package com.bitcamp.op.message.service;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;

import com.bitcamp.op.jdbc.ConnectionProvider;
import com.bitcamp.op.jdbc.JdbcUtil;
import com.bitcamp.op.message.dao.MybatisMessageDao;
import com.bitcamp.op.message.model.Message;


public class WriteMessageService {
	
	/*@Autowired
	MessageDao messageDao;*/
	
	/*@Autowired
	JdbcTemplateMessageDao messageDao;*/
	
	@Autowired
	private MybatisMessageDao messageDao;

	public void write(Message message, String userId) throws ServiceException {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			
			message.setUserid_member(userId);
			messageDao.insert(message);
			
			
		} catch (SQLException e) {
			throw new ServiceException("메시지 등록 실패: " + e.getMessage(), e);
		} finally {
			JdbcUtil.close(conn);
		}
	}
}
