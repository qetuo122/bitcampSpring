<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<p>쪽지번호 : ${data.messageId}</p>
	<p>쪽지제목 : ${data.messageTitle}</p>
	<p>쪽지내용 : ${data.messageCon}</p>
	<p>보낸사람 : ${data.userId}</p>
	<p>작성날짜 : ${data.messageDate}</p>

</body>
</html>