<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  	    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기</title>
<script src="//code.jquery.com/jquery-2.2.4.min.js"></script>
</head>
<body>
	<h1>비밀번호 찾기</h1>
	<hr>
	<form id="findPassword" name="findPassword"
		action="${pageContext.request.contextPath}/member/findPassword"
		method="post">
		<table>
			<tbody>
				<tr>
					<td>아이디</td>
					<td><input type="text" id="MID" name="MID"></td>								
				</tr>
				<tr>
					<td>이메일</td>
					<td><input type="text" id="MEMAIL" name="MEMAIL"></td>								
				</tr>
				<tr>
					<td colspan=3 id="msg"></td>
				</tr>
				<tr>
					<td colspan="3"><input type="button" id="findPasswordButton" value="비밀번호 찾기"></td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
<script type="text/javascript">
	$(document).ready(function(e){
		
		var chk = false;		
		var emailRegExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
		
		$('#findPasswordButton').click(function(){	
			if($.trim($('#MID').val()) == ''){
				alert("아이디 입력해주세요.");
				$('#MID').focus();
				return;
			}else if($.trim($('#MEMAIL').val()) == ''){
				alert("이메일 입력해주세요.");
				$('#MEMAIL').focus();
				return;
			}else if(!emailRegExp.test($('#MEMAIL').val())){					
				alert("이메일형식에 맞추어 주세요.");
				$('#MEMAIL').focus();
				return;			
			}				 
			
			$.ajax({
				url: "${pageContext.request.contextPath}/member/findPasswordCheck",
				type: "POST",
				data:{
					"MID":$('#MID').val(),
					"MEMAIL":$('#MEMAIL').val()
				},
				success: function(data){
					if(data == 1 && $.trim($('#MID').val()) != '' && $.trim($('#MEMAIL').val()) != '' ){
						chk=true;
						$('#MID').attr("readonly",true);
						$('#MEMAIL').attr("readonly",true);
						var html="<tr><td colspan='3' style='color: green'>임시비밀번호가 등록된 이메일로 전송되었습니다.</td></tr>";
						$('#msg').empty();
						$('#msg').append(html);
						$('#findPassword').submit()						
					}else{						
						var html="<tr><td colspan='3' style='color: red'>등록된 아아디 또는 이메일이 없습니다.</td></tr>";
						$('#msg').empty();
						$('#msg').append(html);
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