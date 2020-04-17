package com.sist.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.model.MemberDAO;
import com.sist.model.MemberVO;


public class BoardJoinOkAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		String url = "board_joinForm.do";
		HttpSession session = request.getSession();
	    String certifiNum = (String) session.getAttribute("certifiNum");
		//String certifiNum = request.getParameter("certifiNum");
		String certifiNumAnswer = request.getParameter("certifiNumAnswer");
		
		System.out.println(certifiNum+", "+certifiNumAnswer);
		
		String mem_email = request.getParameter("email");
		String mem_pwd = request.getParameter("password");
		String mem_name = request.getParameter("Username");
		int mem_phone = Integer.parseInt(request.getParameter("phone"));
		
		MemberVO vo = new MemberVO();
		
		vo.setMem_email(mem_email);
		vo.setMem_pwd(mem_pwd);
		vo.setMem_name(mem_name);
		vo.setMem_phone(mem_phone);

		
		MemberDAO dao = MemberDAO.getInstance();
		int result = dao.insertMember(vo);
		
		ActionForward forward = new ActionForward();
		
		if(!certifiNum.equals(certifiNumAnswer)) {
			result = -1;
		}
		
		if(result == 1) {
			url = "board_loginForm.do";
			forward.setRedirect(true);
			forward.setPath(url);
		} else if(result == -1) {
			System.out.println("인증번호 잘못 입력함");
			dao.deleteMember(vo.getMem_email());
			url = "board_joinForm.do";
			forward.setRedirect(true);
			forward.setPath(url);
			
		} else {
			url = "board_joinForm.do";
			forward.setRedirect(true);
			forward.setPath(url);
		}
		
		
		session.removeAttribute("certifiNum");

		return forward;
	}

}
