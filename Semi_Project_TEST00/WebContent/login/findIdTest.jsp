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
<%
	
   if(session.getAttribute("message") != null) {
      out.println("<script>alert('아이디 찾기에 실패했습니다. 입력하신 이름과 전화번호가 정확한지 다시 한 번 확인해주세요.')</script>");
      session.invalidate();
   } 

	if(session.getAttribute("msg") != null) {
    out.println("<script>alert('등록하신 휴대전화로 인증번호를 보내드렸습니다.')</script>");
    session.invalidate();
 	} 
%> 
</head>
<body>
	<div class="login-page">	
		<div class="form">				
			<h2 class="text-center">인증페이지</h2>
						
			<form  class="login-form" name="frm" method="post" action="<%=request.getContextPath() %>/board_findIdOk.do">
			<%-- <input type="text" placeholder="" name="phone" value="${mVo.mem_phone }"/>	
			<input type="text" placeholder="" name="certifiNum" value="${certifiNum }"/> --%>
			 <input type="hidden" placeholder="" name="phone2" value="${mVo.mem_phone }"/>	
			<input type="hidden" placeholder="" name="certifiNum" value="${certifiNum }"/>
			
				<input type="text" placeholder="인증번호입력" name="certifiNumAnswer"/>
				<button onclick="location.href='<%=request.getContextPath() %>/board_findIdOk.do'">아이디찾기</button>
				<p class="message">
					로그인 화면으로 가기 <!-- <a href="#">Create an account</a> --> &nbsp;&nbsp;
					<a href="<%=request.getContextPath() %>/board_loginForm.do">로그인</a>
				</p>
			</form>
		</div>
	</div>
</body>
</html>