<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일반회원</title>
<script src="//code.jquery.com/jquery-2.2.4.min.js"></script>
</head>
<body>
	<h1>회원가입</h1>
	<hr>
	<form id="signFrm" name="signFrm" action="${pageContext.request.contextPath}/member/writeNormal" method="post">
		<table>
			<tbody>
				<tr>
					<td>아이디</td>
					<td><input type="text" id="MID" name="MID" ></td>
					<td><input type="button" id="Check" value="아이디 중복체크"></td>
				</tr>
				<tr>
					<td colspan=3 id="idCheck"></td>
				</tr>
				<tr>
					<td>이름</td>
					<td colspan="2"><input id="MNAME" name="MNAME" type="text"></td>
				</tr>
				<tr>
					<td>패스워드</td>
					<td colspan="2"><input id="MPASSWORD" name="MPASSWORD" placeholder = "숫자와문자포함6~12자리 " type="password"></td>
				</tr>
				<tr>
					<td>패스워드 확인</td>
					<td colspan="2"><input id="passwordCheck" name="passwordCheck" type="password"></td>
				</tr>
				<tr>
					<td>이메일</td>
					<td><input id="MEMAIL" name="MEMAIL" placeholder = "이메일형식" type="email" required></td>
					<td><input type="button" id="emailCheck" value="이메일 중복체크"></td>
				</tr>
				<tr>
					<td colspan=3 id="msg"></td>
				</tr>
				<tr>
					<td>주소</td>
					<td colspan="2"><input id="MADDRESS" name="MADDRESS" type="text"></td>
				</tr>
				<tr>
					<td>핸드폰번호</td>
					<td colspan="2">
					<select id = "phnum" name = "phnum">
					<option value = "010">010</option>
					<option value = "016">016</option> 
					<option value = "017">017</option>
					<option value = "019">019</option>
					</select>
					<input id="MPHONE" name="MPHONE" placeholder = "1010-1010" type="text"></td>
				</tr>
				<tr>
					<td>계좌번호(선택)</td>
					<td colspan="2">
					<select id = "MBCODE" name = "MBCODE">
					<option value = "NULL">없음</option>					
					<option value = "B1">우리은행</option>
					<option value = "B2">국민은행</option>
					<option value = "B3">신한은행</option>
					<option value = "B4">하나은행</option>
					<option value = "B5">케이뱅크</option>
					<option value = "B6">카카오뱅크</option>
					<option value = "B7">KDB산업은행</option>
					<option value = "B8">IBK기업은행</option>
					<option value = "B9">회원수협</option>
					<option value = "B10">농-축협</option>
					<option value = "B11">산림조합</option>
					<option value = "B12">새마을금고</option>
					<option value = "B13">신용협동조합</option>			
					<option value = "B14">대구은행</option>
					<option value = "B15">부산은행</option>
					<option value = "B16">경남은행</option>
					<option value = "B17">광주은행</option>
					<option value = "B18">전북은행</option>
					<option value = "B19">제주은행</option>
					</select>					
					<input id="MACCOUNT" name="MACCOUNT" type="text"></td>
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
		
		var idx = false;
		var emailx = false;
		var passwordRegExp = /^[A-Za-z0-9]{6,12}$/;
		var emailRegExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
		var phoneRegExp = /^\d{3,4}-\d{4}$/;

		
		$('#signUp').click(function(){	
			if($.trim($('#MID').val()) == ''){
				alert("아이디 입력해주세요.");
				$('#MID').focus();
				return;
			}else if($.trim($('#MNAME').val()) == ''){
				alert("이름 입력해주세요.");
				$('#MNAME').focus();
				return;				
			}else if($.trim($('#MPASSWORD').val()) == ''){
				alert("패스워드 입력해주세요.");
				$('#MPASSWORD').focus();
				return;
			}else if(!passwordRegExp.test($('#MPASSWORD').val())){					
				alert("숫자와 문자 포함 형태의 6~12자리 이내의 비밀번호를 입력해주세요.");
				$('#MPASSWORD').focus();
				return;
			}
			else if($('#MPASSWORD').val() != $('#passwordCheck').val()){
				alert('패스워드가 다릅니다.');
				$('#passwordCheck').focus();
				return;
			}else if($.trim($('#MEMAIL').val()) == ''){
				alert("이메일 입력해주세요.");
				$('#MEMAIL').focus();
				return;
			}else if(!emailRegExp.test($('#MEMAIL').val())){					
				alert("이메일형식에 맞추어 주세요.");
				$('#MEMAIL').focus();
				return;
			}else if($.trim($('#MADDRESS').val()) == ''){
				alert("주소 입력해주세요.");
				$('#MADDRESS').focus();
				return;
			}else if($.trim($('#MPHONE').val()) == ''){
				alert("핸드폰 입력해주세요.");
				$('#MPHONE').focus();
				return;
			}else if(!phoneRegExp.test($('#MPHONE').val())){					
				alert("핸드폰번호 형식에 맞추어주세요.");
				$('#MPHONE').focus();
				return;
			}
			
			 if(idx==false){
				alert("아이디 중복체크를 해주세요.");
				return;
			}else if(emailx==false){
				alert("이메일 중복체크를 해주세요.");
				return;
			}else{
				alert("이메일로 인증번호를 보냈습니다.")
				$('#signFrm').submit();
			} 
		});
		
		$('#Check').click(function(){
			$.ajax({
				url: "${pageContext.request.contextPath}/member/idCheck",
				type: "POST",
				data:{
					"MID":$('#MID').val()
				},
				success: function(data){
					if(data == 0 && $.trim($('#MID').val()) != '' ){
						idx=true;
						$('#MID').attr("readonly",true);
						var html="<tr><td colspan='3' style='color: green'>사용가능</td></tr>";
						$('#idCheck').empty();
						$('#idCheck').append(html);
					}else{

						var html="<tr><td colspan='3' style='color: red'>사용불가능한 아이디 입니다.</td></tr>";
						$('#idCheck').empty();
						$('#idCheck').append(html);
					}
				},
				error: function(){
					alert("서버에러");
				}
			});
			

		});
		
		$('#emailCheck').click(function(){
			$.ajax({
				url: "${pageContext.request.contextPath}/member/findIdEmailCheck",
				type: "POST",
				data:{
					"MEMAIL":$('#MEMAIL').val()
				},
				success: function(data){
					if(data == 0 && $.trim($('#MEMAIL').val()) != '' && emailRegExp.test($('#MEMAIL').val())){
						emailx=true;
						$('#MEMAIL').attr("readonly",true);
						var html="<tr><td colspan='3' style='color: green'>사용가능</td></tr>";
						$('#msg').empty();
						$('#msg').append(html);
					}else{

						var html="<tr><td colspan='3' style='color: red'>사용불가능한 이메일 입니다.</td></tr>";
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