<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>개같은 jsp</title>
</head>
<body>
	<form action="/write" method="post">
		제목 : <input type="text" name="title">
		<div>
			내용 :
			<textarea name="ctnt"></textarea>
		</div>
		<input type = "submit" value = "등록">
		<input type = "reset" value = "초기화">
		<a href = "/list">돌아가기</a>
	</form>
</body>
</html>