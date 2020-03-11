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
    <form:form commandName="serviceVO" method="POST" modelAttribute="serviceVO">
       <table border="1">
          <tr>
               <th><form:label path="sCTITLE">제목</form:label></th>
               <td><form:input path="sCTITLE"/>
                 <form:errors path="sCTITLE"/></td>
          </tr>
          <tr>
               <th><form:label path="sCCONTENTS">내용</form:label></th>
               <td><form:input path="sCCONTENTS"/>
                 <form:errors path="sCCONTENTS"/></td>
          </tr>
          <tr>
               <th><form:label path="sCWRITER">작성자</form:label></th>
               <td><form:input path="sCWRITER"/>
                 <form:errors path="sCWRITER"/></td>
          </tr>

       </table>
       <div>
            <input type="submit" value="등록">
            <a href="<c:url value="/Service/Servicelist"/>">목록</a>
       </div>
    </form:form>
</body>
</html>