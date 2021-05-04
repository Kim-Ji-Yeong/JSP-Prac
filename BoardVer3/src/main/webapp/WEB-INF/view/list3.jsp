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
	border-collapse:collapse;
}
.record { cursor : pointer; }



</style>
</head>
<body>
	<div>
		<a href="/write3">글쓰기</a>
	</div>
	<div>
		l
		<table>
			<tr>
				<td>no</td>
				<td>제목</td>
				<td>작성일</td>
			<tr>
				<c:forEach items="${list}" var="item">
					<!--items에는 주소값 -->
					<tr onclick="moveToDetail(${item.iboard});">
						<!-- <td>${item.iboard}</td>
						<td>${item.title}</td>
						<td>${item.regdt}</td>
						 -->
						<td>${item.iboard}</td>
						<td>${item.title}</td>
						<td>${item.regdt}</td>


					</tr>
				</c:forEach>
		</table>
	</div>
	<script>
	function moveToDetail(iboard) {
		//console.log('iboard : %d', iboard);
		location.href = '/detail3?iboard=' + iboard;
							   //↓헷갈리니 이름 똑같이	
							   }
	</script>
</body>
</html>











