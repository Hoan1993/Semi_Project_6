<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/styleForWriter.css">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"
   integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
   crossorigin="anonymous"></script>
<script type="text/javascript" src="./ckeditor/ckeditor.js"></script>


  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
  <!-- include jquery -->
  <!-- include libs stylesheets -->

  <link rel="stylesheet" href="../summernote-master/examples/example.css">
<!-- 	/* 부트스트랩과 제이쿼리 라이브러리를 사용하기 위한 선언 */ -->
	<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
	<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.4/jquery.js"></script> 
	<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 
	
<!-- 	/* summernote의 스타일시트와 자바스크립트을 사용하기 위한 선언 */ -->
	<link href="../summernote-master/dist/summernote.css" rel="stylesheet">
	<script src="../summernote-master/dist/summernote.js"></script>

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
 <style>
/* #myWriter {
	width: 1000px;
	align: center;
} */

#subject {
	width: 1000px;
	height: 45px;
	align: center;
}
#fileInput {
	width: 500px;
	align: center;
}

/* .col-sm-3 {
	align: left;
} */

.content {
	align: center;
}

.container {
	width: 800px;
}

#mySelect1 {
	width: 1000px;
}

</style> 
</head>

<body>
<%@ include file="../include/headerForWriting.jsp"%>
<br />
<div class="container">
<!-- <form action="board_writeOk.do" method="post" class="frm" enctype="multipart/form-data"> -->

	<div align="center" class="row justify-content-md-center">
				
		
		<input name="subject" type="text" class="form-control" id="subject"
			placeholder="제목" required="">
		<!-- <br /> -->
		<div class="container" align="center">
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
		</div>
		
		<br />
			

<form name="writeForm" action="./summernote_insert.jsp" method="post">
		<textarea class="summernote" id="summernote">Hello Summernote</textarea>
			<script>
    $(document).ready(function() {
        $('#summernote').summernote({
            height: 200,
            callbacks: {
                onImageUpload: function(files, editor, welEditable) {
                    sendFile(files[0], editor, welEditable);
                }
            }
        });
        function sendFile(file, editor, welEditable) {
            data = new FormData();
            data.append("uploadFile", file);
            $.ajax({
                data: data,
                type: "POST",
                url: "./summernote_imageUpload.jsp",
                cache: false,
                contentType: false,
                processData: false,
                success: function(data) {
                	$(editor).summernote('editor.insertImage', data.url); 
                	$('.note-editable').append('<div><img src="'+data.url+'" width="480" height="auto"/></div>'); 
                	/* $('#summernote').append('<img src="localhost:8282/Web_Project/upload/business-man-1031755_1920.jpg" width="480" height="auto"/>'); */
                    /* editor.insertImage(welEditable, url); */
                }
            });
        }
    });


			</script>
</form>		
							
		<div class="col-md-13" align="right">
			<label for="InputSubject1">파일첨부</label> 
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
				</label>
				</span>
			</div>
		</div>
			
			
		</div>
			
		<div class="col-lg-12" align="center">
				<fieldset> 
                          <button type="submit" id="form-submit" class="btn btn-primary">등록</button> &nbsp;&nbsp;
                          <button type="reset" id="form-reset" class="btn btn-danger" >다시작성</button>                               
				</fieldset> 
      	</div>

<!-- </form> -->
</div>
</body>
</html>