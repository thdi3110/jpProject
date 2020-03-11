<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html><head><title>삭제</title></head>
<body>
        <form name="delete" 
        action="<c:url value="/Notice/Noticedelete/{NB_NUM}" />" method="POST">        
                             해당 글을 삭제하시겠습니까?<br>
                <input type="submit" value="삭제">
                <a href="<c:url value="/Notice/Noticeread/${NB_NUM}" />">취소</a>
        </form>
</body>
</html>