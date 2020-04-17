<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="css/login.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://apis.google.com/js/platform.js" async defer></script> 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
 
<script src="https://apis.google.com/js/platform.js" async defer></script> 
<meta name="google-signin-client_id" content="819249257969-to9b6g9h3ha49ltg28gocn0q8qhjivs0.apps.googleusercontent.com">
<script src="https://apis.google.com/js/platform.js?onload=init" async defer></script>

<style>
    .or-seperator {
        margin: 20px 0 10px;
        text-align: center;
        border-top: 1px solid #ccc;
    }
    .or-seperator i {
        padding: 0 10px;
        background: #f7f7f7;
        position: relative;
        top: -11px;
        z-index: 1;
    }
    
</style>
<script type="text/javascript">
	function onSignIn(googleUser) {
	  var profile = googleUser.getBasicProfile();
	  console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
	  console.log('Name: ' + profile.getName());
	  console.log('Image URL: ' + profile.getImageUrl());
	  console.log('Email: ' + profile.getEmail()); // This is null if the 'email' scope is not present.
	  alert(profile.getEmail()+"님 환영합니다.");
	  
	  
	  
	  var email = profile.getEmail();
	  // 여기서 loginUser 세션에 email과 name을 담아준다.
	  /* f(window.sessionStorage) {
		  sessionStorage.clear();
	  } else {
		  alert("세션을 사용할 수 없는 브라우저입니다.");
	  }
	  
	 
	  
	  sessionStorage.setItem("loginUser", email);
	  
	  var hey = sessionStorage.getItem("loginUser");
	  alert(hey); */
	  
	  saveSessionWithAJAX(email)
	  location.href = "board_mainStart.do";

	}
	
/* 	function saveSessionStorage(email) {
		sessionStorage.setItem("loginUser", email);
		
		
	} */
	
	function saveSessionWithAJAX(email) {
		$.ajax({
			type : "post",
			url : "./login/saveSession.jsp",
			data : {"email": email},
			datatype : "jsp",
			success: function(data) {
				
				if(data == 1) {

				} else {
					
				}
			}, error: function() {
				alert("data error");
			}
		});
	}


</script>
<script type="text/javascript">
	function checkLoginStatus() {
		var loginBtn = document.querySelector('#loginBtn');
		
		if(gauth.isSignedIn.get()) {
			location.href="board_mainStart.do";
			console.log('logined');
			loginBtn.value = 'Logout';
			

		} else {
			console.log('logouted');
			loginBtn.value = 'Login';
		}
	}

	function init() {
		console.log('init');
		gapi.load('auth2', function() {
			console.log('auth2');
			window.gauth = gapi.auth2.init({
				client_id: '819249257969-to9b6g9h3ha49ltg28gocn0q8qhjivs0.apps.googleusercontent.com'
			})
			
			gauth.then(function() {
				console.log('googleAuth success');
				checkLoginStatus();
			}, function() {
				console.log('googleAuth fail');
			}); 
		    /* Ready. Make a call to gapi.auth2.init or some other API */
		  });
}

</script>
<!--   <script>
    function checkLoginStatus(){
      var loginBtn = document.querySelector('#loginBtn');
      if(gauth.isSignedIn.get()){
        console.log('logined');
        loginBtn.value = 'Logout';
      } else {
        console.log('logouted');
        loginBtn.value = 'Login';
      }
    }
    function init(){
      console.log('init');
      gapi.load('auth2', function() {
        console.log('auth2');
        var gauth = gapi.auth2.init({
        window.gauth = gapi.auth2.init({
          client_id: '819249257969-to9b6g9h3ha49ltg28gocn0q8qhjivs0.apps.googleusercontent.com'
        });
        gauth.then(function(){
          console.log('googleAuth success');
          checkLoginStatus();
        }, function(){
          console.log('googleAuth fail');
        });
  </script> -->
</head>
<body>
<!-- 	<input type="button" id="loginBtn" value="checking..." onclick="
	if(this.value==='Login') {
		gauth.signIn().then(function() {
			console.log('gauth.signIn()');
		});
	} else {
		gauth.signOut().then(function() {
			console.log('gauth.signOut()');
		});
	}"> -->




	<div class="login-page">

		<div class="form">
			<p align="left">
				<a href="<%=request.getContextPath()%>/board_main.do"> ◀◀ </a>
			</p>

			<div class="g-signin2" data-onsuccess="onSignIn">
				<input type="button" id="loginBtn" value="checking..."
					onclick="
    			if(this.value === 'Login'){
      			gauth.signIn().then(function(){
     		   	console.log('gauth.signIn()');
    		    checkLoginStatus();
    			  });
  			  } else {
  			    gauth.signOut().then(function(){
    		    console.log('gauth.signOut()');
    		    checkLoginStatus();
   			   });
   		 	}
  			">
			</div>
			
					
			<!-- <h2 class="text-center">로그인</h2>
			<div class="text-center social-btn">
				<a href="#" class="btn btn-primary btn-block"><i
					class="fa fa-facebook"></i> Sign in with <b>Facebook</b></a>
						
				<a id="google-button" class="btn btn-danger btn-block"><i
					class="fa fa-google"></i> Sign in with <b>Google</b></a>	
			</div> -->
			<div class="or-seperator">
				<i>or</i>
			</div>


			<form class="register-form">
				<input type="text" placeholder="name" /> <input type="password"
					placeholder="password" /> <input type="text"
					placeholder="email address" />
				<button>create</button>
				<p class="message">
					Already registered? <a href="#">Sign In</a>
				</p>
			</form>
			<form class="login-form" name="frm"
				action="<%=request.getContextPath() %>/board_loginOk.do"
				method="post">
				<input type="text" placeholder="이메일" name="id" /> <input
					type="password" placeholder="비밀번호" name="pwd" />
				<button
					onclick="location.href='<%=request.getContextPath() %>/board_loginOk.do'">로그인</button>
				<p class="message">
					아직도 가입 안 하셨나요?
					<!-- <a href="#">Create an account</a> -->
					<a href="<%=request.getContextPath() %>/board_joinForm.do">회원가입</a>
				</p>
				<br />
				<p class="message">깜빡하셨나요?</p>
				<p class="message">
					<a href="<%=request.getContextPath() %>/board_findId.do">아이디 찾기</a>
					&nbsp;&nbsp; <a
						href="<%=request.getContextPath() %>/board_findPwd.do">비밀번호 찾기</a>
				</p>
				<p></p>
			</form>
		</div>
	</div>

</body>
</html>