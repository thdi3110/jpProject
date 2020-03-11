<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>새 글 쓰기</title>
</head>
<body>
    <form:form commandName="noticeVO" method="POST" modelAttribute="noticeVO">
       <table border="1">
          <tr>
               <th><form:label path="nBTITLE">제목</form:label></th>
               <td><form:input path="nBTITLE"/>
                 <form:errors path="nBTITLE"/></td>
          </tr>
          <tr>
               <th><form:label path="nBCONTENTS">내용</form:label></th>
               <td><form:input path="nBCONTENTS"/>
                 <form:errors path="nBCONTENTS"/></td>
          </tr>
          <tr>
               <th><form:label path="nBWRITER">작성자</form:label></th>
               <td><form:input path="nBWRITER"/>
                 <form:errors path="nBWRITER"/></td>
          </tr>

       </table>
       <div>
            <input type="submit" value="등록">
            <a href="<c:url value="/Notice/Noticelist"/>">목록</a>
       </div>
    </form:form>
</body>
</html>