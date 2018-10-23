package com.bitcamp.gp.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bitcamp.gp.dao.JdbcTemplateMessageDao;
import com.bitcamp.gp.jdbc.ConnectionProvider;
import com.bitcamp.gp.jdbc.JdbcUtil;
import com.bitcamp.gp.model.Message;
import com.bitcamp.gp.model.MessageListView;

public class GetMessageListService {
	
	/*@Autowired
	MessageDao messageDao;*/
	
	@Autowired
	JdbcTemplateMessageDao messageDao;

	// 한 페이지에 보여줄 메시지의 수
	private static final int MESSAGE_COUNT_PER_PAGE = 3;

	public MessageListView getMessageList(int pageNumber) throws ServiceException {
		Connection conn = null;
		int currentPageNumber = pageNumber;

		try {
			conn = ConnectionProvider.getConnection();
			
			// 전체 메시지 구하기
			int messageTotalCount = messageDao.selectCount(conn);
			List<Message> messageList = null;
			int firstRow = 0;
			int endRow = 0;
			if (messageTotalCount > 0) {
				firstRow = (pageNumber - 1) * MESSAGE_COUNT_PER_PAGE + 1;
				endRow = firstRow + MESSAGE_COUNT_PER_PAGE - 1;
				messageList = messageDao.selectList(firstRow, endRow);
			} else {
				currentPageNumber = 0;
				messageList = Collections.emptyList();
			}
			return new MessageListView(messageList, messageTotalCount, currentPageNumber, MESSAGE_COUNT_PER_PAGE,
					firstRow, endRow);
		} catch (SQLException e) {
			throw new ServiceException("메시지 목록 구하기 실패: " + e.getMessage(), e);
		} finally {
			JdbcUtil.close(conn);
		}

	}

}
