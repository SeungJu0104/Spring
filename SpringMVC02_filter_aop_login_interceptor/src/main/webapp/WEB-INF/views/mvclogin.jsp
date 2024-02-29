<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVCLogin</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script type="text/javascript">
	$(function (){
		$("#loginChk").hide(); // id가 loginChk인 td태그 숨김 처리
	
	});
	
	function login(){
		let memberid = $("#memberid").val().trim(); // id가 memberid인 태그 value 가져와서 공백 없앤다.
		let memberpw = $("#memberpw").val().trim();
		let loginVal = {"memberid":memberid, "memberpw":memberpw} // key:value 형태 -> JSON 데이터 형식
		console.log(loginVal); // 아이디 비밀번호 저장 확인용
		
		if(memberid == null || memberid == "" || memberpw == null || memberpw == ""){
			// id 또는 pw 가 공백이거나 null인 경우
			alert("ID 또는 PW를 입력해주세요.");
		}else{
			$.ajax({
				url: "ajaxlogin.do",// 어디로 보낼 것인가 (모든 요청은 DispatcherServlet을 거쳐간다.)
				type: "post", // post 방식으로 전송
				data: JSON.stringify(loginVal), // 서버로 보낼 데이터. stringify는 JSON 데이터를 String으로 변환
				contentType:"application/json", // 서버로 보내는 데이터의 타입
				dataType:"json", // 서버에서 반환되는 데이터 타입
				success: function(msg){ // 서버와 통신 성공 시
					// 받은 데이터는 msg에 담긴다. 타입은 json
					if(msg.check == true){ // 프론트엔드에서는 이름이용해 value에 접근할 수 있다. 그래서 msg.check의 value는 true 또는 false 중 하나
						location.href="list.do";
					}else{
						$("#loginChk").show(); // 숨겨놓은 td 태그 다시 보여준다.
						$("#loginChk").html("<b>ID 혹은 PW를 다시 입력해주세요.</b>"); // 텍스트 출력(태그 읽는다.)
					}
				},
				error: function(){ // 서버와 통신 실패 시
					alert("통신 실패");
				}
			});
		}
	
	}
	
	

</script>
</head>
<body>
		<table>
			<tr>
				<th>ID</th>
				<td><input type="text" id="memberid"></td>
			</tr>
			<tr>
				<th>PW</th>
				<td><input type="password" id="memberpw"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="button" value="login" onclick="login();"></td>
			</tr>
			<tr>
				<td colspan="2" align="center" id="loginChk"></td>
			</tr>
		</table>
</body>
</html>