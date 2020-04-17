<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<hr width="50%" color="pink">
			<h3>회원 인증</h3>
		<hr width="50%" color="pink">
		
		<form method="post" action="<%=request.getContextPath()%>/member_edit.do">
			<c:set var="writer" value="${writer }"/>
			<input type="hidden" name="writer" value="${writer }"/>
			<table>
				<tr>
					<th>권한 확인</th>
					<td><input type="password" name="pwd"/></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="확인"/>&nbsp;&nbsp;
						<input type="button" value="취소" onclick="location.href='board_pro.do?email=${writer }'">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>