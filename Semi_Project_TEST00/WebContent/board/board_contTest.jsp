<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
	table {
		border: 1px solid #000;
		border-collapse: collapse;
		width: 350px;
	}
	
	th, td {
		border: 1px solid #000;
		border-collapse: collapse;
		text-align: center;
	}

	th {
	background: yellowgreen;
	}
	
	.tdr {
		text-align: right;
	}

</style>
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<hr width="50%" color="red">
			<h3>테이블 상세보기</h3>
		<hr width="50%" color="red">	
	<form name="frm" method="post">
		<%-- <c:set var="dto" value="${dto}" /> --%>
	<%-- 	<input type="hidden" name="board_no" value="${dto.update_no }"> --%>
		<c:set var="aVo" value="${aVo }" />
			<table>
				<c:if test="${!empty aVo }" >
				<tr>
					<th>기사번호*</th>
					<td>${aVo.article_no }</td>
				</tr>
				<tr>
					<th>작성자*</th>
					<td>${aVo.article_writer }</td>
				</tr>
				<tr>
					<th>글제목*</th>
					<td>${aVo.article_title }</td>
				</tr>
				<tr>
					<th>글내용*</th>
					<td>
					${aVo.article_cont }	
					</td>
				</tr>
				
				<tr>
					<th>첨부파일</th>
					<td>
					<a href="./upload/${aVo.article_file1}" target="_blink">
					${aVo.article_file1 }</a></td>
				</tr>
				<tr>
					<th>조회수</th>
					<td>${aVo.article_hit}</td>
				</tr>
				<tr>
					<th>작성일자</th>
					<td>${aVo.article_date.substring(0,10) }</td>
				</tr>
				</c:if>
				<c:if test="${empty aVo}">
				<tr>
					<td colspan="4" align="center">
						<h3>검색된 레코드가 없습니다.</h3>
					</td>
				</tr>
			</c:if>		
				<tr>
					<td class="tdr" colspan="2" align="right">
						<%-- <input type="submit" value="수정" />
						<input type="button" value="삭제" 
							onclick="location.href='<%=request.getContextPath() %>/upload_delete.do?no=${dto.getBoard_no()}'"/>
						<input type="button" value="글답변" 
							onclick="location.href='<%=request.getContextPath() %>/board_reply.do?no=${dto.getBoard_no()}'"/>	 --%> 
						<input type="button" value="목록"
						onclick="location.href='<%=request.getContextPath() %>/upload_list.do?'" />
				
					</td>
				</tr>	
			</table>
		</form>
	</div>
</body>
</html>