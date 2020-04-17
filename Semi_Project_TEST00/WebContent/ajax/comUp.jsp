<%@page import="com.sist.model.CheckDAO"%>


<%@page import="com.sist.model.MemberVO"%>

<%@page import="com.sist.model.CommentDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



<% // 회원정보
session=request.getSession();		
MemberVO mVoc = (MemberVO) session.getAttribute("loginUser");
// 회원의 이메일, 댓글번호 
String article_writer = mVoc.getMem_email(); // 멤버테이블의 회원 이메일

int com_no=Integer.parseInt(request.getParameter("comNo").trim());
CheckDAO dao1=CheckDAO.getInstance();
CommentDAO dao=CommentDAO.getInstance();
int result=dao1.checked(com_no, article_writer);
if(result > 0){// 중복으로 안누른사람 
	// 댓글 좋아요 구현하기
	
	dao.updateComUp(com_no);
	int like=dao.selectComUp(com_no);		
	out.println(like);

}else {// 중복으로 누른사람
	// 알림창 보내기
	out.println(0);
}
	
	
	
%>
