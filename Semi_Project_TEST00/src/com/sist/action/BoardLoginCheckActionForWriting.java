package com.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BoardLoginCheckActionForWriting implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		HttpSession session = request.getSession();
		
		ActionForward forward = new ActionForward();
		String url = "";
		// 로그인이 안 되어 있으면, 로그인 폼으로
		
		if(session.getAttribute("loginUser") == null) {
			url = "board_loginForm.do";
			forward.setPath(url);
			forward.setRedirect(false);	
		} else {
			url = "board_writeForm.do";
			forward.setPath(url);
			forward.setRedirect(false);
		}
		
		return forward;
	}

}
