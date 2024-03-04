<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVCRegister</title>
</head>
<body>
<h1>회원가입</h1>

<form action="register.do" method="post">
	<table>
		<tr>
			<th>I D</th>
			<td><input type="text" name="memberid"></td>
		</tr>
		<tr>
			<th>P W</th>
			<td><input type="password" name="memberpw"></td>
		</tr>
		<tr>
			<th>이 름</th>
			<td><input type="text" name="membername"></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="회원가입">
				<input type="button" value="취소" onclick="history.back();">
			</td>
		</tr>
	</table>
</form>

</body>
</html>