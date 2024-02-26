<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVCUpdate</title>
</head>
<body>

	<form action="updateres.do" method="post">
		<input type="hidden" name="myno" value="${dto.myno }">
		<!-- db에서 넘겨준 데이터가 몇 열에 위치한 데이터인지 확인위한 기본키 myno도 같이 넘겨준다. -->
		<table border="1">
			<tr>
				<th>작성자</th>
				<td>${dto.myname }</td>
			</tr>
			<tr>
				<th>제 목</th>
				<td><input type="text" name="mytitle" value="${dto.mytitle }"></td>
			</tr>
			<tr>
				<th>내 용</th>
				<td><textarea cols="40" rows="10" name="mycontent">${dto.mycontent }</textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input type="submit" value="완료">
					<input type="button" value="취소" onclick="location.href='list.do'">
				</td>
			</tr>
		</table>
	</form>

</body>
</html>