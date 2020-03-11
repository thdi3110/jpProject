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
    <c:forEach var="notice" items="${noticeList}" varStatus="loop">
         <tr>
            <td>${notice.NBNUM}</td>
            <td><a href="<c:url value="/Notice/Noticeread/${notice.NBNUM}"/>">
              ${notice.NBTITLE}</a></td>
            <td>${notice.NBWRITER}</td>
            <td><fmt:formatDate value="${notice.NBTIME}" pattern="yyyy.MM.dd" /></td>
         </tr>
    </c:forEach>
    </table>
    <a href="<c:url value="/Notice/Noticewrite"/>">새 글</a>
</body>
</html>