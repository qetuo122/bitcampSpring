<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../css/default.css">
<title>Insert title here</title>
<style>

	#messageDetail{
		margin-top : 10px;
		margin-left : 20px;
		margin-bottom : 10px;
	}
	#bookUl{
		margin-left : 20px;
		list-style : none;
		margin-bottom : 15px;
	}
	#goList{
		margin-left : 20px;
	}
</style>
</head>
<body>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<h1 id = "messageDetail">메시지 상세목록</h1>
	<ul id = "bookUl">
			<li>메시지 번호 : ${id} </li>
			<li>작성자 아이디 : ${userid_member} </li>
			<li>메시지 내용 : ${message}</li>
		</ul>
	<h2><a href = "messageList" id = "goList">메시지 리스트 보기</a></h2>
</body>
</html>