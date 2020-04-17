<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<style type="text/css">
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/style.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap-theme.min.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<c:set var="url" value="${url }" />
<style type="text/css">
fieldset {
    padding: 0.75em;
    border-width: 2px;
    border-style: groove;
    border-color: threedface;
    border-image: initial;
}

legend {
    background-color: #337ab7;
    color: #fff;
    padding: 3px 6px;
}

.output {
    font: 1rem 'Fira Sans', sans-serif;
}

fieldset label {
    margin-right: 34px;
}

form div {
	padding: 6px;
}

.confirm {
	text-align: center;
}

table {
	width: 100%;
}


td:nth-child(1) {
	width: 20%;
}

td:nth-child(2) {
	width: 80%;
}

td {
	text-align: center;
    padding: 0.75em;
    border-width: 2px;
    border-style: groove;
    border-color: threedface;
    border-image: initial;
}

</style>
</head>
<body>
<div id="wrap">
<form action="report_write.do" method="post">
	<div class="header">
	<h3>건의하기</h3>
	<hr />
	<h5>보다 나은 서비스를 제공할 수 있도록 노력하겠습니다.</h5>
	<h5>하지만 장난으로 건의하면 당신은 사형에 처해질 수 있습니다.</h5>
	<br />
	</div>
	<h3>${url }</h3>
	<div class="body">
	<table>
		<tr>
			<td><span>신고대상</span></td>
			<td><a href="" target="_blank">
			<input type="url" style="width: 100%;" readonly></a></td>
		</tr>
	</table>
	<br />
	
	<fieldset>
	    <legend>잘못된 영역을 선택해주세요.</legend>
		<input type="radio" id="title" name="sector1" required>
	    <label for="title">기사 제목</label>
	    <input type="radio" id="press" name="sector1">
	    <label for="press">언론사</label>
	    <input type="radio" id="content" name="sector1">
	    <label for="content">본문 내용</label>
	    <input type="radio" id="attachment" name="sector1">
	    <label for="attachment">첨부 사진/동영상</label>
	    <br/>
	</fieldset>
	<br/>
	<fieldset>
    <legend>잘못된 사항을 선택해주세요.</legend>
		<input type="radio" id="val1" name="sector2" required>
	    <label for="val1">올바른 정보 전달을 방해하는 부정한 광고</label><br/>
		<input type="radio" id="val2" name="sector2">
	    <label for="val2">이미 업로드된 기사와 완전히 동일한 내용</label><br/>
		<input type="radio" id="val3" name="sector2">
	    <label for="val3">지나치게 선정적이고 폭력적인 내용</label><br/>
	    <input type="radio" id="val4" name="sector2">
	    <label for="val4">확인된 사실과 명확히 다른 내용</label><br/>
		<input type="radio" id="val5" name="sector2">
	    <label for="val5">개인정보 침해</label>
	    <input type="radio" id="val6" name="sector2">
	    <label for="val6">기타</label><br/>
	</fieldset>
	<br/>
	<fieldset>
	<legend>상세 내용을 적어주세요.</legend>
	<textarea cols="60" rows="4" placeholder="100자 이내로 적으셈" maxlength="100" required></textarea></fieldset>
	</div>
	<br/>
	<div class="footer confirm">
		<input type="button" value="취소하기">
		<input type="submit" value="전송하기">
		<input type="hidden" name="email" value="${sessionScope.loginUser.getMem_email() }">
		<input type="hidden" name="report">
	</div>
</form>
</div>
<script type="text/javascript">
if(!"${sessionScope.loginUser.getMem_email() }"){
	alert("로그인이 필요합니다.")
	close()
}

$("input[type=url]").attr("value", window.location.href.replace('article_report', 'article'));
$("td a").attr("href", window.location.href.replace('article_report', 'article'));

$(":button").click(function() {
	close();
});

$(":submit").click(function(){
	if($("input[name=sector1]:checked").val()){
		if($("input[name=sector2]:checked").val()){
	$(':radio:checked').attr("checked", true);
	$("textarea").html($("textarea").val());
	$("input[name=report]").val($(".body").html());
	close();
		}
	}
});
</script>
</body>
</html>
