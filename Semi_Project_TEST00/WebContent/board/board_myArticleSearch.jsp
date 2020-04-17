<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap_3-3-2.css">
<link rel="stylesheet" href="css/bootstrap-3.4.1.css">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"
	integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script>
function goAction(no){
	 
	//$("#test").attr("onclick", "article.do?no=${dto.getArticle_no()}");
    //팝업창에서 부모창을 다른페이지로 이동합니다.
    //href="article.do?no=${dto.getArticle_no()}"
    window.opener.location.href="article.do?no="+no;
};
</script>
</head>
<body>
	<div align="center" style="margin-top: 20px; margin-left: 20px; margin-right: 20px;">
	<hr width="50%" color="red">
			<h4>기사 작성내역</h4>	
		<hr width="50%" color="red">
	<!-- <div class="col-sm-10"></div> -->
	<table class="table table-bordered table-hover">
		<tr>
			<th>글번호</th>
			<th>글제목</th>
			<th>조회수</th>
			<th>등록일</th>
			<th>삭제</th>
		</tr>
		<c:set var="list" value="${searchList }"/>
		<c:if test="${!empty list }">
			<c:forEach items="${list }" var="dto">
				<tr>
					<td>${dto.getArticle_no() }</td>
					<td>
					<a id="test" onclick="goAction(${dto.getArticle_no() })">${dto.getArticle_title() }</a></td>
					<td>${dto.getArticle_hit() }</td>
					<td>${dto.getArticle_date().substring(0,10) }</td>
					<td><a href="article_delete.do?no=${dto.getArticle_no()}&page=${page}&writer=${article_writer}" class="btn btn-danger btn-xs">삭제</a></td>
				</tr>
			</c:forEach>
		</c:if>
		<c:if test="${empty list }">
			<tr>
				<td colspan="4">
					<h3>검색된 레코드가 없습니다.</h3>
				</td>
			</tr>
		</c:if>
	</table>
	</div>
	
	<div align="center">
		<ul class="pagination">
			<c:if test="${page > block }">
				<li class="paginate_button previous">
					<a href="search_mine.do?page=1&writer=${article_writer}">◀◀</a>
				</li>
				<li>
					<a href="search_mine.do?page=${startBlock - 1 }&writer=${article_writer}">◀</a>
				</li>
			</c:if>
			
			<c:forEach begin="${startBlock }" end="${endBlock }" var="i">
				<c:if test="${i==page }">
					<li class="active">
						<a href="search_mine.do?page=${i }&writer=${article_writer }">${i }</a>
					</li>
				</c:if>
				<c:if test="${i!=page }">
					<li>
						<a href="search_mine.do?page=${i }&writer=${article_writer }">${i }</a>
					</li>
				</c:if>
			</c:forEach>
			<c:if test="${endBlock < allPage }">
				<li>
					<a href="search_mine.do?page=${endBlock + 1 }&writer=${article_writer }">▶</a>
				</li>
				<li class="paginate_button next">
					<a href="search_mine.do?page=${allPage }&writer=${article_writer }">▶▶</a>
				</li>
			</c:if>
		</ul>
	</div>
	<div style="text-align: right; margin-right: 10px;">
		<input type="button" onclick="location.href='board_pro.do?email=${article_writer}'" value="뒤로가기">
	</div>
	<h2>안녕하세요!!!!!!</h2>
</body>
</html>
















