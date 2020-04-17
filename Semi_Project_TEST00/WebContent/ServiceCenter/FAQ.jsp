<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
</head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="./css/style.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap-theme.min.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script	src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style>
/* #map {
	position: absolute;
	margin: auto;
} */

.container {
	width: 960px;
	
	padding-top: 3px;
    padding-right: 15px;
    padding-left: 15px;
    margin: 0 auto 0 auto;
    margin-right: auto;
    margin-left: auto;
    align: center;
    
}

.news-main {
	float:left;
	padding: 30px 15px 15px 0;
}

.side-carousel {
	margin-bottom: 15px;
}

.glyphicon {
	vertical-align: middle;
}

.news-cont {
	padding-left: 10px;
	align: center;
	margin: auto;
	
}

ul {
   list-style:none;
   align: center;
   margin:autol;
 }
 
</style>

<style>
.accordion {
  background-color: #eee;
  color: #444;
  cursor: pointer;
  padding: 18px;
  width: 100%;
  border: none;
  text-align: left;
  outline: none;
  font-size: 15px;
  transition: 0.4s;
  align: center;
  margin:autol;
}

.active, .accordion:hover {
  background-color: #ccc;
  align: center;
  margin:autol;
}

.accordion:after {
  content: '\002B';
  color: #777;
  font-weight: bold;
  float: right;
  margin-left: 5px;
  align: center;
  margin:autol;
}

.active:after {
  content: "\2212";
  align: center;
  margin:autol;
}

.panel {
  padding: 0 18px;
  background-color: white;
  max-height: 0;
  overflow: hidden;
  transition: max-height 0.2s ease-out;
  align: center;
  margin:autol;
}

.col-lg-13 news-main {
	align: center;
	margin: auto;
}

P {
	text-align: center;
}
</style>
<body>

<div>
<%@ include file="../include/header.jsp"%>
</div>

<%-- <div style="float: right;">
		<%@ include file="../include/sidebar.jsp"%></div> --%>
<div class="container">		
	<div class="col-lg-13 news-main">
	<div class="news-cont">
	

			<h3 style="color:green; text-align:center;">FAQ</h3>
			<p>서비스 이용에 문제가 있나요? 또는 궁금한게 있나요? </p>
			<P>Q&A 게시판에 문의하기전에 우선 확인해 보세요. 사실, 궁금증의 대부분은 여기서 해결하실 수 있습니다.</P>

		
			<button class="accordion">아이디, 비밀번호를 분실 했다면..</button>
			<div class="panel">
  			<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
			</div>

			<button class="accordion">어떤 기사가 아주 마음에 안 든다면..</button>
			<div class="panel">
  			<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
			</div>

			<button class="accordion">어떤 기사를 쓴 기자가 아주 마음에 안 든다면..</button>
			<div class="panel">
  			<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
			</div>
			
			<button class="accordion">TheEarlyTimes에 광고를 싣고 싶다면..</button>
			<div class="panel">
  			<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
			</div>
			
			<button class="accordion">TheEarlyTimes에 기자가 되고 싶다면..</button>
			<div class="panel">
  			<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
			</div>
			
			<button class="accordion">TheEarlyTimes의 수익분배 구조가 알고 싶다면..</button>
			<div class="panel">
  			<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
			</div>
			
			<button class="accordion">왜 TheEarlyTimes가 TheEarlyTimes인지 알고 싶다면..</button>
			<div class="panel">
  			<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
			</div>
			
			<button class="accordion">뭔가 아직도 궁금한게 있다면..</button>
			<div class="panel">
  			<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
			</div>
	

	
	
		</div>
	</div>
		
		<div class="col-md-5 news-side">
			<%-- <div class="side-carousel">
				<%@ include file="../include/sidebar_carousel.jsp"%></div> --%>
			<div></div>
			<br />
		<div class="side-list">
		<%@ include file="../include/sidebar.jsp"%></div>
		</div>
		
	
	
</div>


<script>
var acc = document.getElementsByClassName("accordion");
var i;

for (i = 0; i < acc.length; i++) {
  acc[i].addEventListener("click", function() {
    this.classList.toggle("active");
    var panel = this.nextElementSibling;
    if (panel.style.maxHeight) {
      panel.style.maxHeight = null;
    } else {
      panel.style.maxHeight = panel.scrollHeight + "px";
    } 
  });
}
</script>
</body>
</html>