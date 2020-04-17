<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1" charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="./css/style.css">
<link rel="stylesheet" href="css/bootstrap-3.4.1.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.6/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script
   src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
   <meta name="google-signin-client_id" content="819249257969-to9b6g9h3ha49ltg28gocn0q8qhjivs0.apps.googleusercontent.com">
<script src="https://apis.google.com/js/platform.js?onload=init" async defer></script>
   
<script type="text/javascript">
	function checkLoginStatus() {
		var loginBtn = document.querySelector('#loginBtn');
		
		var checkLogin = loginCheckByLocal();
		var result = checkLogin.replace("<!DOCTYPE html>", "");
		var result2 = result.replace(/(\s*)/g, "");
		
		if(gauth.isSignedIn.get() || result2 == 1) {
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
	

	function sessionOut() {
		$.ajax({
			type : "post",
			url : "./login/sessionOut.jsp",
			datatype : "jsp",
			success: function(data) {
				if(date != 1) {
					
				}
				window.location.reload();
				
			}, error: function() {
				alert("data error");
			}
		});
	}
	
	function loginCheckByLocal() {
		var result = "";
		$.ajax({
			type : "post",
			url : "./login/checkSession.jsp",
			async: false,
			datatype : "jsp",
			success: function(data) {
					result = data;

			}, error: function() {
				alert("data error");
			}
		});
		return result;
		
	}

</script>	
<style>
.topnav-right {
  text-align: right;
}

.dropdown-menu {
  position: absolute;
  /* background-color: #f8f8f8; */
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
}

.dropdown-item {

  position: absolute;
/* 	 background-color: #383838; */
  background-color: #f8f8f8;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  font-weight: bold;
  font-size: 15px;
  font-family: 돋움,Dotum,나눔고딕,NanumGothic;
}



.dropdown-item {
  display: block;
} 

</style>	
</head>
<body>
	<div class="container">
	<header>
		<div>
<%-- 		<div align="left">
				<form method="post"  action="<%=request.getContextPath()%>/board_search.do">
               <input type="text" class="form-contro-sm"  name="find">&nbsp;
               <input type="submit"  value="검색" class="btn btn-default btn-sm">
            	</form>
		</div> --%>
	
		<div id="login">
			<button type="button" class="btn btn-link" data-toggle="collapse" data-target="#demo">
            <img alt="" style="height:20px; width: 20px;" src="./images/search.png">
         	</button>
			<a href="<%=request.getContextPath()%>/board_mainStart.do">홈</a>
			<!-- 초기페이지 -->
			<%-- <a href="<%=request.getContextPath()%>/board_loginForm.do">로그인</a> --%>
			
			
			<%-- <c:if test="${!empty loginUser }">
					<c:set var="user" value="${loginUser }" />
					<c:forEach items="user" var="dto">
						<a id="logname" href="/board_pro.do?email=${user.mem_email}"
							onclick="window.open('<%=request.getContextPath()%>/board_pro.do?email=${user.mem_email}','회원정보','width=600, height=500, toolbar=no, menubar=no, scrollbars=no, resizable=yes');return false;">${user.mem_email}님</a>
						<a href="<%=request.getContextPath()%>/board_logout.do">로그아웃</a>
					</c:forEach>	
 			</c:if>  --%>
			
			
			<input type="button" id="loginBtn" value="Login"
					onclick="	
			if(this.value === 'Logout') {
  			    gauth.signOut().then(function(){
    		    console.log('gauth.signOut()');
    		    checkLoginStatus();
    		    sessionOut();
    		    
   			   });
   		 	} else if(this.value === 'Login'){
   		 		checkLoginStatus();
   		 		moveToLogin();
   				
   		 		
   		 	}
  			">
		</div>	
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
					<a class="navbar-brand" href="<%=request.getContextPath()%>/board_mainStart.do">뉴스목록</a>
				</div>
				<div class="collapse navbar-collapse" id="nav_menu" align="left">
					<ul class="nav navbar-nav">
	
						<li class="nav-item"><a href="board_politics.do">정치</a></li>
						<li class="nav-item"><a href="board_economy.do">경제</a></li>
						<li class="nav-item"><a href="board_society.do">사회</a></li>
						<li class="nav-item"><a href="board_culture.do">생활/문화</a></li>
						<li class="nav-item"><a href="board_world.do">세계</a></li>
						<li class="nav-item"><a href="board_science.do">IT/과학</a></li>
						<li class="nav-item"><a href="board_sports.do">스포츠</a></li>
						<!-- <li class="nav-item"><a href="board_photo.do">포토뉴스</a></li> -->
						
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<c:set var="user" value="${loginUser }" />
						
						
						<li><a href="board_write.do">기사쓰기 </a></li>	
						<li><a href="http://localhost:8282/Project_Template01/board_pro.do?email=${user.mem_email}" onclick="window.open(this.href,'회원정보','width=800px, height=500px, toolbar=no, menubar=no, scrollbars=no, resizable=yes');return false;">
						마이페이지</a></li>	
						<li class="nav-item dropdown">
						<a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
						고객센터 </a>
						
						<div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
								<a class="dropdown-item" href="boardFAQ.do">FAQ</a> <br/>
								<a class="dropdown-item" href="boardQNA.do">Q&A</a> <br />
								<a class="dropdown-item" href="location.do">오시는 길</a> <br/>			
						 </div> 

					 	</li> 
					 	 <li>
                      	<div id="demo" class="collapse">
      
                        <form method="post"   action="<%=request.getContextPath()%>/board_search.do">
                        <input style="margin-top: 12px;" type="text" class="form-contro-sm"  name="find"> &nbsp;
                        <input type="submit" style="margin-rigth: 10px;" value="검색" class="btn btn-default btn-sm">
                     	</form>
                     
                     </div>   
                  </li>
					</ul>
			 	</div>
			</div>
		</nav> 
	</div>
</body>
</html>

