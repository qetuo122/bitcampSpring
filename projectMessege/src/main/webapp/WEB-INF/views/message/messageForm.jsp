<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form method = "post">
<%-- <!-- 관리자로 로그인 했을경우 -->
<c:if test = "${memberInfo.userId == adminId}">
<input type = "text" name = "adminId" value = "${adminId}">
<input type = "hidden" name = "userId" value = "${memberInfo.userId}">
</c:if> --%>

<!-- 일반회원으로 로그인 했을경우 -->
<c:if test = "${memberInfo.userId != adminId}">
<input type = "hidden" name = "adminId" value = "admin">
<input type = "text" name = "id" value = "${memberInfo.userId}">
</c:if>
<input type = "text" name = "messageTitle"><br>
<textarea name = "messageCon"></textarea><br>
<input type = "submit" value = "보내기"> <br>

</form>
</body>
</html>