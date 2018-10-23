<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/default.css">
<style>
h2, td {
	padding: 10px;
}
</style>
</head>
<body>

	<%@ include file="/WEB-INF/views/common/header.jsp"%>


	<div id="contents">

		<h2>회원수정</h2>

		<hr>
		<form method="post" enctype = "multipart/form-data">
			<table>
				<tr>
					<td>아이디(이메일)</td>
					<td><input type="text" name="userId" value = "${modiId}" readonly></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="password" value = "${modiPwd}"></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="userName" value = "${modiName}"></td>
				</tr>
				<tr>
					<td>사진</td>
					<td><input type="file" name="PhotoFile" value = "${modiPhoto}"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit"></td>
				</tr>
			</table>

		</form>



	</div>











</body>
</html>