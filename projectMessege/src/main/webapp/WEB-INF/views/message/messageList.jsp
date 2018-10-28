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
		border : 1px solid #8e8e8e;
		margin-left : 20px;
		list-style : none;
		margin-bottom : 15px;
		border-radius : 10px;
	}
	#messageUl textarea {
		padding : 10px;
		margin-top : 5px;
		margin-bottom : 5px;
		height : 80px;
		border-radius : 5px;
	}
	#messageUl li {
		font-size : 15px;
		font-weight : bold;
	}
	#messageBtn{
		font-size : 13px;
		color : white;
		background-color : black;
		border : 1px solid black;
		text-decoration : none;
		padding : 5px;
		border-radius : 5px;
	}
	#messageBtn:hover {
	background-color: #8e8e8e;
	cursor: pointer;
}
	#detailDiv {
		width : 400px;
		height : 470px;
		background-color : white;
		position : absolute;
		border : 1px solid black;
		right : 100px;
		border-radius : 10px;
	}
	#detailUl {
		list-style : none;
		padding : 30px;
	}
	#detailUl li {
		font-weight : bold;
	}
	#detailUl input[type=text] {
		margin-bottom : 10px;
		width : 210px;
		height : 30px;
		border : none;
		padding : 6px 12px 6px 12px;
		background-color : #eee;
		font-weight : bold;
		border-radius : 7px;
	}
	#detailUl textarea {
		height : 130px;
		font-size : 20px;
		padding : 15px;
		border-radius : 7px;
	}
	#detailFoot {
		margin-top : 5px;
		text-align : center;
	}
	#detailDel, #detailClose{
		margin : 5px 20px 0px 20px;
		color : white;
		border : none;
		background-color : black;
		text-decoration : none;
		border-radius : 7px;
	}
	#detailDel{
		padding : 10px;
	}
	#detailClose{
		width : 83px;
		height : 41.6px;
		font-size : 15px;
		padding : 11px;
	}
	#detailDel:hover, #detailClose:hover {
	background-color: #8e8e8e;
	cursor: pointer;
}
</style>
</head>
<body>
<h1 id = "messageTitle">메시지 리스트</h1>
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
			<li><textarea readonly cols = "20">${message.messageCon}</textarea></li>
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
			<li>메시지 번호 : <input type = "text" value = "${detail.messageId}" readonly></li>
			<li>보낸 아이디 : <input type = "text" value = "${detail.userId}" readonly></li>
			<li>메시지 날짜 : <input type = "text" value = "${detail.messageDate}" readonly></li>
			<li>메시지 제목 : <input type = "text" value = "${detail.messageTitle}" readonly></li>
			<li><textarea readonly cols = "28"> ${detail.messageCon}</textarea></li>
			<div id = "detailFoot"><a href = "delete?messageId=${detail.messageId}" id = "detailDel">삭제하기</a>
			<input type = "button" value = "닫기" id = "detailClose"></div>
		</ul>
		</div>
	</c:if> 
	
	
</body>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>

<script>
		
	$(document).ready(function(){
		$('#detailClose').click(function(){
			$('#detailDiv').hide();
		});
	
		$('#messageUl').click(function(){
			$(this).css('background-color', 'gray');
		});
		/* $('#detailDiv').dragable({
			grid : [102, 102]
		}); */
	});
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