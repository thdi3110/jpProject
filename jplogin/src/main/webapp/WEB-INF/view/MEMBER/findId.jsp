<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  	    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기</title>
<script src="//code.jquery.com/jquery-2.2.4.min.js"></script>
</head>
<body>
	<h1>아이디 찾기</h1>
	<hr>
	<form id="findId" name="findId"
		action="${pageContext.request.contextPath}/member/findId"
		method="post">
		<table>
			<tbody>
				<tr>
					<td>이메일</td>
					<td><input type="text" id="MEMAIL" name="MEMAIL"></td>	
					<td><input type="button" id="check" value="이메일체크"></td>				
				</tr>
				<tr>
					<td colspan=3 id="msg"></td>
				</tr>
				<tr>
					<td colspan="3"><input type="button" id="findIdButton" value="아이디 찾기"></td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
<script type="text/javascript">
	$(document).ready(function(e){
		
		var emailchk = false;		
		var emailRegExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
		
		$('#findIdButton').click(function(){	
			if($.trim($('#MEMAIL').val()) == ''){
				alert("이메일 입력해주세요.");
				$('#MEMAIL').focus();
				return;
			}else if(!emailRegExp.test($('#MEMAIL').val())){					
				alert("이메일형식에 맞추어 주세요.");
				$('#MEMAIL').focus();
				return;			
			}
			
			 if(emailchk==false){
				alert("이메일체크를 해주세요");
				return;
			}else{
				$('#findId').submit();
			} 
		});		
		
		$('#check').click(function(){
			$.ajax({
				url: "${pageContext.request.contextPath}/member/findIdEmailCheck",
				type: "POST",
				data:{
					"MEMAIL":$('#MEMAIL').val()
				},
				success: function(data){
					if(data == 1 && $.trim($('#MEMAIL').val()) != '' ){
						emailchk=true;
						$('#MEMAIL').attr("readonly",true);
						var html="<tr><td colspan='3' style='color: green'>확인되었습니다.</td></tr>";
						$('#msg').empty();
						$('#msg').append(html);
						
					}else{
						var html="<tr><td colspan='3' style='color: red'>등록된 이메일이 없습니다.</td></tr>";
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