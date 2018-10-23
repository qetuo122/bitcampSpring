package com.bitcamp.op.member.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bitcamp.op.jdbc.JdbcUtil;
import com.bitcamp.op.jdbc.ConnectionProvider;
import com.bitcamp.op.member.dao.MemberDao;
import com.bitcamp.op.member.model.MemberInfo;

public class MemberListService {
	
	@Autowired
	MemberDao memberDao;
	
	public List<MemberInfo> getMemberList(){
		
		Connection conn = null;
		List<MemberInfo> memberList = null;
		
		try {
			
			conn = ConnectionProvider.getConnection();
			memberList = memberDao.selectList(conn);
			
		} catch (SQLException e) {
			
		} finally {
			JdbcUtil.close(conn);
		}
		return memberList;
	}

}
