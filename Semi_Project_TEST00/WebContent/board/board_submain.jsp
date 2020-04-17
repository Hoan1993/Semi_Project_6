<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/style.css">
<link rel="stylesheet" href="css/bootstrap_3-3-2.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap-theme.min.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style type="text/css">
.hori {
	list-style: none;
	float: left;
	margin-right: 20px;
	text-align: center;
}

.vert li {
	text-align: left;
	float: none;
	list-style: none;
	font-size: 15px;
	overflow: hidden;
	text-overflow: ellipsis;
	display: -webkit-box;
	-webkit-box-orient: vertical;
	word-wrap: break-word;
	line-wrap: break-word;
	line-height: 1.2em;
	height: 5.8em;
	width: 430px;
	
}

th {
	font-size: 25px;
}
</style>
</head>
<body>
		<%@ include file="../include/header.jsp"%>				
		 		
		<div class="container">
		
		<div style="float: right;"><%@ include
            file="../include/sidebar.jsp"%></div>
		<div style="width: 75%">
		<c:set var="list" value="${List }" />
		<h3>헤드 라인</h3>
		<hr width="80%" color="gray">
		

			<c:set var="list" value="${list }" />
					<h3>검색결과</h3>
					<hr align="center" width="100%" color="gray">

					<c:if test="${!empty list }">
						<c:forEach var="dto" items="${list }">
							<table style="width: 900px;">
								<%-- <tr>
									<th>${dto.getArticle_title() }</th>
								</tr> --%>
								<tr>
									<td>
										<ul>
											<c:if test="${!empty dto.getArticle_file1() }">
												<li class="hori"><a
													href="article.do?no=${dto.getArticle_no() }"> <img  style="border: 2px solid gray;"
														alt="썸네일" src="./upload/${dto.getArticle_file1() }"
														width="200" height="170" border="1" cellspacing="1">
												</a></li>
											</c:if>
											<c:if test="${empty dto.getArticle_file1() }">
												<li class="hori"><a
													href="article.do?no=${dto.getArticle_no() }"><img  style="border: 2px solid gray;"
														alt="썸네일" src="./images/no_image.jpg" width="200"
														height="170"></a></li>
											</c:if>
											<li class="hori" style="border-left-color: black; margin: auto;">
												<ul class="vert">
													<li style="font-size: 20px; width: 600px; height: 40px; margin: auto;">
													<a href="article.do?no=${dto.getArticle_no() }"><u>${dto.getArticle_title() }</u></a></li>
													<br />
													<li><a href="article.do?no=${dto.getArticle_no() }">${dto.getArticle_cont() }</a></li>
													<li style="color: gray; margin-top: 25px; height: 20px;">[분야 :
														${dto.getArticle_gen1() }]&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[기자
														:<a
														href="<%=request.getContextPath()%>/search_mine.do?writer=${dto.getArticle_writer() }"
														onclick="window.open('<%=request.getContextPath()%>/search_mine.do?writer=${dto.getArticle_writer() }', '회원정보','width=600, height=500, toolbar=no, menubar=no, scrollbars=no, resizable=yes');return false;">${dto.getArticle_name() }기자</a>
														]&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; [작성일 :
														${dto.getArticle_date().substring(0,10) }]
													</li>
												</ul>
											</li>

										</ul>
									</td>
								</tr>

							</table>
							<hr width="80%" color="gray">
						</c:forEach>
					</c:if>
					<c:if test="${empty list }">
						<table>
							<tr>
								<td><h3>업로드한 내역이 없습니다.</h3></td>
							</tr>
						</table>
					</c:if>
		
		<div align="center">
			<ul class="pagination">
				<c:if test="${page>block }">
					<li class="paginate_button previous"><a
						href="board_politics.do?page=1">◀◀</a></li>
					<li><a href="board_politics.do?page=${startBlock-1 }">◀</a></li>
				</c:if>
				<c:forEach begin="${startBlock }" end="${endBlock }" var="i">
					<c:if test="${i==page }">
						<li class="active"><a href="board_politics.do?page=${i }">${i }</a>
						</li>
					</c:if>
					<c:if test="${i!=page }">
						<li><a href="board_politics.do?page=${i }">${i }</a></li>
					</c:if>
				</c:forEach>

				<c:if test="${endBlock < allPage }">
					<li><a href="board_politics.do?page=${endBlock+1 }">▶</a></li>
					<li class="paginate_button next"><a
						href="board_politics.do?page=${allPage }">▶▶</a></li>
				</c:if>
			</ul>
		</div>


	</div>
		<%@ include file="../include/footer.jsp"%>
	
</body>
</html>
