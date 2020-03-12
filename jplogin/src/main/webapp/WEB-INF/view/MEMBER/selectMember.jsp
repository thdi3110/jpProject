<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 선택</title>
</head>
<body>
	<a href="<c:url value="/MEMBER/writeNormal"/>">일반회원</a>
	<a href="<c:url value="/MEMBER/writeParcelOut"/>">분양회원</a>
</body>
</html>