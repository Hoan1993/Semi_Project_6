<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/login.css">
<c:set var="username" value="${username}" />
<c:set var="hiddenId" value="${hiddenId}" />
</head>
<body>
	<div class="login-page">	
		<div class="form">				
			<h2 class="text-center">${username}님의 아이디</h2>
						
			<form  class="login-form" name="frm" method="post" action="<%=request.getContextPath() %>/board_findIdOk.do">
				<input type="text" placeholder="인증번호입력" name="mem_email" value="${hiddenId }" readonly="readonly"/>
				<p class="message">
					로그인 화면으로 가기 &nbsp;&nbsp;
					<a href="<%=request.getContextPath() %>/board_loginForm.do">로그인</a>
				</p>
			</form>
		</div>
	</div>
</body>
</html>