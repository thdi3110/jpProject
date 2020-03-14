<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<script src="//code.jquery.com/jquery-2.2.4.min.js"></script>
</head>
<body>
	<h1>로그인</h1>
	<hr>
	<form id="loginFrm" name="loginFrm"
		action="${pageContext.request.contextPath}/member/login" method="post">
		<table>
			<tbody>
				<tr>
					<td>아이디</td>
					<td><input type="text" id="MID" name="MID"></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" id="MPASSWORD" name="MPASSWORD"></td>
				</tr>
				<tr>
					<td colspan=3 id="loginCheck"></td>
				</tr>
				<tr>
					<td colspan="3"><input type="button" id="loginUp" value="로그인"></td>
				</tr>
			</tbody>
		</table>
	</form>
	<a href = "<c:url value="/member/reEmailAuthentication"/>">이메일 인증</a><br/><br/>
	<a href = "<c:url value="/member/findId"/>">아이디 찾기</a><br/><br/>
	<a href = "<c:url value="/member/findPassword"/>">비밀번호 찾기</a><br/><br/>
</body>
<script type="text/javascript">
$(document).ready(function(e){
	
	var idx = false;
	
	$('#loginUp').click(function(){	
		if($.trim($('#MID').val()) == ''){
			alert("아이디 입력해주세요.");
			$('#MID').focus();
			return;
		}else if($.trim($('#MPASSWORD').val()) == ''){
			alert("패스워드 입력해주세요.");
			$('#MPASSWORD').focus();
			return;
		}	
	
		$.ajax({
			url: "${pageContext.request.contextPath}/member/login",
			type: "POST",
			data:{
				"MID":$('#MID').val(),
				"MPASSWORD":$('#MPASSWORD').val()
			},
			success: function(data){
				if(data == 0 && $.trim($('#MID').val()) != '' && $.trim($('#MPASSWORD').val()) != ''){						
					var html="<tr><td colspan='3' style='color: red'>아이디나 비밀번호가 틀립니다.</td></tr>";
					$('#loginCheck').empty();
					$('#loginCheck').append(html);
				}else if(data == 1 && $.trim($('#MID').val()) != '' && $.trim($('#MPASSWORD').val()) != ''){
					var html="<tr><td colspan='3' style='color: red'>이메일 인증을 해주세요.</td></tr>";
					$('#loginCheck').empty();
					$('#loginCheck').append(html);
				}else{
					$('#loginFrm').submit();
				}
			},
			error: function(){
				alert("서버에러");
			}
		});
		

	});
	
});
</script>
</html>