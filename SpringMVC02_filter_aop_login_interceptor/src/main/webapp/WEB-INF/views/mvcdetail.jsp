<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>detail</h1>
	<table border="1">
		<tr>
			<th>작성자</th>
			<td>${dto.myname }</td>
		</tr>
		<tr>
			<th>제 목</th>
			<td>${dto.mytitle }</td>
		</tr>
		<tr>
			<th>내 용</th>
			<td><textarea rows="10" cols="40" readonly="readonly">${dto.mycontent }</textarea></td>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<input type="button" value="목록" onclick="location.href='list.do'">
				<input type="button" value="수정" onclick="location.href='updateform.do?myno=${dto.myno}'">
				<!-- 수정할 자료에 대한 myno 또한 같이 DispatcherServlet 거쳐 컨트롤러로 보내준다. -->
				<input type="button" value="삭제" onclick="location.href='delete.do?myno=${dto.myno}'">
				<!-- 삭제할 자료에 대한 myno 또한 같이 DispatcherServlet 거쳐 컨트롤러로 보내준다. -->
			</td>
		</tr>
	</table>
</body>
</html>