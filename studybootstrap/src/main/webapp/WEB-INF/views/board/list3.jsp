<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>

<!--  부트 스트랩 적용 위치 -->
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 부트 스트랩 적용 위치 -->
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>게시판</title>
<style type="text/css">
li {
	list-style: none;
	float: left;
	padding: 6px;
}
</style>
</head>
<body>

	<!-- 부트 스트랩 변경 위치 -->
	<!-- div id ="root"를 div class="container"로 변경 -->
	<div class="container">
	
	<!-- 부트 스트랩 변경 위치 -->
		<header>
			<h1>게시판</h1>
		</header>
		<hr />

		<div>
			<%@include file="nav.jsp"%>
		</div>
		<hr />
		
		<!-- 부트 스트랩 적용 위치 -->
		<section id="container">
		<!-- 부트 스트랩 적용 위치 -->
			<form role="form" method="get"> 
			<!-- 부트 스트랩 적용 위치 -->
			<!-- <table>을 <table class="table table-hover" >로 변경 -->
				<!-- <table> -->
				<table class="table table-hover" >
				
			<!-- 부트 스트랩 적용 위치 -->
			<!-- <thead> 추가 -->
			
			 <thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>등록일</th>
					</tr>
			</thead>
					<c:forEach items="${list}" var="list">
						<tr>
							<td><c:out value="${list.bno}" /></td>
							<td>
								<a href="/board/readView?bno=${list.bno}&
														 page=${scri.page}&
														 perPageNum=${scri.perPageNum}&
														 searchType=${scri.searchType}&
														 keyword=${scri.keyword}"><c:out value="${list.title}" /></a>
							</td>
							<td><c:out value="${list.writer}" /></td>
							<td><fmt:formatDate value="${list.regdate}" pattern="yyyy-MM-dd" /></td>
						</tr>
					</c:forEach>

				</table>
				<!-- 검색 관련 소스코드 -->
				<!-- <div class="search"> 을 <div class="search row">로 변경 -->
				<!-- 부트 스트랩 적용 위치 -->
				<div class="search row">
				
				<!-- <div class="col-xs-2 col-sm-2"> 추가 -->
				
				<div class="col-xs-2 col-sm-2">
    			<select name="searchType" class="form-control"> <!-- class="form-control"> 추가 -->
      				<option value="n"<c:out value="${scri.searchType == null ? 'selected' : ''}"/>>-----</option>
      				<option value="t"<c:out value="${scri.searchType eq 't' ? 'selected' : ''}"/>>제목</option>
      				<option value="c"<c:out value="${scri.searchType eq 'c' ? 'selected' : ''}"/>>내용</option>
     				<option value="w"<c:out value="${scri.searchType eq 'w' ? 'selected' : ''}"/>>작성자</option>
      				<option value="tc"<c:out value="${scri.searchType eq 'tc' ? 'selected' : ''}"/>>제목+내용</option>
    			</select>
				</div>
				
				<!-- <div class="col-xs-10 col-sm-10"> 추가 -->
				
				<div class="col-xs-10 col-sm-10">
					<div class="input-group"> <!-- <div class="input-group"> 추가 -->
				
   			    <input type="text" name="keyword" id="keywordInput" value="${scri.keyword}" class="form-control"/> <!-- class="form-control" 추가 -->
				<span class="input-group-btn"> <!-- span class "input-group-btn"> -->
    			<button id="searchBtn" type="button" class="btn btn-default">>검색</button> <!-- class="btn btn-default"> -->
    			</span>
    			</div>
    		</div>
   			
   			 <script>
     		 $(function(){
        	$('#searchBtn').click(function() {
          self.location = "list" + '${pageMaker.makeQuery(1)}' + "&searchType=" + $("select option:selected").val() + "&keyword=" + encodeURIComponent($('#keywordInput').val());
        });
      });   
    </script>
  </div>
				<div class="col-md-offset-3"> <!-- div 를 div class="col-md-offset-3"로 변경> -->
					<ul class="pagination"> <!-- ul을 ul class="pagination" 으로 변경 -->
						<c:if test="${pageMaker.prev}">
							<li><a
								href="list${pageMaker.makeSearch(pageMaker.startPage - 1)}">이전</a></li>
						</c:if>

						<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
						
						<!-- 여기에 <li>를 <li <c:out value="${pageMaker.cri.page == idx ? 'class=info' : ''}"/> 로 변경  -->
							<li <c:out value="${pageMaker.cri.page == idx ? 'class=info' : ''}"/>>
							<a href="list${pageMaker.makeSearch(idx)}">${idx}</a></li>
						</c:forEach>

						<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
							<li><a
								href="list${pageMaker.makeSearch(pageMaker.endPage + 1)}">다음</a></li>
						</c:if>
					</ul>
				</div>
			</form>
		</section>
		<hr />
	</div>
</body>
</html>