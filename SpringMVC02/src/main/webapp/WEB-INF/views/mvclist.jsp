<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVCList</title>
</head>
<body>
	<h1>list</h1>
	
	<table border="1">
		<colgroup>
			<col width="50"/><col width="100"/><col width="300"/><col width="100"/>
		</colgroup>
		<tr>
			<th>번 호</th>
			<th>작성자</th>
			<th>제 목</th>
			<th>작성일</th>
		</tr>
		<c:choose>
			<c:when test="${empty list }">
			<!-- 넘겨받은 model 객체에 저장된 list 속성이 비었을 때 -->
				<tr>
					<td colspan="4" align="center">------작성된 글이 없습니다.------</td>
				</tr>
			</c:when>
			<c:otherwise>
			<!-- 넘겨받은 model 객체에 저장된 list 속성이 비어있지 않다면 -->
				<c:forEach var="dto" items="${list }">
				<!-- 향상된 for문과 동일 개념 -->
					<tr>
						<td>${dto.myno }</td>
						<td>${dto.myname }</td>
						<td><a href="detail.do?myno=${dto.myno }">${dto.mytitle }</a></td>
						<!-- 클릭하면 dto.myno를 파라미터=value 형태로 url에 담아 넘긴다. -->
						<td>${dto.mydate }</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
		<tr>
			<td colspan="4" align="right">
				<input type="button" value="글 작성" onclick="location.href='insertform.do'">
			</td>
		</tr>
	</table>

</body>
</html>