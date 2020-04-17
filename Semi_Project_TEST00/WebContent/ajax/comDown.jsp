<%@page import="com.sist.model.CheckDAO"%>
<%@page import="com.sist.model.MemberVO"%>
<%@page import="com.sist.model.CommentDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
    
<% 
	//회원정보
	session=request.getSession();		
	MemberVO mVoc = (MemberVO) session.getAttribute("loginUser");
	//회원의 이메일, 댓글번호 
	String article_writer = mVoc.getMem_email(); // 멤버테이블의 회원 이메일
	// 댓글 싫어요 구현하기
	int com_no=Integer.parseInt(request.getParameter("comNo").trim());
	CheckDAO dao1=CheckDAO.getInstance();
	CommentDAO dao=CommentDAO.getInstance();
	int result=dao1.checked(com_no, article_writer);
	if(result > 0){// 중복이 아닌경우
		dao.updateComDown(com_no);
		int  bad=dao.selectComDown(com_no);	
		out.println(bad);
	}else{// 중복인 경우
		out.println(0);
	}
		
	
%>