<%@page import="javax.sound.midi.SysexMessage"%>
<%@page import="util.MakeCertifiNum"%>
<%@page import="findIdByPhoneNumber.SendSMS"%>
<%@page import="findIdByPhoneNumber.Config"%>
<%@page import="com.sist.model.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	String certifiNum = "";
	String phone = request.getParameter("phone");

	MemberDAO dao = MemberDAO.getInstance();
	
	int mem_phone = Integer.parseInt(phone);
	int res = dao.checkMember(mem_phone);

	MakeCertifiNum mc = new MakeCertifiNum();
	certifiNum = mc.makeNum();
	
	Config co = new Config();
	Config.content = "고객님의 인증번호는 [ "+certifiNum+" ] 입니다.";
	Config.receiver = phone;
	
	session.setAttribute("certifiNum", certifiNum);
	//request.setAttribute("certifiNum", certifiNum);
	System.out.println(certifiNum);
	// 여기서 실제로 sms를 보낸다.
	
	SendSMS sms = new SendSMS();
	SendSMS.sendingSMS();
	
	out.println(res);
	out.println(certifiNum);

%>