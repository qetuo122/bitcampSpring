package com.bitcamp.op.message.dao;

import java.sql.SQLException;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.bitcamp.op.message.model.Message;

public class MybatisMessageDao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	private String mapperPath = "com.bitcamp.op.mapper.mybatis.MessageMapper.";
	
	public int insert(Message message) throws SQLException {

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

	public int delete(int messageId) throws SQLException {
		
		return sqlSessionTemplate.delete(mapperPath + "deleteMessage", messageId); 
		
	}
}
