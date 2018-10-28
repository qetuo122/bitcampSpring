<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<a href = "<%= request.getContextPath() %>/message/messageForm">메세지 쓰기</a>
<a href = "<%= request.getContextPath() %>/message/messageList">메세지 리스트</a>

</body>
</html>
