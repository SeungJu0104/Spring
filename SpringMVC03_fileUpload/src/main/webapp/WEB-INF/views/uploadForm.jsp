<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UploadForm</title>
</head>
<body>
<!-- 
	 form 태그 라이브러리
	 : 스프링에 있는 태그 라이브러리 중 하나
	 : 데이터 바인딩이나 에러메세지 처리를 간편하게 할 수 있다.
 -->
 	<form:form method="post" action="upload" enctype="multipart/form-data" modelAttribute="uploadFile"><!-- html의 form 태그 사용하겠다. -->
 	<!-- form:form은 form태그 라이브러리 내에서 html의 form 태그를 사용하겠다. -->
 	<!-- method는 전송 방식, action은 어디로, enctype은 어떤 타입으로, modelAttribute는 어떤 속성에 담을 것인가 -->
 	<!-- multipart는 다양한 타입의 데이터를 전송할 수 있다. -->
 	
 		<h3>업로드할 파일 선택</h3>
 		파일 : <input type="file" name="file"><br>
 		<p style="color:red; font-weight:bold;">
 			<form:errors path="file"/><!-- form:errors는 form태그 라이브러리 내에서 errors라는 태그 사용한다. -->
 			<!-- path는 유효성 검사하고 그 결과를 에러 메세지에 띄워주는 속성 -->
 			<!-- BindingResult result에 저장된 에러 메세지가 나온다. -->
 			<!-- form:erros path="file"은 input 태그의 file이다. -->
 		</p>
 		
 		<br>
 		설명 : <br>
 		<textarea rows="10" cols="40" name="desc"></textarea>
 		<br>
 		<input type="submit" value="전송">
 	</form:form>

</body>
</html>