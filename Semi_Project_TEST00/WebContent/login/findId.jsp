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
<%
	
   if(session.getAttribute("message") != null) {
      out.println("<script>alert('아이디 찾기에 실패했습니다. 입력하신 이름과 전화번호가 정확한지 다시 한 번 확인해주세요.')</script>");
      session.removeAttribute("message");
   } 

	if(session.getAttribute("msg") != null) {
    out.println("<script>alert('등록하신 휴대전화로 인증번호를 보내드렸습니다.')</script>");
    session.removeAttribute("msg");
 	} 
	
	if(session.getAttribute("IdFailed") != null) {
	    out.println("<script>alert('잘못된 인증번호입니다. 인증절차를 다시 시작합니다.')</script>");
	    session.removeAttribute("IdFailed");
	 	} 

%> 
<%-- <%
	if(request.getParameter("certifiNum") != null && request.getParameter("phone2") != null) {
		String certifiNum = (String) request.getParameter("certifiNum").trim();
		request.setAttribute("certifiNum", certifiNum);
		
		String phone2 = (String) request.getParameter("phone2").trim();
		request.setAttribute("phone2", phone2);
	}

%> --%>
</head>
<body>
	<div class="login-page">	
		<div class="form">	
			<!-- <form class="register-form">
				<input type="text" placeholder="name" /> <input type="password"
					placeholder="password" /> <input type="text"
					placeholder="email address" />
				<button>create</button>
				<p class="message">
					Already registered? <a href="#">Sign In</a>
				</p>
			</form> -->
			
			<h2 class="text-center">아이디 찾기</h2>
			
			<form  class="login-form" name="frm" method="post" action="<%=request.getContextPath() %>/board_CertifiNumForId.do">
				<fieldset>
				<input type="text" placeholder="이름" name="name" /> 
				<input type="text" placeholder="전화번호" name="phone" />
				<%-- <button onclick="location.href='<%=request.getContextPath() %>/board_CertifiNumForId.do'">인증번호받기</button> --%>
				<%-- <a href="<%=request.getContextPath() %>/board_CertifiNumForId.do">인증번호받기</a> &nbsp;&nbsp; --%>
				<button onclick="location.href='<%=request.getContextPath() %>/board_CertifiNumForId.do'">인증번호받기</button>
				</fieldset>
				<p class="message">
					로그인 화면으로 가기 <!-- <a href="#">Create an account</a> --> &nbsp;&nbsp;
					<a href="<%=request.getContextPath() %>/board_loginForm.do">로그인</a>
				</p>
			</form>
			<br />
			
			<%-- <form  class="login-form" name="frm" method="post" action="<%=request.getContextPath() %>/board_findIdOk.do">
				
				<input type="hidden" name="phone2" value="${phone}">
				<input type="hidden" name="certifiNum" value="${certifiNum}">
				<br /><br />
				<input type="text" placeholder="인증번호입력" name="certifiNumAnswer"/>
				<button onclick="location.href='<%=request.getContextPath() %>/board_findIdOk.do'">아이디찾기</button>
				<p class="message">
					로그인 화면으로 가기 <!-- <a href="#">Create an account</a> --> &nbsp;&nbsp;
					<a href="<%=request.getContextPath() %>/board_loginForm.do">로그인</a>
				</p>
			</form> --%>
		</div>
	</div>
</body>
</html>