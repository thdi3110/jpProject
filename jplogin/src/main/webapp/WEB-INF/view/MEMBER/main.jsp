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
	<a href = "<c:url value="/MEMBER/login"/>">로그인</a><br/><br/>
	<a href = "<c:url value="/MEMBER/agreement"/>">회원가입</a>
</body>
</html>