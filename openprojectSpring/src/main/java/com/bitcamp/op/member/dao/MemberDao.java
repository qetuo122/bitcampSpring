package com.bitcamp.op.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.bitcamp.op.jdbc.JdbcUtil;
import com.bitcamp.op.member.model.MemberInfo;

public class MemberDao {

	public int insertMemberInfo(Connection conn, MemberInfo memberInfo) throws SQLException {
		
		int resultCnt = 0;
		//메서드 안에서 만드므로 반드시 초기화해줘야함
		PreparedStatement pstmt = null;
		
		String insert_sql = "insert into member (userid, password, username, userphoto ) values(?, ?, ?, ?)";
		
		try {
		
			pstmt = conn.prepareStatement(insert_sql);
			pstmt.setString(1, memberInfo.getUserId());
			pstmt.setString(2, memberInfo.getPassword());
			pstmt.setString(3, memberInfo.getUserName());
			pstmt.setString(4, memberInfo.getUserPhoto());
			
			//stmt는 ()안에 sql문이 들어감
			resultCnt = pstmt.executeUpdate();
			
		} finally {
			
			JdbcUtil.close(pstmt);
		}
		
		return resultCnt;
	}

	public MemberInfo getMemberInfo(Connection conn, String id) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from member where userid = ?";
		
		MemberInfo memberInfo = null;
		try {
		
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			//rs에 db에서 불러온 데이터 저장
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				//불러온 데이터가 있다면 멤버 객체에 저장
				memberInfo = new MemberInfo();
				memberInfo.setUserId(rs.getString("userId"));
				memberInfo.setPassword(rs.getString("password"));
				memberInfo.setUserName(rs.getString("userName"));
				memberInfo.setUserPhoto(rs.getString("userphoto"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memberInfo;
	}
	
	public List<MemberInfo> selectList(Connection conn) throws SQLException {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MemberInfo> memberList = new ArrayList<MemberInfo>();
		try {
			
			String sql = "select * from member";
			//db에서 데이터를 불러온다
			pstmt = conn.prepareStatement(sql);
			//rs에 
			rs = pstmt.executeQuery();
			if (rs.next()) {
				
				do {
					memberList.add(makeMemberFromResultSet(rs));
				} while (rs.next());
				// return messageList;
			} else {
				// return Collections.emptyList();
				memberList = Collections.emptyList();
			}
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return memberList;
	}
	
	private MemberInfo makeMemberFromResultSet(ResultSet rs) throws SQLException {
		MemberInfo member = new MemberInfo();
		member.setUserId(rs.getString("userId"));
		member.setPassword(rs.getString("password"));
		member.setUserName(rs.getString("userName"));
		member.setUserPhoto(rs.getString("userphoto"));
		
		return member;
	}

	public void delete(Connection conn, String userId) throws SQLException {
		
		PreparedStatement pstmt = null;
		String sql = "delete from member where userid = ?";
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.executeUpdate();
			
		} finally {		
			JdbcUtil.close(pstmt);
		}
	}

	public int updateMember(Connection conn, MemberInfo memberInfo) throws SQLException {
		
		int resultCnt = 0;
		//메서드 안에서 만드므로 반드시 초기화해줘야함
		PreparedStatement pstmt = null;
		
		String sql = "update member set password = ?, username = ?, userphoto = ? where userid = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, memberInfo.getPassword());
			pstmt.setString(2, memberInfo.getUserName());
			pstmt.setString(3, memberInfo.getUserPhoto());
			pstmt.setString(4, memberInfo.getUserId());
			
			//stmt는 ()안에 sql문이 들어감
			resultCnt = pstmt.executeUpdate();
			
		} finally {
			
			JdbcUtil.close(pstmt);
			
		}
		
		return resultCnt;
	}

	

}
