<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	* {
		padding : 0px;
		margin : 0px;
	}
	#messageTitle{
		margin-top : 10px;
		margin-left : 20px;
		margin-bottom : 10px;
	}
	#wrap{
		position : relative;
		margin-left : 50px;
		margin-right : 50px;
	}
	#messageUlWrap{
		float : left;
	}
	#messageUl{
		background-color : #eee;
		padding : 10px;
		text-align : center;
		width : 180px;
		height : 180px;
		border : 2px solid #8e8e8e;
		margin-left : 20px;
		list-style : none;
		margin-bottom : 15px;
	}
	textarea {
		margin-top : 5px;
		margin-bottom : 5px;
		height : 100px;
	}
	#goWrite{
		margin-top : 10px;
		margin-left : 20px;
	}
	#messageBtn{
		color : white;
		background-color : black;
		border : 1px solid black;
		text-decoration : none;
		padding : 5px;
	}
	#messageBtn:hover {
	background-color: #8e8e8e;
	cursor: pointer;
}
	#detailDiv {
		width : 400px;
		height : 400px;
		background-color : white;
		position : absolute;
		border : 1px solid black;
		right : 100px;
	}
	#detailUl {
		list-style : none;
		padding : 30px;
	}
</style>
</head>
<body>
<h1 id = "messageTitle">방명록</h1>
<c:if test="${list == null}">
	메세지가 없습니다.
</c:if>

<c:if test="${list != null}">
<div id = "wrap">
	<c:forEach var = "message" items = "${list}" varStatus = "status">
		<div id = "messageUlWrap">	
		<ul id = "messageUl">
			<li>메시지 번호 : ${message.messageId} </li>
			<li>아이디 : ${message.userId} </li>
			<li><textarea readonly cols = "25">${message.messageCon}</textarea></li>
			<a href = "messageList?messageId=${message.messageId}" id = "messageBtn">상세보기</a>
			<a href = "delete?messageId=${message.messageId}" id = "messageBtn">삭제하기</a>
		</ul>
		</div>
		</c:forEach>
		</div>
</c:if>

<!-- 상세보기가 나오는 창 -->
 	<c:if test="${detail.messageId !=null}">
		<div id = "detailDiv">
		<ul id = "detailUl">
			<li>보낸 아이디 : ${detail.userId}</li>
			<li>메시지 번호 : ${detail.messageId}</li>
			<li>메시지 날짜 : ${detail.messageDate}</li>
			<li>메시지 제목 : ${detail.messageTitle}</li>
			<li><textarea readonly cols = "25">${message.messageCon}</textarea></li>
		</ul>
		</div>
	</c:if> 
	
	
</body>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script>
 /*$(document).ready(function(){
		$('#b').hide();
	});
//ajax로 버튼을 눌러서 처리하는 방법
	$('button[name="delete"]').click(function(){
		id = this.value;
		$.ajax({
			url : '/pc/message/delete?messageId=' + id
		});
			location.reload();
});
	$('button[name="detail"]').click(function(){
		id = this.value;
		$.ajax({
			url : '/pc/message/messageList?messageId=' + id
		});
		$('#b').show();
}); */
</script>
</html>