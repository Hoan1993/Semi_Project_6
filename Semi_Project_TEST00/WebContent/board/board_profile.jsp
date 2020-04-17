<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap-theme.min.css">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script>
	if(!"${sessionScope.loginUser.getMem_email() }") {
		alert("로그인이 필요합니다.")
		close()
	}

   function goAction(no) {

      //$("#test").attr("onclick", "article.do?no=${dto.getArticle_no()}");
      //팝업창에서 부모창을 다른페이지로 이동합니다.
      //href="article.do?no=${dto.getArticle_no()}"
      window.opener.location.href = "article.do?no=" + no;
   };
   $('#myTab a').click(function(e) {
      e.preventDefault()
      $(this).tab('show')
   })
   $('#myTab a[href="#profile"]').tab('show') // Select tab by name
   $('#myTab a:first').tab('show') // Select first tab
   $('#myTab a:last').tab('show') // Select last tab
   $('#myTab li:eq(2) a').tab('show') // Select third tab (0-indexed)

   $(function() {
      $('#myTab a:last').tab('show')
   })
</script>
<style>
#articleHeader > th {
	font-weight: normal;
	color: #fff;
	background-color: #337ab7;
    border-color: #2e6da4;
}
</style>
</head>
<body>
	<div class="panel panel-primary">
		<div class="panel-heading panel-title">마이 페이지</div>
		<div class="panel-body">
			<div role="tabpanel">
				<!-- Nav tabs -->
				<ul class="nav nav-tabs" role="tablist">
					<li role="presentation" class="active"><a href="#home"
						aria-controls="home" role="tab" data-toggle="tab">회원 프로필</a></li>
					<li role="presentation"><a href="#profile"
						aria-controls="profile" role="tab" data-toggle="tab">나의 작성내역</a></li>
					<li role="presentation"><a href="#favorite"
						aria-controls="favorite" role="tab" data-toggle="tab">나의 스크랩</a></li>

				</ul>

				<!-- Tab panes -->
				<div class="tab-content">
					<div role="tabpanel" class="panel panel-info tab-pane active" id="home"
						align="center" style="border-top: 0px;">
						<div id="profileBody" class="panel-body">
						<table border="1" cellspacing="0"
							style="width: 500px; height: 250px;"
							class="table table-bordered table-striped">

							<c:set var="mvo" value="${mPro }" />
							<c:set var="avo" value="${aPro }" />
							
								<tr>
								<th><h4>아 이 디</h4></th>
								<td><h4>${avo.article_writer }</h4></td>
							</tr>
							<tr>
								<th><h4>이 름</h4></th>
								<td><h4>${mvo.mem_name }</h4></td>
							</tr>
							<tr>
								<th><h4>비 밀 번 호</h4></th>
								<td><h4>${mvo.mem_pwd.substring(0,1) }*****</h4></td>
							</tr>
							<tr>
								<th><h4>휴 대 폰</h4></th>
								<td><h4>${mvo.mem_phone }</h4></td>
							</tr>

							<tr>
								<th><h4>소 속</h4></th>
								<td><h4>${avo.article_media }</h4></td>
							</tr>
						</table>
						<div style="width: 450px; vertical-align: text-top;">
						<input type="button" value="회원정보 수정"
							class="btn btn-primary btn-md"
							onclick="location.href='member_suzung.do?writer=${avo.article_writer }'">
						<input type="button" style="margin-left: 20px; padding-left: 15px; padding-right: 15px;"
							class="btn btn-default btn-md" onclick="window.close()" value="확인" >
						</div>
						</div>
					</div>

					<div role="tabpanel" class="tab-pane" id="profile">
						<div align="center" class="panel panel-info" style="border-top: 0px;">
							<div id="articleBody" class="panel-body" style="margin-top: 10px;">
							<table class="table table-bordered table-hover">
								<tr id="articleHeader">
									<th class="col-sm-1">번 호</th>
									<th class="col-sm-5">게 시 물</th>
									<th class="col-sm-3">등 록 일</th>
									<th class="col-sm-2">조 회 수</th>
									<th class="col-sm-1">삭 제</th>
								</tr>
								<c:set var="list" value="${searchList }" />
								<c:if test="${!empty list }">
									<c:forEach items="${list }" var="dto">
										<tr>
											<td>${dto.getArticle_no() }</td>
											<td><a href="javascript:void(0)" id="test"
												onclick="goAction(${dto.getArticle_no() })">${dto.getArticle_title() }</a></td>
											<td>${dto.getArticle_date() }</td>
											<td>${dto.getArticle_hit() }</td>
											<td>
											<c:if test="${sessionScope.loginUser.getMem_email() == article_writer}">
											<a href="article_delete.do?no=${dto.getArticle_no()}&page=${page}&writer=${article_writer}"
												class="btn btn-info btn-xs">X</a>
											</c:if>	
											</td>
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
						</div>

						<div align="center">
							<ul class="pagination">
								<c:if test="${page > block }">
									<li class="paginate_button previous"><a
										href="search_mine.do?page=1&writer=${article_writer}">◀◀</a></li>
									<li><a
										href="search_mine.do?page=${startBlock - 1 }&writer=${article_writer}">◀</a>
									</li>
								</c:if>

								<c:forEach begin="${startBlock }" end="${endBlock }" var="i">
									<c:if test="${i==page }">
										<li class="active"><a
											href="search_mine.do?page=${i }&writer=${article_writer }">${i }</a>
										</li>
									</c:if>
									<c:if test="${i!=page }">
										<li><a
											href="search_mine.do?page=${i }&writer=${article_writer }">${i }</a>
										</li>
									</c:if>
								</c:forEach>
								<c:if test="${endBlock < allPage }">
									<li><a
										href="search_mine.do?page=${endBlock + 1 }&writer=${article_writer }">▶</a>
									</li>
									<li class="paginate_button next"><a
										href="search_mine.do?page=${allPage }&writer=${article_writer }">▶▶</a>
									</li>
								</c:if>
							</ul>
						</div>
						<div style="text-align: right; margin-right: 10px;">
						</div>
					</div>
					<div role="tabpanel" class="tab-pane" id="favorite"><%@ include
							file="../member/fav_list.jsp"%></div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>