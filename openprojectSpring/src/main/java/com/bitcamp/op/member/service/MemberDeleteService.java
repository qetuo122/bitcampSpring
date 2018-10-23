package com.bitcamp.op.member.service;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;

import com.bitcamp.op.jdbc.JdbcUtil;
import com.bitcamp.op.jdbc.ConnectionProvider;
import com.bitcamp.op.member.dao.MemberDao;
import com.bitcamp.op.member.model.MemberInfo;

public class MemberDeleteService {
	
	@Autowired
	MemberDao memberDao;
	
	public void deleteMember(String userId, String password) throws InvalidmemberPassowrdException {
		
		Connection conn = null;
		
		try {
			
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			MemberInfo memberInfo = memberDao.getMemberInfo(conn, userId);
			
			if(!memberInfo.getPassword().equals(password) && password != null && !password.isEmpty()) {
				
				throw new InvalidmemberPassowrdException();
				
			}
			
			memberDao.delete(conn, userId);
			conn.commit();
			
		} catch (SQLException e) {
			
			JdbcUtil.rollback(conn);
			e.printStackTrace();
		
		} finally {
			
			JdbcUtil.close(conn);
		}
	}

}
