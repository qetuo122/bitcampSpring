package com.bitcamp.pc.message;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.bitcamp.pc.message.model.Message;

public class MybatisMessageDao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private String mapperPath = "com.bitcamp.pc.mapper.mybatis.MessageMapper.";
	
	public int insert(Message message) {

		return sqlSessionTemplate.update(mapperPath + "insertMessage", message);

	}
	
	public List<Message> selectList(){
		
		return sqlSessionTemplate.selectList(mapperPath + "selectList");
	}
	
	public Message selectOne(String messageId) {
		
		return sqlSessionTemplate.selectOne(mapperPath + "selectOne", messageId);
	}
	
	public int deleteMessage(int messageId) {
		
		return sqlSessionTemplate.delete(mapperPath + "deleteMessage", messageId);
	}
}
