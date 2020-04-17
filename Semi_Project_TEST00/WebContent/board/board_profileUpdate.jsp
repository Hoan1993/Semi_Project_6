<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function img_change() {
		var chimg = document.getElementById('selectBox').value;
		document.all("change_img").innerHTML = "<img src='"+ chimg +"'>";

		var val = $(this).val();
		var chimg = "";

		chimg = "img/car.jpg";
		chimg = '<img src="' + chimg + '">';
		$('#change_img').html(chimg);
	}
</script>
</head>
<body>
	<div>
		<form action="<%=request.getContextPath()%>/board_editOk.do">
			<table border="1" cellspacing="0">

				<c:set var="mvo" value="${mPro }" />
				<c:set var="avo" value="${aPro }" />
				<c:if test="${!empty avo }">
					<tr>
						<th>프로필</th>
						<td><select name="selectBox" id="selectBox"
							onChange="img_change(this);">
								<option value="images/profile1.png">1</option>
								<option value="images/profile2.png">2</option>
								<option value="images/profile3.png">3</option>
								<option value="images/profile4.png">4</option>
								<option value="images/profile5.png">5</option>
								<option value="images/profile6.png">6</option>
<!-- 테이블 만들어지면 전송해서 테이블에 넣어주기 아직안함 -->
						</select>


							<div id="change_img" align="center">프로필을 골라주세요</div></td>
					</tr>

					<tr>
						<th>아이디</th>
						<td><input type="text" name="writer"
							value="${avo.article_writer }" readonly></td>
					</tr>
				</c:if>
				<c:if test="${!empty mvo }">
					<tr>
						<th>이름</th>
						<td><input type="text" name="name" value="${mvo.mem_name }"></td>
					</tr>
					<tr>
						<th>새로운 비밀번호</th>
						<td><input type="password" name="pwd"></td>
					</tr>
					<tr>
						<th>핸드폰</th>
						<td><input type="text" name="phone" value="${mvo.mem_phone }"></td>
					</tr>

					<tr>
						<th>언론사</th>
						<td><select name="article_media">
								<option value="동아일보">동아일보</option>
								<option value="조선일보">조선일보</option>
								<option value="중앙일보">중앙일보</option>
								<option value="매일경제">매일경제</option>
								<option value="타임즈">타임즈</option>
						</select></td>
					</tr>
					<tr>
						<td colspan="2"><input type="button" value="cancel"
							onclick="location.href='board_pro.do?name=${mvo.mem_name }'">
							<input type="submit" value="수정완료"></td>
					</tr>
				</c:if>

			</table>
		</form>
	</div>

</body>
</html>