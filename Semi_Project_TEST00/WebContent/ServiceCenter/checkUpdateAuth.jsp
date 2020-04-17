<%@page import="javax.sound.midi.SysexMessage"%>
<%@page import="com.sist.model.QNADao"%>
<%@page import="com.sist.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	int res = 0;

	String email = request.getParameter("email");
	
	if(session.getAttribute("loginUser") != null) {
		MemberVO mVo = (MemberVO) session.getAttribute("loginUser");
    	if(mVo.getMem_email().equals(email)) {
		res = 1;
    	}
    } 
	
	out.println(res);
%>