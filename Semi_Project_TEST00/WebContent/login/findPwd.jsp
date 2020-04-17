<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/login.css">
</head>
<body>
	<div class="login-page">	
		<div class="form">	
		
			<form class="register-form">
				<input type="text" placeholder="name" /> <input type="password"
					placeholder="password" /> <input type="text"
					placeholder="email address" />
				<button>create</button>
				<p class="message">
					Already registered? <a href="#">Sign In</a>
				</p>
			</form>
			<h2 class="text-center">비밀번호 찾기</h2>
			<form  class="login-form" name="frm" action="<%=request.getContextPath() %>/board_CertifiNumForPwd.do" method="post">
				<fieldset>
				<input type="text" placeholder="이메일" name="email"/> 
				<input type="text" placeholder="전화번호" name="phone2"/>
				<button onclick="location.href='<%=request.getContextPath() %>/board_CertifiNumForPwd.do'">인증번호받기</button>
				</fieldset>
				<%-- <br /><br />
				<input type="text" placeholder="인증번호입력" name="certifiNum"/>
				<button onclick="location.href='<%=request.getContextPath() %>/board_findId.do'">비밀번호 찾기</button> --%>
				<p class="message">
					로그인 화면으로 가기 <!-- <a href="#">Create an account</a> --> &nbsp;&nbsp;
					<a href="<%=request.getContextPath() %>/board_loginForm.do">로그인</a>
				</p>
			</form>
		</div>
	</div>
</body>
</html>