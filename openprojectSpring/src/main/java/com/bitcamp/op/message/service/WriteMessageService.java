package com.bitcamp.op.message.service;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;

import com.bitcamp.op.jdbc.ConnectionProvider;
import com.bitcamp.op.jdbc.JdbcUtil;
import com.bitcamp.op.member.model.MemberInfo;
import com.bitcamp.op.message.dao.JdbcTemplateMessageDao;
import com.bitcamp.op.message.dao.MessageDao;
import com.bitcamp.op.message.model.Message;


public class WriteMessageService {
	
	@Autowired
	MessageDao messageDao;
	
	/*@Autowired
	JdbcTemplateMessageDao messageDao;*/

	public void write(Message message, String userId) throws ServiceException {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			
			messageDao.insert(conn, message, userId);
			
			
		} catch (SQLException e) {
			throw new ServiceException("메시지 등록 실패: " + e.getMessage(), e);
		} finally {
			JdbcUtil.close(conn);
		}
	}
}
