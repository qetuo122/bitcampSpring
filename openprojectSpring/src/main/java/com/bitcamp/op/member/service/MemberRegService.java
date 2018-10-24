package com.bitcamp.op.member.service;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.bitcamp.op.jdbc.ConnectionProvider;
import com.bitcamp.op.member.dao.MybatisMemberDao;
import com.bitcamp.op.member.model.MemberInfo;

public class MemberRegService {
	
	/*@Autowired
	private MemberDao memberDao;*/
	
	/*@Autowired
	private JdbcTemplateMemberDao memberDao;*/
	
	@Autowired
	private MybatisMemberDao memberDao;

	private Connection conn;
	
	@Transactional
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
		
																	//, conn
			resultCnt = memberDao.insertMemberInfo(memberInfo);
			
			System.out.println("신규회원의 idx값" + memberInfo.getIdx());
		
					
		
		
		return 0;
	}
}
