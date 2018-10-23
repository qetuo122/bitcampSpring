package com.bitcamp.gp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.bitcamp.gp.jdbc.JdbcUtil;
import com.bitcamp.gp.model.Message;

public class JdbcTemplateMessageDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int insert(Message message) throws SQLException {

		int resultCnt = 0;

		String insertSql = "insert into guestbook_message (message_id, guest_name, password, message) values (message_id_seq.NEXTVAL, ?, ?, ?) ";

		resultCnt = jdbcTemplate.update(insertSql, message.getGuestName(), message.getPassword(), message.getMessage());

		return resultCnt;

	}

	public int selectCount(Connection conn) throws SQLException {

		String sql = "select count(*) from guestbook_message" ;
		
		return jdbcTemplate.queryForObject(sql, Integer.class);
		
		
		/*Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select count(*) from guestbook_message");
			rs.next();
			return rs.getInt(1);
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
*/	}

	public List<Message> selectList(int firstRow, int endRow) {

		String listSql = "select message_id, guest_name, password, message from ( "
				+ " select rownum rnum, message_id, guest_name, password, message from ( "
				+ " select * from guestbook_message m order by m.message_id desc " + " ) where rownum <= ? "
				+ ") where rnum >= ?";

		List<Message> messageList = jdbcTemplate.query(listSql, new RowMapper<Message>() {

			@Override
			public Message mapRow(ResultSet rs, int rowNum) throws SQLException {

				Message message = new Message();

				message.setId(rs.getInt("message_id"));
				message.setGuestName(rs.getString("guest_name"));
				message.setPassword(rs.getString("password"));
				message.setMessage(rs.getString("message"));

				System.out.println(message);
				return message;
			}
		}, endRow, firstRow);
		
		System.out.println(messageList);

		return  messageList.isEmpty() ? null : messageList;

		/*
		 * try { pstmt = conn.
		 * prepareStatement("select message_id, guest_name, password, message from ( " +
		 * " select rownum rnum, message_id, guest_name, password, message from ( " +
		 * " select * from guestbook_message m order by m.message_id desc " +
		 * " ) where rownum <= ? " + ") where rnum >= ?"); pstmt.setInt(1, endRow);
		 * pstmt.setInt(2, firstRow); rs = pstmt.executeQuery(); if (rs.next()) { do {
		 * messageList.add(makeMessageFromResultSet(rs)); } while (rs.next()); // return
		 * messageList; } else { // return Collections.emptyList(); messageList =
		 * Collections.emptyList(); } } finally { JdbcUtil.close(rs);
		 * JdbcUtil.close(pstmt); } return messageList;
		 */
	}

	private Message makeMessageFromResultSet(ResultSet rs) throws SQLException {
		Message message = new Message();
		message.setId(rs.getInt("message_id"));
		message.setGuestName(rs.getString("guest_name"));
		message.setPassword(rs.getString("password"));
		message.setMessage(rs.getString("message"));
		return message;
	}

	public Message select(Connection conn, int messageId) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select * from guestbook_message where message_id = ?");
			pstmt.setInt(1, messageId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return makeMessageFromResultSet(rs);
			} else {
				return null;
			}
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

	public void delete(Connection conn, int messageId) throws SQLException {
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement("delete from guestbook_message where message_id = ?");
			pstmt.setInt(1, messageId);
			pstmt.executeUpdate();
		} finally {
			JdbcUtil.close(pstmt);
		}

	}

}
