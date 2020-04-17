<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../ckeditor.js"></script>
<script src="js/sample.js"></script>
<link rel="stylesheet" href="css/samples.css">
<link rel="stylesheet" href="toolbarconfigurator/lib/codemirror/neo.css">
<meta name="viewport" content="width=device-width,initial-scale=1">
<meta name="description" content="Try the latest sample of CKEditor 4 and learn more about customizing your WYSIWYG editor with endless possibilities.">


<style type="text/css">
</style>
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
<script>
	initSample();
</script>
</head>
<body id="main">

	<div class="container">
	<header>
		<div id="login">
			<a href="<%=request.getContextPath()%>/board_main.do">홈</a>
			<!-- 초기페이지 -->
			<%-- <a href="<%=request.getContextPath()%>/board_loginForm.do">로그인</a> --%>
			
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
	</header>
	
		<nav class="navbar navbar-inverse">
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
					</ul>
				</div>
			</div>
		</nav>
	</div>





<!-- 	<div class="adjoined-bottom"> -->
		<div id="myGridContainer" class="grid-container">
			<div id="myGridWidth" class="grid-width-100">
				<div id="editor">
					<h1>Hello world!</h1>
					<p>I'm an instance of <a href="https://ckeditor.com">CKEditor</a>.</p>
				</div>
			</div>
		</div>
<!-- 	</div> -->




</body>
</html>