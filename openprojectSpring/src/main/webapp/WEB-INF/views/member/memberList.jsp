<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../css/default.css">
<title>Insert title here</title>
<style>
	table, td {
		border : 1px solid black;
		border-collapse : collapse;
		text-align : center;
	}
	table {
		width : 800px;
	}
	
	td {
		height : 70px;
	}
	#photo {
	 height : 150px;
	}
	#listTitle{
		margin-top : 10px;
		margin-left : 20px;
		margin-bottom : 20px;
	}
	#listTable{
		margin-left : 20px;
	}
</style>
</head>
<body>
<%@ include file="/WEB-INF/views/common/header.jsp" %>

<h1 id = "listTitle">회원 리스트</h1>
	
	<table id = "listTable">
		<tr>
			<td>회원 아이디</td>
			<td>회원 비밀번호</td>
			<td>회원 이름</td>
			<td>회원 사진</td>
			<td>회원 관리</td>
		</tr>
	<c:if test = "${members == null}">
	등록된 회원이 없습니다.
	</c:if>
	<c:if test = "${members != null}">
		<c:forEach var = "member" items = "${members}">
			<tr>			
				<td>${member.userId}</td>
				<td>${member.password}</td>
				<td>${member.userName}</td>
				<td><img src = "<%= request.getContextPath()%>/uploadfile/userphoto/${member.userPhoto}" id = "photo"></td>
					<c:if test = "${member.userId == loginInfo.userId}">
					<td><a href = "modify?id=${member.userId}">[수정하기]</a>
					    <a href = "delete?id=${member.userId}">[삭제하기]</a></td>
					</c:if>
					<c:if test = "${member.userId != loginInfo.userId}">
					<td></td>
					</c:if>
			</tr>
		</c:forEach>
	</c:if>
	</table>

</body>
</html>