<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVCInsert</title>
</head>
<body>
	<h1>insert</h1>
	<form action="insertres.do" method="post">
		<input type="hidden" name="myno" value="0">
		<!-- 프로젝트의 문제로 원래는 굳이 myno 안넘겨도 잘 작동해야하지만
			 myno 없으면 dto 객체에 담아 컨트롤러로 넘겨주는 과정에서 뭔가 문제가 생겨 부득이하게 hidden으로 작성해서 넘겨줬다. -->
		<table border="1">
			<tr>
				<th>작성자</th>
				<td><input type="text" name="myname"></td>
			</tr>
			<tr>
				<th>제 목</th>
				<td><input type="text" name="mytitle"></td>
			</tr>
			<tr>
				<th>내 용</th>
				<td><textarea cols="40" rows="10" name="mycontent"></textarea></td>
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