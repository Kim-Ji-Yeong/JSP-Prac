<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="/write">jsp .....</a>
	<table>
		<tr>
			<td>no</td>
			<td>제목</td>
			<td>작성일</td>
		</tr>
		<c:forEach items = "${list}" var = "item">
		<tr onclick = "move(${item.iboard})">
		<td>${item.iboard}</td>
		<td>${item.title}</td>
		<td>${item.regdt}</td>
		
		</tr>
		</c:forEach>
	</table>
	<script>function move(iboard){
		location.href ='/detail?iboard=' + iboard;
	}</script>
</body>
</html>