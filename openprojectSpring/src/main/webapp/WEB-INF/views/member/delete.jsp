<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1> ���� Ȯ�� </h1>
	<form method="post">
		<input type="hidden" name="userId" value="${id}" /> 
		���̵� �����Ͻ÷��� ��ȣ�� �Է��ϼ���:<br /> 
		��ȣ: <input type="password" name="password" /> <br /> 
		<input type="submit" value="�޽��� �����ϱ�" />
	</form>
</body>
</html>