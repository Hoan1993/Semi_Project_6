<%@page import="javax.sound.midi.SysexMessage"%>
<%@page import="com.sist.model.QNADao"%>
<%@page import="com.sist.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	int res = 0;

	String email = request.getParameter("email");
	String num_1 = request.getParameter("num");
	
	System.out.println(email+" "+num_1);
	
	int num = Integer.parseInt(num_1);

    MemberVO mVo = (MemberVO) session.getAttribute("loginUser");
	QNADao qDao = QNADao.getInstance();
    
    if(mVo.getMem_email().equals(email)) {
		qDao.deleteQNA(num);
		res = 1;
    } 
	

	out.println(res);
	
%>