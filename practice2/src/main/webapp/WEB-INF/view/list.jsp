<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- ctrl +  space -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리스트</title>
<style>
table, tr, td {
	border: 1px solid black;
	border-collapse: collapse;
}

.record {
	cursor: pointer;
}
</style>
</head>
<body>
	<table>
		<tr>
			<td>no</td>
			<td>제목</td>
			<td>작성일</td>
			</tr>
			<tr>
			<td>
			<c:forEach items="${list}" var ="itme">
			<tr onclick="move(${item.board});">
			<td>${item.board}</td>
			<td>${item.title}</td>
			<td>${item.ctnt}</td>
			</tr>
			</c:forEach>
	</table>
	<script>
	function move(iboard) {location.href = '/detail?iboard=' + iboard"}</script>
	
</body>
</html>
