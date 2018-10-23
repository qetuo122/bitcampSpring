package com.bitcamp.op.member.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.bitcamp.op.jdbc.ConnectionProvider;
import com.bitcamp.op.member.dao.MemberDao;
import com.bitcamp.op.member.model.MemberInfo;

public class MemberLoginService {

	@Autowired
	private MemberDao memberDao;
	
	public boolean login(String id, String pw, HttpSession session) throws SQLException {
		
		Connection conn = ConnectionProvider.getConnection();
		boolean result = false;
		
		MemberInfo memberInfo = memberDao.getMemberInfo(conn, id);
		
		//사용자가 입력한 id의 데이터가 존재유무 확인
		if(memberInfo != null && memberInfo.getPassword().equals(pw)) {
			
			//비밀번호비교
			//if(memberInfo.getPassword().equals(pw)) {
				
				//로그인 처리 : 세션이 사용자 데이터 저장
				//세션에는 개인정보를 담지 않으므로 비밀번호비교후 공백처리
				memberInfo.setPassword("");
				
				session.setAttribute("loginInfo", memberInfo);
				
				result = true;
			}
			
			
		//}
		
		return result;
	}
	
}
