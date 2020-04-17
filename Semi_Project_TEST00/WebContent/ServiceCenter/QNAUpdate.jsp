<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/qna.css">
<script type="text/javascript" src="script/qna.js"></script>
<script type="text/javascript">
function boardCheck() {

	if(document.frm.title.value.length == 0) {
		alert("제목을 입력하세요. ");
		return false;
	}
	
	if(document.frm.content.value.length == 0) {
		alert("내용을 입력하세요.");
		return false;
	}
	
	return true;
}

</script>
<style>
h1 {
	text-align: left;
}

</style>
</head>
<body>
<div id="wrap" align="center">
<h1>Q&A 수정</h1>
	<form name="frm" method="post" action="BoardQNAUpdateOk.do">
	<input type="hidden" name="num" value="${board.num}">
	<table>							
			<tr>
				<th>제목</th>
				<td><input type="text" name="title" size="60" value="${board.title}"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea cols="70" rows="15" name="content">${board.content}</textarea></td>
			</tr>
		</table>
	<br><br>
	<input type="submit" value="등록" onClick="return boardCheck()">
	<input type="reset" value="다시 작성">
	</form>
</div>
</body>
</html>