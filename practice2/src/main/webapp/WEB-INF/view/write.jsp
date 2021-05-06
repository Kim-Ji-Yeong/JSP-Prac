<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>그만하고 싶어</title>
</head>
<body>
<div>
<form action = "/write" method = "post">
제목 : <input type = "text" name = "title">
<div>
내용 : <textarea name = "ctnt" rows="20" cols="20"></textarea>
</div>
<input type = "submit" value = "등록">
<input type =  "reset">
</form>
</div>
</body>
</html>