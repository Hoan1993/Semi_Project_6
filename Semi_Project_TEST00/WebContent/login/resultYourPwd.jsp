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
</head>
<body>
	<div class="login-page">	
		<div class="form">				
			<h2 class="text-center">${username }님의 임시비밀번호가 등록하신 메일로 보내졌습니다.</h2>
						
<%-- 			<form  class="login-form" name="frm" method="post" action="<%=request.getContextPath() %>/board_findIdOk.do">
				<input type="text" placeholder="인증번호입력" name="mem_pwd" value="${mVo.mem_pwd }" readonly="readonly"/> --%>
				<p class="message">
					로그인 화면으로 가기 &nbsp;&nbsp;
					<a href="<%=request.getContextPath() %>/board_loginForm.do">로그인</a>
				</p>
			</form>
		</div>
	</div>
</body>
</html>