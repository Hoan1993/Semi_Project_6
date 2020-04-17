<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
			<form  class="login-form" name="frm" action="<%=request.getContextPath() %>/board_loginOk.do" method="post">
				<input type="text" placeholder="이메일" name="id"/> <input type="password"
					placeholder="비밀번호" name="pwd"/>
				<button onclick="location.href='<%=request.getContextPath() %>/board_loginOk.do'">로그인</button>
				<p class="message">
					아직 가입 안 하셨나요? <!-- <a href="#">Create an account</a> -->
					<a href="<%=request.getContextPath() %>/board_joinForm.do">회원가입</a>
				</p>
			</form>
		</div>
	</div>
</body>
</html>