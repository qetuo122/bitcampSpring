<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../css/default.css">
<title>Insert title here</title>
<style>
	#bookTitle{
		margin-top : 10px;
		margin-left : 20px;
		margin-bottom : 10px;
	}
	#wrap{
		margin-left : 50px;
		margin-right : 50px;
	}
	#bookUlWrap{
		float : left;
	}
	#bookUl{
		background-color : yellow;
		padding : 10px;
		text-align : center;
		width : 180px;
		height : 180px;
		border : 1px solid #8e8e8e;
		margin-left : 20px;
		list-style : none;
		margin-bottom : 15px;
	}
	textarea {
		margin-top : 5px;
		height : 100px;
	}
	#num{
		margin-left : 50px;
	}
	#goWrite{
		margin-top : 10px;
		margin-left : 20px;
	}
</style>
</head>
<body>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
	<h1 id = "bookTitle">방명록</h1>
	
	
	<c:if test = "${viewData.isEmpty()}">
	작성된 방명록 메세지가 없습니다.
	</c:if>
	<c:if test = "${!viewData.isEmpty()}">
		<c:forEach var = "message" items = "${viewData.messageList}">
		
		<ul id = "bookUl">
			<li>메시지 번호 : ${message.message_id} </li>
			<li>작성자 아이디 : ${message.userid_member} </li>
			<li>메시지 내용 : ${message.message}</li>
			<li><a href = "view?id=${message.message_id}">[상세보기]</a>
				<c:if test="${message.userid_member == loginInfo.userId}">
				<a href = "delete?id=${message.message_id}">[삭제하기]</a>
				</c:if></li>
		</ul>
		
		</c:forEach>
		
		<c:forEach var = "num" begin = "1" end = "${viewData.pageTotalCount}">
			<a href = "messageList?page=${num}" id = "num">[${num}]</a>
		</c:forEach>
	</c:if>
	<h2><a href = "write"  id = "goWrite">[방명록쓰기]</a></h2>
	
</body>
</html>