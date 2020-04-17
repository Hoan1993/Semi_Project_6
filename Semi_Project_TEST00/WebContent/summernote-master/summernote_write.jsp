<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="utf-8">
<head>
	<meta charset="uft-8" />
	<title>summernote</title>
	
	
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
  <!-- include jquery -->
  <!-- include libs stylesheets -->

  <link rel="stylesheet" href="examples/example.css">
	
	
	
	
	
<!-- 	/* 부트스트랩과 제이쿼리 라이브러리를 사용하기 위한 선언 */ -->
	<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
	<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.4/jquery.js"></script> 
	<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 
	
<!-- 	/* summernote의 스타일시트와 자바스크립트을 사용하기 위한 선언 */ -->
	<link href="./dist/summernote.css" rel="stylesheet">
	<script src="./dist/summernote.js"></script>
    

	
	
</head>
<body>
	<h1>summernote</h1>
	
	
<!-- 	<td><textarea class="summernote" rows="10" cols="100" name="tekst"></textarea></td> -->
	
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
                	$('.note-editable').append('<img src="'+data.url+'" width="480" height="auto"/>'); 
                	/* $('#summernote').append('<img src="localhost:8282/Web_Project/upload/business-man-1031755_1920.jpg" width="480" height="auto"/>'); */
                    /* editor.insertImage(welEditable, url); */
                }
            });
        }
    });


</script>
	</form>	
</body>
</html>