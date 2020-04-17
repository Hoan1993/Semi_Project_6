<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Creative Colorlib SignUp Form</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- Custom Theme files -->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- //Custom Theme files -->
<!-- web font -->
<link href="//fonts.googleapis.com/css?family=Roboto:300,300i,400,400i,700,700i" rel="stylesheet">
<!-- //web font -->
<link rel="stylesheet" href="css/register.css">
<style type="text/css">
#button1 {

  font-size: .9em;
  color: #fff;
  background: #76b852;
  outline: none;
  border: 1px solid #76b852;
  cursor: pointer;
  padding: 0.9em;
  -webkit-appearance: none;
  width: 100%;
  margin: 1em 0;
  letter-spacing: 4px;
}

#button1:hover {
  -webkit-transition: .5s all;
  -moz-transition: .5s all;
  -o-transition: .5s all;
  -ms-transition: .5s all;
  transition: .5s all;
  background: #8DC26F;
}


/* #phoneId {
	display: inline-block;
	float: left;
} 

fieldset {
	display: inline-block;
	float: center;
}
.in-line {
 display: inline-block;
 
} */


</style> 
<script type="text/javascript" src="js/jquery-3.4.1.js"></script>
<script type="text/javascript">
// 현재 웹문서가 브라우저로 로딩될 때 문서의 본문(body)을 읽고 현재의 JQuery를 호출하는 명령문
$(document).ready(function() {
	$("#button1").click(function() {
		var phone = $("#phoneId").val();
		
		$.ajax({
			type : "post",
			url : "./login/identify.jsp",
			data : {"phone": phone},
			datatype : "jsp",
			success: function(data) {
				
				if(data == 1) {
					alert("중복된 휴대전화번호");
				} else {
					
					$("#certifiNum").val(certifiNum);
					alert("인증 번호 전송");
					
				}
			}, error: function() {
				alert("data error");
			}
		});
	});

});
</script>
<c:set var="certifiNum" value="${certifiNum}" /> 
</head>
<body>
	<!-- main -->
	<h2>${certifiNum}</h2>
	<div class="main-w3layouts wrapper">
		<h1>회원가입폼</h1>
		<div class="main-agileinfo">
			<div class="agileits-top">
			
				<form action="board_joinOk.do" method="post">
					<input type="hidden" placeholder="" name="certifiNum" id="certifiNum"/>
					
					<input class="text email" type="email" name="email" placeholder="이메일" required="">
					<input class="text" type="password" name="password" placeholder="비밀번호" required="">
					<input class="text w3lpass" type="password" name="password" placeholder="비밀번호 확인" required="">
					<input class="text" type="text" name="Username" placeholder="이름" required="">
					<!-- <input class="text" type="text" name="phone" placeholder="전화번호" required=""> -->
					<br /><br /><br />
						<input class="text" type="text" id="phoneId" name="phone" placeholder="전화번호" required="">
						<input type="button" id="button1" name="button" onclick="button1_click();" value="인증번호" required="" />
						<input class="text" type="text" name="certifiNumAnswer" placeholder="인증번호입력" required="">
					<!-- <div class="wthree-text"> -->
						<!-- <label class="anim">
							<input type="checkbox" class="checkbox" required="">
							<span>열심히 참여해 주실거죠?</span>
						</label> -->
						<!-- <div class="clear"> </div> -->
					<!-- </div> -->
					<br /><br />
					<input type="submit" value="회원가입">
				</form>
				<p>계정이 이미 있나요?  &nbsp; &nbsp; <a href="board_loginForm.do"> 로그인하기</a></p>
			</div>
		</div>
		<!-- copyright -->
		<div class="colorlibcopy-agile">
			<p>© 2018 Colorlib Signup Form. All rights reserved | Design by <a href="#" target="_blank">Colorlib</a></p>
		</div>
		<!-- https://colorlib.com/ -->
		<!-- //copyright -->
		<ul class="colorlib-bubbles">
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
		</ul>
	</div>
	<!-- //main -->
</body>
</html>