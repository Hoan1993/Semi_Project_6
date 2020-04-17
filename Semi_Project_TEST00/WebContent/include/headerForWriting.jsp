<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/styleForWriter.css">
<link rel="stylesheet" href="./css/bootstrap-3.4.1.css">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"
	integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	
<meta name="google-signin-client_id" content="819249257969-to9b6g9h3ha49ltg28gocn0q8qhjivs0.apps.googleusercontent.com">
<script src="https://apis.google.com/js/platform.js?onload=init" async defer></script>
<script type="text/javascript">
	function checkLoginStatus() {
		var loginBtn = document.querySelector('#loginBtn');
		
		if(gauth.isSignedIn.get()) {
			console.log('logined');
			loginBtn.value = 'Logout';
			
		} else {
			console.log('logouted');
			loginBtn.value = 'Login';
		}
		
	}
	
	function moveToLogin() {
		var loginBtn = document.querySelector('#loginBtn');
		
		if(loginBtn.value === 'Login') {
			location.href="<%=request.getContextPath()%>/board_loginForm.do";
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
<!-- <style type="text/css">
.navbar navbar-inverse {
	width: 300px;

}
/* .container_fluid {
	width: 100px;
} */

</style> -->
<style type="text/css">
#myNav {
	width: 1030px;
	height: 50px;
}


</style>

</head>
<body>
	<div class="container" id="myNav">
<%-- 	<header>
		<div id="login" align="right">
			<a href="<%=request.getContextPath()%>/board_main.do">홈</a>
			<!-- 초기페이지 -->
			<a href="<%=request.getContextPath()%>/board_loginForm.do">로그인</a>
			
			<input type="button" id="loginBtn" value="Login"
					onclick="	
			if(this.value === 'Logout') {
  			    gauth.signOut().then(function(){
    		    console.log('gauth.signOut()');
    		    checkLoginStatus();
   			   });
   		 	} else if(this.value === 'Login'){
   		 		checkLoginStatus();
   		 		moveToLogin();		
   		 	}
  			">
			
		</div>
	</header> --%>
	
		<nav class="navbar navbar-inverse" id="mynav2">
			<div class="container_fluid">
				<div class="navbar-header">
					<button type="button" class="collapsed navbar-toggle"
						data-toggle="collapse" data-target="#nav_menu"
						aria-expaned="false">
						<span class="sr-only"></span> 
						<span class="icon-bar"></span> 
						<span class="icon-bar"></span> 
						<span class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="<%=request.getContextPath()%>/board_main.do">뉴스목록</a>
				</div>
				<div class="collapse navbar-collapse" id="nav_menu" align="left">
					<ul class="nav navbar-nav">
						<li><a href="board_politics.do">정치</a></li>
						<li><a href="board_economy.do">경제</a></li>
						<li><a href="board_society.do">사회</a></li>
						<li><a href="board_culture.do">생활/문화</a></li>
						<li><a href="board_world.do">세계</a></li>
						<li><a href="board_science.do">IT/과학</a></li>
						<li><a href="board_sports.do">스포츠</a></li>
						<li><a href="board_write.do">기사쓰기 </a></li>
						<li class="nav-item dropdown">
						
						
						<a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
						고객센터 </a>
						
						<div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
								<a class="dropdown-item" href="#">FAQ</a> <br/>
								<a class="dropdown-item" href="#">Q&A</a> <br />
								<a class="dropdown-item" href="#">오시는 길</a> <br/>
								<a class="dropdown-item" href="#">불만사항 접수</a> <br/>				
						 </div> 
						
						
					 	</li> 
					</ul>
				</div>
			</div>
		</nav>
	</div>

</body>
</html>

