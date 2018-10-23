package com.bitcamp.op.member.service;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.bitcamp.op.jdbc.ConnectionProvider;
import com.bitcamp.op.jdbc.JdbcUtil;
import com.bitcamp.op.member.dao.JdbcTemplateMemberDao;
import com.bitcamp.op.member.model.MemberInfo;

public class MemberModiService {

	/*@Autowired
	MemberDao memberDao;*/
	
	@Autowired
	private JdbcTemplateMemberDao memberDao;
	
	Connection conn = null;
	
	public MemberInfo getMember(String id) throws SQLException {
		
		
		conn = ConnectionProvider.getConnection();
		
		MemberInfo memberInfo = memberDao.getMemberInfo(id);
		
		return memberInfo;
	}
	
	public int modiMember(MemberInfo memberInfo, HttpServletRequest request) throws SQLException, IllegalStateException, IOException {
		
		// 데이터베이스에 접속하기위해 컨넥션 객체를 불러옴
		conn = ConnectionProvider.getConnection();
		
		int resultCnt = 0;
		
		//물리적으로 저장 후에 DB에 저장
		
		//물리적 저장경로
		String uploadUri = "/uploadfile/userphoto";
		//uploadUri 경로의 시스템 경로
		String dir = request.getSession().getServletContext().getRealPath(uploadUri);
		//DB 저장용 파일이름
		String imgName = "";
		
		if(!memberInfo.getPhotoFile().isEmpty()) {
			
			imgName = memberInfo.getUserId() + "_" + memberInfo.getPhotoFile().getOriginalFilename();
			
			new File(dir, imgName).delete();
			//물리적 저장
			memberInfo.getPhotoFile().transferTo(new File(dir, imgName));
			
			//DB에 저장할 이름을 SET
			memberInfo.setUserPhoto(imgName);
		}
		
		try {
			
			conn.setAutoCommit(false);
			resultCnt = memberDao.updateMember(conn, memberInfo);
		
			conn.commit();
		} catch (Exception e) {
			
			new File(dir, imgName).delete();
			JdbcUtil.rollback(null);
			throw e;
			
		} finally {
			
			conn.setAutoCommit(true);
			JdbcUtil.close(conn);
		}
		
		return 0;
		
	}
	
}
