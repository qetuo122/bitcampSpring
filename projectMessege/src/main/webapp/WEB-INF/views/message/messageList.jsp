<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:if test="data == null">
	메세지가 없습니다.
</c:if>
<c:if test="data != null">
	<c:forEach var = "message" items = "${data}">
		<p>글  번호 : ${data.messageId}</p>
		<p>글  제목 : ${data.messageTitle}</p>
		<p>내    용 : ${data.messageCon}</p>
		<a href = "message/detail?messageId=${data.messageId}">[상세보기]</a>
		<a href = "message/delete?messageId=${data.messageId}">[삭제하기]</a>
	</c:forEach>
</c:if>

</body>
</html>