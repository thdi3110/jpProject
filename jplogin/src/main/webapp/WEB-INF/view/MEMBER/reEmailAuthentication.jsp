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
		action="${pageContext.request.contextPath}/member/reEmailAuthentication"
		method="post">
		<table>
			<tbody>
				<tr>
					<td>아이디</td>
					<td><input type="text" id="MID" name="MID"></td>	
					<td><input type="button" id="sendEmail" value="이메일 발송"></td>				
				</tr>
				<tr>
					<td colspan=3 id="msg"></td>
				</tr></br></br>
				<tr>
					<td>인증번호</td>					
					<td><input type="text" id="MEMAILCHECK" name="MEMAILCHECK"></td>	
					<td><input type="button" id="check" value="인증번호 확인"></td>				
				</tr>
				<tr>
					<td colspan=3 id="msg1"></td>
				</tr>
				<tr>
					<td colspan="3"><input type="button" id="reEmail" value="이메일 인증"></td>
				</tr>				
			</tbody>
		</table>
	</form>
</body>
<script type="text/javascript">
	$(document).ready(function(e){
		var emailckx = false;
		var idckx = false;
		$('#reEmail').click(function(){	
			if($.trim($('#MID').val()) == ''){
				alert("아이디를 입력해주세요.");
				$('#MID').focus();
				return;
			}else if($.trim($('#MEMAILCHECK').val()) == ''){
				alert("인증코드를 입력해주세요.");
				$('#MEMAILCHECK').focus();
				return;
			}
			
			if(idchx==false){
				alert("이메일 발송을 클릭해주세요.");
				return;
			}else if(emailckx==false){
				alert("인증번호 확인을 클릭해주세요.");
				return;
			}else{
				$('#emailChk').submit();
			} 
		});
		
		$('#sendEmail').click(function(){
			$.ajax({
				url: "${pageContext.request.contextPath}/member/sendEmail",
				type: "POST",
				data:{
					"MID":$('#MID').val()
				},
				success: function(data){
					if(data == 1 && $.trim($('#MID').val()) != ''){
						idchx = true
						$('#MID').attr("readonly",true);
						var html="<tr><td colspan='3' style='color: green'>이메일이 발송되었습니다.</td></tr>";
						$('#msg').empty();
						$('#msg').append(html);
					
					}else if(data == 0 && $.trim($('#MID').val()) != '' ){						
						var html="<tr><td colspan='3' style='color: red'>해당아이디가 없습니다.</td></tr>";
						$('#msg').empty();
						$('#msg').append(html);
					}else if(data == null && $.trim($('#MID').val()) != ''){
						var html="<tr><td colspan='3' style='color: red'>아이디를 입력해주세요.</td></tr>";
						$('#msg').empty();
						$('#msg').append(html);
					}else if(data == 2 && $.trim($('#MID').val()) != ''){
						var html="<tr><td colspan='3' style='color: red'>인증된 회원입니다.</td></tr>";
						$('#msg').empty();
						$('#msg').append(html);
					}
				},
				error: function(){
					alert("서버에러");
				}
			});
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
						$('#msg1').empty();
						$('#msg1').append(html);
					}else if($.trim($('#MEMAILCHECK').val()) == '' ){						
						var html="<tr><td colspan='3' style='color: red'>인증정보가 없습니다.</td></tr>";
						$('#msg1').empty();
						$('#msg1').append(html);
					}else{
						emailckx = true
						$('#MEMAILCHECK').attr("readonly",true);
						var html="<tr><td colspan='3' style='color: green'>확인되었습니다.</td></tr>";
						$('#msg1').empty();
						$('#msg1').append(html);
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