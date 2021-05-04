<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>개빡쳐</h1>
	<div>
		<a href="/del3?iboard=${param.iboard}">삭제</a>
		<a href = "/mod3?iboard=${param.iboard}">수정</a>
	</div>
	<div><a href ="/list3">리스트</a></div>
	<div>제목 : ${data.title}</div>
	<div>내용 : ${data.ctnt}</div>
</body>
</html> 