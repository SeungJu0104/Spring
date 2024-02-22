<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GetCommand</title>
</head>
<body>
	<h1>GET</h1>
	
	<table>
		<tr>
			<th>name</th>
			<th>addr</th>
			<th>phone</th>
		</tr>
		<tr>
			<td>${dto.name }</td>
			<td>${dto.addr }</td>
			<td>${dto.phone }</td>
		</tr>
	</table>

</body>
</html>