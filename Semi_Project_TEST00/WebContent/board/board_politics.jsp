<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
	font-size: 15px;
}
th{
	font-size: 25px;
}

</style>
</head>
<body>
	<div class="container">
		<%@ include file="../include/header.jsp"%>
		<div style="float: right;"><%@ include file="../include/sidebar.jsp"%></div>
		<h3>정치 부분 헤드 라인</h3>
		<hr width="80%" color="gray">
		<table width="600">
			<tr>
				<th>타이틀 받아와서 넣기</th>
			</tr>
			<tr>
			<td>
			<ul id="hori">
				<li><a href="#"><img alt="썸네일" src="./images/ytn.png"
						width="300" height="170"></a></li>
				<li>
					<ul id="vert">
						<li>상세내역받아와서 넣기</li>
						
					</ul>
				</li>
			</ul>
			</td>
			</tr>
			
			<tr>
				<th>타이틀 받아와서 넣기</th>
			</tr>
			<tr>
			<td>
			<ul id="hori">
				<li><a href="#"><img alt="썸네일" src="./images/ytn.png"
						width="300" height="170"></a></li>
				<li>
					<ul id="vert">
						<li>상세내역받아와서 넣기</li>
						
					</ul>
				</li>
			</ul>
			</td>
			</tr>
			
			<tr>
				<th>타이틀 받아와서 넣기</th>
			</tr>
			<tr>
			<td>
			<ul id="hori">
				<li><a href="#"><img alt="썸네일" src="./images/ytn.png"
						width="300" height="170"></a></li>
				<li>
					<ul id="vert">
						<li>상세내역받아와서 넣기</li>
						
					</ul>
				</li>
			</ul>
			</td>
			</tr>
			
		</table>



		<%@ include file="../include/footer.jsp"%>
	</div>
</body>
</html>