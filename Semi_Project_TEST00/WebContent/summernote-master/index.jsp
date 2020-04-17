<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
  <title>Summernote - Bootstrap 4</title>
  <!-- include jquery -->
  <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.js"></script>

  <!-- include libs stylesheets -->
  <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.css" />
  <script src="//cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.js"></script>
  <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.js"></script>

  <!-- include summernote -->
  <link rel="stylesheet" href="dist/summernote-bs4.css">
  <script type="text/javascript" src="dist/summernote-bs4.js"></script>

  <link rel="stylesheet" href="examples/example.css">
	<script type="text/javascript">
    /* summernote에서 이미지 업로드시 실행할 함수 */
 	function sendFile(file, editor) {
        // 파일 전송을 위한 폼생성
 		data = new FormData();
 	    data.append("uploadFile", file);
 	    $.ajax({ // ajax를 통해 파일 업로드 처리
 	        data : data,
 	        type : "POST",
 	        url : "./summernote_imageUpload.jsp",
 	        cache : false,
 	        contentType : false,
 	        processData : false,
 	        success : function(data) { // 처리가 성공할 경우
                // 에디터에 이미지 출력
 	        	$(editor).summernote('editor.insertImage', data.url);
 	        }
 	    });
 	}
</script>
</head>
<body>
<div class="container">
  <h1>Summernote with Bootstrap 4</h1>
  <p>
    <span class="badge badge-primary">jQuery v3.4.1</span>
    <span class="badge badge-info">Bootstrap v4.4.1</span>
  </p>
  <div class="summernote"><p>Hello World</p></div>
</div>


	<h1>summernote</h1>
	<form name="writeForm" action="./summernote_insert.jsp" method="post">
		<textarea id="summernote">Hello Summernote</textarea>
        <script>
            $(document).ready(function() {
                $('#summernote').summernote({ // summernote를 사용하기 위한 선언
                    height: 400,
					callbacks: { // 콜백을 사용
                        // 이미지를 업로드할 경우 이벤트를 발생
					    onImageUpload: function(files, editor, welEditable) {
						    sendFile(files[0], this);
						}
					}
				});
			});
		</script>
	</form>	





</body>
</html>
