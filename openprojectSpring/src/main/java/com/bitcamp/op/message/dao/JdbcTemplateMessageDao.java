package com.bitcamp.op.message.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.bitcamp.op.jdbc.JdbcUtil;
import com.bitcamp.op.message.model.Message;

public class JdbcTemplateMessageDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int insert(Message message, String userId) throws SQLException {

		int resultCnt = 0;

		String insertSql = "insert into guestbook_message (userid_member, message) values (?, ?) ";

		resultCnt = jdbcTemplate.update(insertSql, userId, message.getMessage());

		return resultCnt;

	}

	public int selectCount(Connection conn) throws SQLException {

		String sql = "select count(*) from guestbook_message" ;
		
		return jdbcTemplate.queryForObject(sql, Integer.class);
		
	}

	public List<Message> selectList(int firstRow, int endRow) {

		String listSql = "select * from guestbook_message order by message_id desc limit ?, ?";

		List<Message> messageList = jdbcTemplate.query(listSql, new RowMapper<Message>() {

			@Override
			public Message mapRow(ResultSet rs, int rowNum) throws SQLException {

				Message message = new Message();

				message.setMessage_id(rs.getInt("message_id"));
				message.setUserid_member(rs.getString("userid_member"));
				message.setMessage(rs.getString("message"));

				System.out.println(message);
				return message;
			}
		}, firstRow, endRow);
		
		// mySql -> firstRow: 시작 행, endRow: 보여질 아이템 수  (첫 행은 0)
	    // oracle -> firstRow: 시작 행, endRow: 끝 행 (첫 행은 1)
		
		System.out.println(messageList);

		return  messageList.isEmpty() ? null : messageList;

	}


	public Message select(Connection conn, int messageId) throws SQLException {
		
		String sql = "select * from guestbook_message where message_id = ?";
		
		List<Message> result = jdbcTemplate.query(sql, new RowMapper<Message>() {

			@Override
			public Message mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Message message = new Message();
				message.setMessage_id(rs.getInt("message_id"));
				message.setUserid_member(rs.getString("userid_member"));
				message.setMessage(rs.getString("message"));
				
				System.out.println(message);
				return message;
			}
			
		}, messageId);
		
		return result.isEmpty() ? null : result.get(0);
	}

	public void delete(Connection conn, int messageId) throws SQLException {
		
		String sql = "delete from guestbook_message where message_id = ?";
		
		int result = jdbcTemplate.update(sql, messageId);
		
	}
}
