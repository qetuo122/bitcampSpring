package com.bitcamp.op.message.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.bitcamp.op.jdbc.JdbcUtil;
import com.bitcamp.op.message.model.Message;

public class MybatisMessageDao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	private String mapperPath = "com.bitcamp.op.mapper.mybatis.MessageMapper.";
	
	public int insert(Message message) throws SQLException {
		System.out.println(message);
		return sqlSessionTemplate.update(mapperPath + "insertMessage", message);

	}

	public int selectCount() throws SQLException {

		return sqlSessionTemplate.selectOne(mapperPath + "selectCount");
		
	}

	public List<Message> selectList(int firstRow) {

		return sqlSessionTemplate.selectList(mapperPath + "selectList",firstRow);

	}


	public Message select(int messageId) throws SQLException {
		
		return sqlSessionTemplate.selectOne(mapperPath + "select", messageId);
	}

	public void delete(Connection conn, int messageId) throws SQLException {
		
		String sql = "delete from guestbook_message where message_id = ?";
		
		int result = jdbcTemplate.update(sql, messageId);
		
	}
}