<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/default.css">
<style>
	#writeTitle {
		margin-top : 10px;
		margin-left : 20px;
		margin-bottom : 10px;
	}
	
	#writeForm {
		margin-left : 20px;
	}
	#userId, #userName{
		width : 300px;
		height : 20px;
		margin-bottom : 10px;
	}
	
	#message{
		width : 300px;
		height : 300px;
		margin-bottom : 10px;
	}
	#messageTitle{
		margin-right : 7px;
		float : left;
	}
	
</style>
</head>
<body>

<%@ include file="/WEB-INF/views/common/header.jsp" %>

<h1 id = "writeTitle">방명록 메세지 쓰기</h1>

	<form method="post" id = "writeForm">
		<div>아이디 : <input id = "userId" name="userId" value="${loginInfo.userId}" readonly/></div>
		<div>작성자 : <input id = "userName" name="userName" value = "${loginInfo.userName}" readonly/></div>
		<div><p id = "messageTitle"> 메시지 :</p><textarea id = "message" name="message" cols="30" row="3"></textarea></div>
		 
		<input type="submit" value="메시지 남기기" />
	</form>

</body>
</html>