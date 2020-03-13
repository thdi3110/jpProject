<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이메일 인증</title>
<script src="//code.jquery.com/jquery-2.2.4.min.js"></script>
</head>
<body>
	<h1>이메일 인증</h1>
	<hr>
	<form id="emailChk" name="emailChk"
		action="${pageContext.request.contextPath}/member/emailAuthentication"
		method="post">
		<table>
			<tbody>
				<tr>
					<td>인증번호</td>
					<td><input type="text" id="MEMAILCHECK" name="MEMAILCHECK"></td>	
					<td><input type="button" id="check" value="이메일체크"></td>				
				</tr>
				<tr>
					<td colspan=3 id="msg"></td>
				</tr>
				<tr>
					<td colspan="3"><input type="button" id="signUp" value="회원가입"></td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
<script type="text/javascript">
	$(document).ready(function(e){
		var emailckx = false;
		$('#signUp').click(function(){	
			if($.trim($('#MEMAILCHECK').val()) == ''){
				alert("인증코드를 입력해주세요.");
				$('#MEMAILCHECK').focus();
				return;
			}
			if(emailckx==false){
				alert("이메일체크를 클릭해주세요.");
				return;
			}else{
				$('#emailChk').submit();
			} 
		});
		
		$('#check').click(function(){
			$.ajax({
				url: "${pageContext.request.contextPath}/member/emailCheck",
				type: "POST",
				data:{
					"MEMAILCHECK":$('#MEMAILCHECK').val()
				},
				success: function(data){
					if(data == 0 && $.trim($('#MEMAILCHECK').val()) != '' ){						
						var html="<tr><td colspan='3' style='color: red'>인증번호가 틀립니다.</td></tr>";
						$('#msg').empty();
						$('#msg').append(html);
					}else if($.trim($('#MEMAILCHECK').val()) == '' ){						
						var html="<tr><td colspan='3' style='color: red'>인증정보가 없습니다.</td></tr>";
						$('#msg').empty();
						$('#msg').append(html);
					}else{
						emailckx = true
						$('#MEMAILCHECK').attr("readonly",true);
						var html="<tr><td colspan='3' style='color: green'>확인되었습니다.</td></tr>";
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