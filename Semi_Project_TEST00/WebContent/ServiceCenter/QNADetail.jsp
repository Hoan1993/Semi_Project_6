<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Q&A 상세보기 </title>
<link rel="stylesheet" type="text/css" href="css/qna.css">
<script type="text/javascript" src="js/jquery-3.4.1.js"></script>
<script type="text/javascript" src="script/qna.js"></script>
<script type="text/javascript">
function deleteQNA() {
	var email = document.getElementById('email').innerText;
	var num = document.getElementById('num').getAttribute('value');
	
	var checkLogin;
	
	alert(email+" "+num);
	
	$.ajax({
		type : "post",
		url : "./ServiceCenter/chechAndDelete.jsp",
		data : {"email": email, "num": num},
		datatype : "jsp",
		success: function(data) {
			checkLogin = data;
			var result = checkLogin.replace("<!DOCTYPE html>", "");
			var result2 = result.replace(/(\s*)/g, "");
			if(result2 > 0) {
				location.href = "boardQNA.do";
			} else {
				alert("본인이 쓴 글만 삭제할 수 있습니다.");
			}
			
		}, error: function() {
			alert("data error");
		}
	});	
}


function updateQNA() {
	var w = window.open("about:blank",'Q&A수정','width=600, height=500, toolbar=no, menubar=no, scrollbars=no, resizable=yes');
	
	var email = document.getElementById('email').innerText;
	var num = document.getElementById('num').getAttribute('value');
	
	
	
	var checkLogin;
	$.ajax({
		method:"POST",
		url: "./ServiceCenter/checkUpdateAuth.jsp",
		data : {"email": email},
		datatype: "jsp",
		success: function(data) {
			checkLogin = data;
			var result = checkLogin.replace("<!DOCTYPE html>", "");
			var result2 = result.replace(/(\s*)/g, "");
			
			if(result2 == 1) {
				w.location.href = "http://localhost:8282/Project_Template01/BoardQNAUpdate.do?num="+num;
			} else {
				w.close();
		        w.parent.alert("수정 권한이 없습니다.");
			}
			
		}, error: function() {
			alert("data error");
		}
	});
	
}

</script>
<style>
th {
	width: 80px;
	height: 40px;
	text-align: center;
}

#tar {
	text-align: center;
}

</style>

</head>
<body>


<%@ include file="../include/header.jsp"%>
<%-- <div style="float: right;">
		<%@ include file="../include/sidebar.jsp"%></div> --%>
		
<div class="container">		


		
<div id="wrap" align="center">
<input id="num" type="hidden" value="${board.num }">
	<h1> Q&A 상세보기 </h1>
		<table>
			
			<tr>
				
			</tr>	
			
			<tr>
				<th> 작성자 </th><td id="email">${board.email }</td>
				<th> 작성일/조회수 </th> <td>${board.writedate.substring(0,10) } / ${board.readcount }</td>
			</tr>
			<tr>
				<th> 제목 </th>
				<td colspan="3">${board.title }</td>
			</tr>
			
			<tr>
				<th>내용</th>
				<td colspan="20" id="tar"><textarea cols="145" rows="10" readonly>${board.content }</textarea></td>
			</tr>
	</table>
	<br><br>
		<input type="button" value="게시글 수정" onClick="updateQNA();">
		<input type="button" value="게시글 삭제" onClick="deleteQNA();">
		<input type="button" value="게시글 리스트" onClick="location.href='boardQNA.do'">		
		

		<br /><br />

</div>
</div>
</body>
</html>