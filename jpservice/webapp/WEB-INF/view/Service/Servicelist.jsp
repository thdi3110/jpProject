<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>목록</title>
</head>
<body>
    <table border="1">
        <tr>
           <th>NO</th>
           <th>제목</th>
           <th>작성자</th>
           <th>작성일</th>
        </tr>
    <c:forEach var="service" items="${serviceList}" varStatus="loop">
         <tr>
            <td>${service.SCNUM}</td>
            <td><a href="<c:url value="/Service/Serviceread/${service.SCNUM}"/>">
              ${service.ScTITLE}</a></td>
            <td>${service.ScWRITER}</td>
            <td><fmt:formatDate value="${service.SCTIME}" pattern="yyyy.MM.dd" /></td>
         </tr>
    </c:forEach>
    </table>
    <a href="<c:url value="/Service/Servicewrite"/>">새 글</a>
</body>
</html>