<%@ page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>${serviceVO.SCTITLE}&nbsp내용</title>
</head>
<body>
        <table border="1">
                <tr>
                        <th>제목</th>
                        <td>${serviceVO.SCTITLE}</td>
                </tr>
                 <tr>
                        <th>작성자</th>
                        <td>${serviceVO.SCWRITER}</td>
                </tr>
                <tr>
                        <th>작성일</th>
                        <td><fmt:formatDate value="${serviceVO.SCTIME}" pattern="yyyy.MM.dd" /></td>                        
                </tr>
                <tr>
                        <th>내용</th>
                        <td>${serviceVO.SCCONTENTS}</td>
                </tr>
        </table>
        <div>
                <a href="<c:url value="/Service/Serviceedit/${SCNUM}"/>">수정</a>
                <!-- 삭제 추가 -->
                <a href="<c:url value="/Service/Servicedelete/${SCNUM}"/>">삭제</a> 
                <a href="<c:url value="/Service/Servicelist" />">목록</a>
        </div>
   <script type="text/javascript">
        
   
   </script>
</body>
</html>
