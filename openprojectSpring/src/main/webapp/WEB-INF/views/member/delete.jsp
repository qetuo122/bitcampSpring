<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../css/default.css">
<title>Insert title here</title>
</head>
<body>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<h1> 회원 탈퇴 </h1>
	<form method="post">
		<input type="hidden" name="userId" value="${id}" /> 
		회원을 탈퇴하시려면 암호를 입력하세요:<br /> 
		암호: <input type="password" name="password" /> <br /> 
		<input type="submit" value="회원탈퇴하기" />
	</form>
</body>
</html>