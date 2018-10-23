package com.bitcamp.op.member.service;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.bitcamp.op.jdbc.ConnectionProvider;
import com.bitcamp.op.jdbc.JdbcUtil;
import com.bitcamp.op.member.dao.MemberDao;
import com.bitcamp.op.member.model.MemberInfo;

public class MemberRegService {
	
	@Autowired
	private MemberDao memberDao;

	private Connection conn;
	public int memberReg(MemberInfo memberInfo, HttpServletRequest request) throws SQLException, IllegalStateException, IOException {
		
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
		
			//물리적 저장
			memberInfo.getPhotoFile().transferTo(new File(dir, imgName));
			
			//DB에 저장할 이름을 SET
			memberInfo.setUserPhoto(imgName);
		}
		
		try {
		
			conn.setAutoCommit(false);
			resultCnt = memberDao.insertMemberInfo(conn, memberInfo);
		
			conn.commit();
		} catch (Exception e) {
			JdbcUtil.rollback(null);
			throw e;
			
		} finally {
			
			conn.setAutoCommit(true);
			JdbcUtil.close(conn);
		}
		
		return 0;
	}
}
