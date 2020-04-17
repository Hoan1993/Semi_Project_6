<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/style.css">
<link rel="stylesheet" href="css/bootstrap-3.4.1.css">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"
	integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style type="text/css">
#hori li {
	list-style: none;
	float: left;
	text-align: center;
}

#vert li {
	margin-top: 15px;
	list-style: square;
	float: none;
	list-style: square;
	float: none;
	font-size: 17px;
}
th{
	font-size: 25px;
}
</style>
</head>
<body>
<div class="container">
		<%@ include file="../include/header.jsp"%>
	<div style="float: right;">
		<%@ include file="../include/sidebar.jsp"%></div>
	
	
		<div id="carousel-example-generic" style="width: 84%;"
			class="carousel slide" data-ride="carousel">
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#carousel-example-generic" data-slide-to="0"
					class="active"></li>
				<li data-target="#carousel-example-generic" data-slide-to="1"></li>
				<li data-target="#carousel-example-generic" data-slide-to="2"></li>
			</ol>

			<!-- Wrapper for slides -->
			<c:set var="lately" value="${lately }" />

			<div class="carousel-inner" role="listbox" style="width: auto;">
				<div class="item active">
					<div style="margin-left: 55px;">
						<h3>최신뉴스</h3>
						<ul id="hori">
							<c:if test="${!empty lately}">
								<c:forEach var="i" begin="0" end="2" step="1" varStatus="status">
									<li><c:if test="${!empty lately[i].getArticle_file1() }">
											<img src="./upload${lately[i].getArticle_file1() }" alt="..."
												width="240" height="190">
											<br />
										</c:if> <c:if test="${empty lately[i].getArticle_file1() }">
											<img src="./images/no_image.jpg" alt="..." width="240"
												height="190">
											<br />
										</c:if> <a href="article.do?no=${lately[i].getArticle_no() }">${lately[i].getArticle_title()}</a>
								</c:forEach>

							</c:if>
							<c:if test="${empty lately }">
								<c:forEach var="i" begin="0" end="2" step="1" varStatus="status">
									<li><img src="./images/no_image.jpg" alt="..." width="240"
										height="190"><br /> <a href="#">게시물이 없습니다.</a></li>

								</c:forEach>
							</c:if>
						</ul>
						<!-- <div class="carousel-caption">
        ...
      </div> -->
					</div>
				</div>
				<div class="item">
					<div style="margin-left: 55px;">
						<h3>최신뉴스</h3>
						<ul id="hori">
							<c:if test="${!empty lately}">
								<c:forEach var="i" begin="3" end="5" step="1" varStatus="status">
									<li><c:if test="${!empty lately[i].getArticle_file1() }">
											<img src="../upload/${lately[i].getArticle_file1() }" alt="..."
												width="240" height="190">
											<br />
										</c:if> <c:if test="${empty lately[i].getArticle_file1() }">
											<img src="../images/no_image.jpg" alt="..." width="240"
												height="190">
											<br />
										</c:if> <a href="article.do?no=${lately[i].getArticle_no() }">${lately[i].getArticle_title()}</a>
								</c:forEach>

							</c:if>
							<c:if test="${empty lately }">
								<c:forEach var="i" begin="0" end="2" step="1" varStatus="status">
									<li><img src="./images/no_image.jpg" alt="..." width="240"
										height="190"><br /> <a href="#">게시물이 없습니다.</a></li>
								</c:forEach>
							</c:if>
						</ul>
						<!--  <div class="carousel-caption">
        ...
      </div> -->
					</div>
				</div>
				<div class="item">
					<div style="margin-left: 55px;">
						<h3>최신뉴스</h3>
						<ul id="hori">
							<c:if test="${!empty lately}">
								<c:forEach var="i" begin="6" end="8" step="1" varStatus="status">
									<li><c:if test="${!empty lately[i].getArticle_file1() }">
											<img src="./upload${lately[i].getArticle_file1() }" alt="..."
												width="240" height="190">
											<br />
										</c:if> <c:if test="${empty lately[i].getArticle_file1() }">
											<img src="./images/no_image.jpg" alt="..." width="240"
												height="190">
											<br />
										</c:if> <a href="article.do?no=${lately[i].getArticle_no() }">${lately[i].getArticle_title()}</a>
								</c:forEach>

							</c:if>
							<c:if test="${empty lately }">
								<c:forEach var="i" begin="0" end="2" step="1" varStatus="status">
									<li><img src="./images/no_image.jpg" alt="..." width="240"
										height="190"><br /> <a href="#">게시물이 없습니다.</a></li>
								</c:forEach>
							</c:if>
						</ul>
						<!--  <div class="carousel-caption">
        ...
      </div> -->
					</div>
				</div>

			</div>

			<!-- Controls -->
			<a class="left carousel-control" href="#carousel-example-generic"
				role="button" data-slide="prev"> <span
				class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
				<span class="sr-only">Previous</span>
			</a> <a class="right carousel-control" href="#carousel-example-generic"
				role="button" data-slide="next"> <span
				class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
				<span class="sr-only">Next</span>
			</a>
		</div>
		<!-- <div  id="center-top">
			<h3>동영상 뉴스</h3>
			<ul>
				<li><a href="#"><img alt="썸네일" src="images/sbs.png"
						width="200" height="150"></a> <br /> 타이틀 받아와서 넣기</li>
				<li><a href="#"><img alt="썸네일" src="images/mbc.png"
						width="200" height="150"></a> <br /> 타이틀 받아와서 넣기</li>
				<li><a href="#"><img alt="썸네일" src="images/kbs.png"
						width="200" height="150"></a> <br /> 타이틀 받아와서 넣기</li>
				<li><a href="#"><img alt="썸네일" src="images/ytn.png"
						width="200" height="150"></a> <br /> 타이틀 받아와서 넣기</li>
			</ul>
		</div> -->

		<hr width="80%" color="gray">
		<table class="b">
			<tr>
				<td width="50%">
					<h3>정치 뉴스</h3>
					<ul id="hori">
						<c:set var="poli" value="${poli }" />
						<c:if test="${!empty poli }">
							<c:if test="${!empty poli[0].getArticle_file1() }">
								<li><a href="article.do?no=${poli[0].getArticle_no() }"><img
										alt="썸네일" src="./upload${poli[0].getArticle_file1() }"
										width="250" height="170"><br />${poli[0].getArticle_title() }</a></li>
								<li>
									<ul id="vert">
										<c:forEach var="i" begin="1" end="4" step="1" varStatus="status">
											<li><a href="article.do?no=${poli[i].getArticle_no() }">${poli[i].getArticle_title() }</a></li>
										</c:forEach>
									</ul>
								</li>
							</c:if>
							<c:if test="${empty poli[0].getArticle_file1() }">
								<li><a href="article.do?no=${poli[0].getArticle_no() }"><img
										alt="썸네일" src="./images/no_image.jpg" width="250" height="170"><br />${poli[0].getArticle_title() }</a></li>
								<li>
									<ul id="vert">
										<c:forEach var="i" begin="1" end="4" step="1" varStatus="status">
											<li><a href="article.do?no=${poli[i].getArticle_no() }">${poli[i].getArticle_title() }</a></li>
										</c:forEach>
									</ul>
								</li>
							</c:if>


						</c:if>
						<c:if test="${empty poli }">
							<h3>업데이트한 자료가 없습니다.</h3>
						</c:if>
					</ul>
				</td>

				<td width="50%">
					<h3>경제 뉴스</h3>
					<ul id="hori">
						<c:set var="econ" value="${econ }" />
						<c:if test="${!empty econ }">
							<c:if test="${!empty econ[0].getArticle_file1() }">
								<li><a href="article.do?no=${econ[0].getArticle_no() }"><img
										alt="썸네일" src="./upload${econ[0].getArticle_file1() }"
										width="250" height="170"><br />${econ[0].getArticle_title() }</a></li>
								<li>
									<ul id="vert">
										<c:forEach var="i" begin="1" end="4" step="1" varStatus="status">
											<li><a href="article.do?no=${econ[i].getArticle_no() }">${econ[i].getArticle_title() }</a></li>
										</c:forEach>
									</ul>
								</li>
							</c:if>
							<c:if test="${empty econ[0].getArticle_file1() }">
								<li><a href="article.do?no=${econ[0].getArticle_no() }"><img
										alt="썸네일" src="./images/no_image.jpg" width="250" height="170"><br />${econ[0].getArticle_title() }</a></li>
								<li>
									<ul id="vert">
										<c:forEach var="i" begin="1" end="4" step="1" varStatus="status">
											<li><a href="article.do?no=${econ[i].getArticle_no() }">${econ[i].getArticle_title() }</a></li>
										</c:forEach>
									</ul>
								</li>
							</c:if>
						</c:if>

						<c:if test="${empty econ }">
							<h3>업데이트한 자료가 없습니다.</h3>
						</c:if>
					</ul>
				</td>
			</tr>
		</table>

		<table>
			<tr>
				<td width="50%">
					<h3>사회 뉴스</h3>
					<ul id="hori">
						<c:set var="soci" value="${soci }" />
						<c:if test="${!empty soci }">
							<c:if test="${!empty soci[0].getArticle_file1() }">
								<li><a href="article.do?no=${soci[0].getArticle_no() }"><img
										alt="썸네일" src="./upload${soci[0].getArticle_file1() }"
										width="250" height="170"><br />${soci[0].getArticle_title() }</a></li>
								<li>
									<ul id="vert">
										<c:forEach var="i" begin="1" end="4" step="1" varStatus="status">
											<li><a href="article.do?no=${soci[i].getArticle_no() }">${soci[i].getArticle_title() }</a></li>
										</c:forEach>
									</ul>
								</li>
							</c:if>
							<c:if test="${empty soci[0].getArticle_file1() }">
								<li><a href="article.do?no=${soci[0].getArticle_no() }"><img
										alt="썸네일" src="./images/no_image.jpg" width="250" height="170"><br />${soci[0].getArticle_title() }</a></li>
								<li>
									<ul id="vert">
										<c:forEach var="i" begin="1" end="4" step="1" varStatus="status">
											<li><a href="article.do?no=${soci[i].getArticle_no() }">${soci[i].getArticle_title() }</a></li>
										</c:forEach>
									</ul>
								</li>
							</c:if>


						</c:if>
						<c:if test="${empty soci }">
							<h3>업데이트한 자료가 없습니다.</h3>
						</c:if>
					</ul>
				</td>

				<td width="50%">
					<h3>연예/문화 뉴스</h3>
					<ul id="hori">
						<c:set var="cult" value="${cult }" />
						<c:if test="${!empty cult }">
							<c:if test="${!empty cult[0].getArticle_file1() }">
								<li><a href="article.do?no=${cult[0].getArticle_no() }"><img
										alt="썸네일" src="./upload${cult[0].getArticle_file1() }"
										width="250" height="170"><br />${cult[0].getArticle_title() }</a></li>
								<li>
									<ul id="vert">
										<c:forEach var="i" begin="1" end="4" step="1" varStatus="status">
											<li><a href="article.do?no=${cult[i].getArticle_no() }">${cult[i].getArticle_title() }</a></li>
										</c:forEach>
									</ul>
								</li>
							</c:if>
							<c:if test="${empty cult[0].getArticle_file1() }">
								<li><a href="article.do?no=${cult[0].getArticle_no() }"><img
										alt="썸네일" src="./images/no_image.jpg" width="250" height="170"><br />${cult[0].getArticle_title() }</a></li>
								<li>
									<ul id="vert">
										<c:forEach var="i" begin="1" end="4" step="1" varStatus="status">
											<li><a href="article.do?no=${cult[i].getArticle_no() }">${cult[i].getArticle_title() }</a></li>
										</c:forEach>
									</ul>
								</li>
							</c:if>
						</c:if>
						<c:if test="${empty cult }">
							<h3>업데이트한 자료가 없습니다.</h3>
						</c:if>
					</ul>
				</td>
			</tr>
		</table>
		<table>
			<tr>
				<td width="50%">
					<h3>세계 뉴스</h3>
					<ul id="hori">
						<c:set var="world" value="${world }" />
						<c:if test="${!empty world }">
							<c:if test="${!empty world[0].getArticle_file1() }">
								<li><a href="article.do?no=${world[0].getArticle_no() }"><img
										alt="썸네일" src="./upload${world[0].getArticle_file1() }"
										width="250" height="170"><br />${world[0].getArticle_title() }</a></li>
								<li>
									<ul id="vert">
										<c:forEach var="i" begin="1" end="4" step="1" varStatus="status">
											<li><a href="article.do?no=${world[i].getArticle_no() }">${world[i].getArticle_title() }</a></li>
										</c:forEach>
									</ul>
								</li>
							</c:if>
							<c:if test="${empty world[0].getArticle_file1() }">
								<li><a href="article.do?no=${world[0].getArticle_no() }"><img
										alt="썸네일" src="./images/no_image.jpg" width="250" height="170"><br />${world[0].getArticle_title() }</a></li>
								<li>
									<ul id="vert">
										<c:forEach var="i" begin="1" end="4" step="1" varStatus="status">
											<li><a href="article.do?no=${world[i].getArticle_no() }">${world[i].getArticle_title() }</a></li>
										</c:forEach>
									</ul>
								</li>
							</c:if>
						</c:if>
						<c:if test="${empty world }">
							<h3>업데이트한 자료가 없습니다.</h3>
						</c:if>
					</ul>
				</td>

				<td width="50%">
					<h3>IT/과학 뉴스</h3>
					<ul id="hori">
						<c:set var="scie" value="${scie }" />
						<c:if test="${!empty scie }">
							<c:if test="${!empty scie[0].getArticle_file1() }">
								<li><a href="article.do?no=${scie[0].getArticle_no() }"><img
										alt="썸네일" src="./upload${scie[0].getArticle_file1() }"
										width="250" height="170"><br />${scie[0].getArticle_title() }</a></li>
								<li>
									<ul id="vert">
										<c:forEach var="i" begin="1" end="4" step="1" varStatus="status">
											<li><a href="article.do?no=${scie[i].getArticle_no() }">${scie[i].getArticle_title() }</a></li>
										</c:forEach>
									</ul>
								</li>
							</c:if>
							<c:if test="${empty scie[0].getArticle_file1() }">
								<li><a href="article.do?no=${scie[0].getArticle_no() }"><img
										alt="썸네일" src="./images/no_image.jpg" width="250" height="170"><br />${scie[0].getArticle_title() }</a></li>
								<li>
									<ul id="vert">
										<c:forEach var="i" begin="1" end="4" step="1" varStatus="status">
											<li><a href="article.do?no=${scie[i].getArticle_no() }">${scie[i].getArticle_title() }</a></li>
										</c:forEach>
									</ul>
								</li>
							</c:if>
						</c:if>
						<c:if test="${empty scie }">
							<h3>업데이트한 자료가 없습니다.</h3>
						</c:if>
					</ul>
				</td>
			</tr>
		</table>
		<table>
			<tr>
				<td width="50%">
					<h3>스포츠 뉴스</h3>
					<ul id="hori">
						<c:set var="sports" value="${sports }" />
						<c:if test="${!empty sports }">
							<c:if test="${!empty sports[0].getArticle_file1() }">
								<li><a href="article.do?no=${sports[0].getArticle_no() }"><img
										alt="썸네일" src="./upload${sports[0].getArticle_file1() }"
										width="250" height="170"><br />${sports[0].getArticle_title() }</a></li>
								<li>
									<ul id="vert">
										<c:forEach var="i" begin="1" end="4" step="1" varStatus="status">
											<li><a href="article.do?no=${sports[i].getArticle_no() }">${sports[i].getArticle_title() }</a></li>
										</c:forEach>
									</ul>
								</li>
							</c:if>
							<c:if test="${empty sports[0].getArticle_file1() }">
								<li><a href="article.do?no=${sports[0].getArticle_no() }"><img
										alt="썸네일" src="./images/no_image.jpg" width="250" height="170"><br />${sports[0].getArticle_title() }</a></li>
								<li>
									<ul id="vert">
										<c:forEach var="i" begin="1" end="4" step="1" varStatus="status">
											<li><a href="article.do?no=${sports[i].getArticle_no() }">${sports[i].getArticle_title() }</a></li>
										</c:forEach>
									</ul>
								</li>
							</c:if>
						</c:if>
						<c:if test="${empty sports }">
							<h3>업데이트한 자료가 없습니다.</h3>
						</c:if>
					</ul>
				</td>
			</tr>

		</table>
		<hr width="80%" color="gray" />

	</div>
	<%@ include file="../include/footer.jsp"%>
</body>
</html>