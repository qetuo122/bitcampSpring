package com.bitcamp.op.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.bitcamp.op.member.model.MemberInfo;

public class JdbcTemplateMemberDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//jdbctemplate를 사용하면 cnnection받을필요 x
												   //, Connection conn
	public int insertMemberInfo(MemberInfo memberInfo) throws SQLException {
		
		int resultCnt = 0;
		
		//update, delete, insert는 매퍼를 사용하지 않고
		//select는 매퍼를 사용한다.
		String insert_sql = "insert into member (userid, password, username, userphoto ) values(?, ?, ?, ?)";
		
		KeyHolder keyholder = new GeneratedKeyHolder();
		resultCnt = jdbcTemplate.update(new PreparedStatementCreator(){
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement(insert_sql, new String[] {"idx"});
				pstmt.setString(1, memberInfo.getUserId());
				pstmt.setString(2, memberInfo.getPassword());
				pstmt.setString(3, memberInfo.getUserName());
				pstmt.setString(4, memberInfo.getUserPhoto());
				return pstmt;
			}
		},keyholder);
		
		Number keyValue = keyholder.getKey();
		
		memberInfo.setIdx(keyValue.intValue());
		
		return resultCnt;
	}

	public MemberInfo getMemberInfo(String id) {
		
		String sql = "select * from member where userid = ?";
		
		//데이터를 불러올때는 Mapper를 사용해줘야함
		List<MemberInfo> result = jdbcTemplate.query(sql, new RowMapper<MemberInfo>() {

			@Override
			public MemberInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				MemberInfo memberInfo = new MemberInfo();
				
				memberInfo.setUserId(rs.getString("userId"));
				memberInfo.setPassword(rs.getString("password"));
				memberInfo.setUserName(rs.getString("userName"));
				memberInfo.setUserPhoto(rs.getString("userphoto"));
				
				return memberInfo;
			}
			
		}, id);
		
		return result.isEmpty() ? null : result.get(0);
		
	}
	
	public List<MemberInfo> selectList(Connection conn) throws SQLException {
		
		String sql = "select * from member";
		
		// 매퍼의 리턴결과 값이 반복을 통해 리스트형식으로 자동저장됨
		List<MemberInfo> memberList = jdbcTemplate.query(sql, new RowMapper<MemberInfo>(){

			@Override
			public MemberInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			MemberInfo memberInfo = new MemberInfo();
			
			memberInfo.setUserId(rs.getString("userId"));
			memberInfo.setPassword(rs.getString("password"));
			memberInfo.setUserName(rs.getString("userName"));
			memberInfo.setUserPhoto(rs.getString("userphoto"));
			
			return memberInfo;
			
			}
		});
		
		return memberList.isEmpty() ? null : memberList;
		
	}
	
	public void delete(Connection conn, String userId) throws SQLException {
		
		String sql = "delete from member where userid = ?";
		
		int result = jdbcTemplate.update(sql, userId);
	}

	public int updateMember(Connection conn, MemberInfo memberInfo) throws SQLException {
		
		int resultCnt = 0;
		//메서드 안에서 만드므로 반드시 초기화해줘야함
		
		String sql = "update member set password = ?, username = ?, userphoto = ? where userid = ?";
		
		resultCnt = jdbcTemplate.update(sql,memberInfo.getPassword(), memberInfo.getUserName(), memberInfo.getUserPhoto(), memberInfo.getUserId());
		
		return resultCnt;
	}
}
