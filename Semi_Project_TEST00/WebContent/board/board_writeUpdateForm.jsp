<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<html lang="utf-8">
<head>
	<meta charset="uft-8" />
	<title>summernote</title>
	
	
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
  <!-- include jquery -->
  <!-- include libs stylesheets -->

  <link rel="stylesheet" href="./summernote-master/examples/example.css">
<!-- 	/* 부트스트랩과 제이쿼리 라이브러리를 사용하기 위한 선언 */ -->
	<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
	<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.4/jquery.js"></script> 
	<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 
	
<!-- 	/* summernote의 스타일시트와 자바스크립트을 사용하기 위한 선언 */ -->
	<link href="./summernote-master/dist/summernote.css" rel="stylesheet">
	<script src="./summernote-master/dist/summernote.js"></script>
    
<script type="text/javascript">
$(document).ready(function(){
	$("#fileInput").on('change', function() {
		if(window.FileReader) {
			var filename = $(this)[0].files[0].name;
		} else {
			var filename = $(this).val().split('/').pop().split('\\').pop();
		}
		$("#userfile").val(filename);
	});
	
});
</script>
</head>
<style>
.container {
	width: 800px;
	align: center;
}

#subject {
	width: 770px;
	height: 45px;
	align: center;
}
#mySelect1 {
	width: 180px;
	align: right;
}

#fileInput {
	width: 500px;
	align: center;
}

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

.navbar-nav.navbar-center {
    position: absolute;
    left: 50%;
    transform: translatex(-50%);
}

</style>
<body>

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
					<a class="navbar-brand" href="<%=request.getContextPath()%>/board_mainStart.do">뉴스목록</a>
				</div>
				<div class="collapse navbar-collapse" id="nav_menu" align="left">
					<ul class="nav navbar-nav navbar-center">
						<li><a href="board_politics.do">정치</a></li>
						<li><a href="board_economy.do">경제</a></li>
						<li><a href="board_society.do">사회</a></li>
						<li><a href="board_culture.do">생활/문화</a></li>
						<li><a href="board_world.do">세계</a></li>
						<li><a href="board_science.do">IT/과학</a></li>
						<li><a href="board_sports.do">스포츠</a></li>
						<!-- <li class="nav-item"><a href="board_photo.do">포토뉴스</a></li> -->
					</ul>
						<ul class="nav navbar-nav navbar-right">
						<li><a href="board_write.do">기사쓰기 </a></li>
						<li><a href="http://localhost:8282/Project_Template01/board_pro.do?email=${user.mem_email}" onclick="window.open(this.href,'회원정보','width=600, height=500, toolbar=no, menubar=no, scrollbars=no, resizable=yes');return false;">
						마이페이지</a></li>		
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


<h1 align="center">기사 수정 페이지</h1>



<div class="container">
<form action="board_updateOk.do" method="post" class="frm" enctype="multipart/form-data">
<c:set var="aVo" value="${aVo }"></c:set>
<input type='hidden' name='article_no' value='${aVo.article_no }'>
<input type='hidden' name='cont' value='${aVo.article_cont }'>
<!-- 	<div align="center" class="row justify-content-md-center"> -->

		<input name="subject" type="text" class="form-control" id="subject"
			placeholder="제목" value="${aVo.article_title }">
		<!-- <br /> -->
		<!-- <div class="container"> -->
			<select class="form-control" id="mySelect1" name="mySelect1">
				<option value="none">==분야선택==</option>
				<option value="politics">정치</option>
				<option value="economy">경제</option>
				<option value="society">사회</option>
				<option value="culture">연예/문화</option>
				<option value="worle">세계</option>
				<option value="science">IT/과학</option>
				<option value="sports">스포츠</option>
			</select>
		<!-- </div> -->

		<!-- 	<form name="writeForm" action="./summernote_insert.jsp" method="post"> -->
		<textarea name="summernote" class="summernote" id="summernote">${aVo.article_cont }</textarea>
		
		<script>
			$(document)
					.ready(
							function() {
								$('#summernote').summernote(
										{
											height : 600,
											callbacks : {
												onImageUpload : function(files,
														editor, welEditable) {
													sendFile(files[0], editor,
															welEditable);
												}
											}
										});
								function sendFile(file, editor, welEditable) {
									data = new FormData();
									data.append("uploadFile", file);
									$
											.ajax({
												data : data,
												type : "POST",
												url : "./board/summernote_imageUpload.jsp",
												cache : false,
												contentType : false,
												processData : false,
												success : function(data) {
													$(editor)
															.summernote(
																	'editor.insertImage',
																	data.url);
													 $('.note-editable')
															.append(
																	'<div><img src="'+data.url+'" width="480" height="auto"/></div>');
													/*$('#summernote').append('<img src="'+data.url+'" width="480" height="auto"/>'); */
													//editor.insertImage(welEditable, url); 
												}
											});
								}
							});
		</script>



<div class="col-lg-13" align="right">
		<!-- <label for="InputSubject1">파일첨부</label>  -->
			<input id="fileInput"
				filestyle="" name="file" type="file"
				data-class-button="btn btn-default" data-class-input="form-control"
				data-button-text="" data-icon-name="fa fa-upload"
				class="form-control" tableindex="-1"
				style="position: absolute; clip: rect(0px, 0px, 0px, 0px);">
			<div class="bootstrap-filestyle input-group" align="right">
				<input type="text" id="userfile" class="form-control"
					name="userfile" disabled=""> <span
					class="group-span-filestyle input-group-btn" tabindex="0"> <label
					for="fileInput" class="btn btn-default"> <span
						class="glyphicon fa fa-upload"></span>
<!-- 				</label> -->
				</span>
			</div>
		</div>
	</div>	
	
		<br />				
		<div class="col-lg-12" align="center">
				<fieldset> 
                          <button type="submit" id="form-submit" class="btn btn-primary">등록</button> &nbsp;&nbsp;
                          <button type="reset" id="form-reset" class="btn btn-danger" >다시작성</button>                               
				</fieldset> 
      	</div>
      	<input type="hidden" name="test">
</form>	
</body>
<!-- <script>
$(document).ready(function() {
	$('.note-editable').val('input[name=cont]');
});
</script> -->
<script type="text/javascript">
$("button:submit").click(function(){
	$("input[name=test]").val($('.note-editable').html())
})
</script>
<script type="text/javascript">
$("button:reset").click(function(){
	$('.note-editable').empty();
})
</script>
</html>