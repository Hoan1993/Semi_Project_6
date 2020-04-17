<%@page import="com.sist.model.MemberDAO"%>
<%@page import="com.sist.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	String email = request.getParameter("email");
	
	System.out.println(email+"이 들어왔어요");
	int res = 1;
	MemberVO mVo = new MemberVO();
	String [] temp = email.split("@");
	String name = temp[0];
	
	/* String [] temp = email.split("@");
	String mem_name = temp[0];
	mVo.setMem_name(mem_name); */
	
	mVo.setMem_email(email);
	mVo.setMem_name(name);
	
	session.setAttribute("loginUser", mVo);

	out.println(res);

%>