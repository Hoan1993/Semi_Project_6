<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 게시판 </title>
<link rel="stylesheet" type="text/css" href="css/qna.css">
<script type="text/javascript" src="script/qna.js"></script>
<style>
h1 {
	text-align: left;
}
</style>
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

</head>
<body>
<div id="wrap" align="center">
	<h1 align="left">뭐가 문제세요?</h1>
	<form name="frm" method="post" action="BoardQNAWriteOk.do">
		<input type="hidden" name="command" value="board_write">
		<table>							
			<tr>
				<th>제목</th>
				<td><input type="text" name="title" size="60" ></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea cols="70" rows="15" name="content"></textarea> </td>
			</tr>
		</table>
		<br><br>
		<input type="submit" value="등록" onClick="return boardCheck()">
		<input type="reset" value="다시 작성">	
	</form>
</div>
</body>
</html>