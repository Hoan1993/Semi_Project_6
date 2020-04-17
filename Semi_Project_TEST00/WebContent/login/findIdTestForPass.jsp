<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/login.css">
<!-- <script type="text/javascript">
$('.message a').click(function(){
	   $('form').animate({height: "toggle", opacity: "toggle"}, "slow");
	});
</script> -->
<c:set var="mVo" value="${mVo}" />
</head>
<body>
	<div class="login-page">	
		<div class="form">				
			<h2 class="text-center">인증페이지</h2>
						
			<form  class="login-form" name="frm" method="post" action="<%=request.getContextPath() %>/board_findPwdOk.do">
			<%-- <input type="text" placeholder="" name="phone" value="${mVo.mem_phone }"/>	
			<input type="text" placeholder="" name="certifiNum" value="${certifiNum }"/> --%>
			 <input type="hidden" placeholder="" name="phone2" value="${mVo.mem_phone }"/>	
			<input type="hidden" placeholder="" name="certifiNum" value="${certifiNum }"/>
			
				<input type="text" placeholder="인증번호입력" name="certifiNumAnswer"/>
				<button onclick="location.href='<%=request.getContextPath() %>/board_findPwdOk.do'">비밀번호찾기</button>
				<p class="message">
					로그인 화면으로 가기 <!-- <a href="#">Create an account</a> --> &nbsp;&nbsp;
					<a href="<%=request.getContextPath() %>/board_loginForm.do">로그인</a>
				</p>
			</form>
		</div>
	</div>
</body>
</html>