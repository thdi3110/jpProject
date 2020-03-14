<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인</title>
</head>
<body>
	<c:if test="${empty authInfo}">
	<a href = "<c:url value="/member/login"/>">로그인</a><br/><br/>
	<a href = "<c:url value="/member/agreement"/>">회원가입</a>
	</c:if>
	<c:if test="${!empty authInfo and authInfo.division == 'A1'}">
	<p>${authInfo.id}님 환영합니다.</p>	
	<a href = "<c:url value="/member/logout"/>">로그아웃</a><br/><br/>
	</c:if>
	<c:if test="${!empty authInfo and authInfo.division == 'B1'}">
	<p>${authInfo.id}분양자님 환영합니다.</p>
	<a href = "<c:url value="/member/logout"/>">로그아웃</a><br/><br/>
	</c:if>
	<c:if test="${!empty authInfo and authInfo.division == 'S1'}">
	<p>관리자님 환영합니다.</p>
	<a href = "<c:url value="/member/logout"/>">로그아웃</a><br/><br/>
	</c:if>
</body>
</html>