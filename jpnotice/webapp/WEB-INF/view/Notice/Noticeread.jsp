<%@ page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>${noticeVO.NBTITLE}&nbsp내용</title>
</head>
<body>
        <table border="1">
                <tr>
                        <th>제목</th>
                        <td>${noticeVO.NBTITLE}</td>
                </tr>
                 <tr>
                        <th>작성자</th>
                        <td>${noticeVO.NBWRITER}</td>
                </tr>
                <tr>
                        <th>작성일</th>
                        <td><fmt:formatDate value="${noticeVO.NBTIME}" pattern="yyyy.MM.dd" /></td>                        
                </tr>
                <tr>
                        <th>내용</th>
                        <td>${noticeVO.NBCONTENTS}</td>
                </tr>
        </table>
        <div>
                <a href="<c:url value="/Notice/Noticeedit/${NBNUM}"/>">수정</a>
                <!-- 삭제 추가 -->
                <a href="<c:url value="/Notice/Noticedelete/${NBNUM}"/>">삭제</a> 
                <a href="<c:url value="/Notice/Noticelist" />">목록</a>
        </div>
   <script type="text/javascript">
        
   
   </script>
</body>
</html>
