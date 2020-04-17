<%@page import="com.sist.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	int res = 0;
	
	if(((MemberVO) session.getAttribute("loginUser")) != null) {
		res = 1;
	}

	out.println(res);

%>