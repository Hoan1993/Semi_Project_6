<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 게시판 </title>
<link rel="stylesheet" type="text/css" href="css/qna.css">
<script type="text/javascript" src="js/jquery-3.4.1.js"></script>
<script type="text/javascript" src="script/qna.js"></script>
<script type="text/javascript">

function QNAWrite() {
	var w = window.open("about:blank",'Q&A쓰기','width=600, height=500, toolbar=no, menubar=no, scrollbars=no, resizable=yes');
	
	var checkLogin;
	$.ajax({
		method:"POST",
		url: "./ServiceCenter/checkLogin.jsp",
		async: false,
		datatype: "jsp",
		success: function(data) {
			checkLogin = data;
			
		}, error: function() {
			alert("data error");
		}
	});
	
	var result = checkLogin.replace("<!DOCTYPE html>", "");
	var result2 = result.replace(/(\s*)/g, "");
	
	if(result2 == 1) {
		w.location.href = "http://localhost:8282/Project_Template01/BoardQNAWrite.do";
	} else {
		w.close();
        w.parent.alert("로그인 이후에 이용해 주세요");
	}
}


</script>
</head>
<body>
<div>
<%@ include file="../include/header.jsp"%>
</div>
<%-- <div style="float: right;">
		<%@ include file="../include/sidebar.jsp"%></div> --%>
		
		
		
<div class="container">		
<div id="wrap" align="center">
<h1>Q&A 게시판</h1>
<table class="list">
	<tr>
		<td colspan="5" style="border: white; text-align: right">
			<a href="#" onclick="QNAWrite();">
			게시글 등록</a>
		</td>
		
		
	</tr>	
	<tr><th>번호</th><th>제목</th><th>작성일</th><th>조회수</th></tr>
	<c:forEach var="board" items="${list }">
	<tr class="record">
		<td>${board.num }</td>
		<td>
			<a href="BoardQNAView.do?num=${board.num }">
			${board.title }
			</a>
		</td>
		<td>${board.writedate.substring(0,10) }</td>
		<td>${board.readcount }</td>
	</tr>
	</c:forEach>
</table>
</div>

<div align="center">
		<ul class="pagination">
			<c:if test="${page > block }">
				<li class="paginate_button previous">
					<a href="boardQNA.do?page=1">◀◀</a>
				</li>
				<li>
					<a href="boardQNA.do?page=${startBlock - 1 }">◀</a>
				</li>
			</c:if>
			
			<c:forEach begin="${startBlock }" end="${endBlock }" var="i">
				<c:if test="${i==page }">
					<li class="active">
						<a href="boardQNA.do?page=${i }">${i }</a>
					</li>
				</c:if>
				<c:if test="${i!=page }">
					<li>
						<a href="boardQNA.do?page=${i }">${i }</a>
					</li>
				</c:if>
			</c:forEach>
			<c:if test="${endBlock < allPage }">
				<li>
					<a href="boardQNA.do?page=${endBlock + 1 }">▶</a>
				</li>
				<li class="paginate_button next">
					<a href="boardQNA.do?page=${allPage }">▶▶</a>
				</li>
			</c:if>
		</ul>
</div>

</div>
	
	
<%-- 	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<div class="col-md-3 news-side">
			<div class="side-carousel">
				<%@ include file="../include/sidebar_carousel.jsp"%></div>
			
			<div></div>
			<br />
			<div class="side-list">
				<%@ include file="../include/sidebar.jsp"%></div>
	</div> --%>
	










</body>
</html>