package com.bitcamp.op.member.dao;

import java.sql.SQLException;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.bitcamp.op.member.model.MemberInfo;

public class MybatisMemberDao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private String mapperPath = "com.bitcamp.op.mapper.mybatis.MemberMapper.";
	
	//멤버가입
	public int insertMemberInfo(MemberInfo memberInfo) throws SQLException {
		
		return sqlSessionTemplate.update(mapperPath + "insertMember",memberInfo);
	}

	//데이터베이스에서 멤버정보 불러옴
	public MemberInfo getMemberInfo(String userId) {
		
		//객체 1개를 받을땐 selectOne, 리스트형식으로 다받을땐 selectList
		return sqlSessionTemplate.selectOne(mapperPath + "selectById", userId);
		
	}
	
	//멤버 리스트
	public List<MemberInfo> selectList() throws SQLException {
		
		return sqlSessionTemplate.selectList(mapperPath + "selectMember");
		
	}
	
	//멤버 삭제
	public int delete(String userId) throws SQLException {
		
		return sqlSessionTemplate.delete(mapperPath + "deleteMember", userId);
	}

	//멤버수정
	public int updateMember(MemberInfo memberInfo) throws SQLException {
		
		return sqlSessionTemplate.update(mapperPath + "modiMember", memberInfo);
	}
}
