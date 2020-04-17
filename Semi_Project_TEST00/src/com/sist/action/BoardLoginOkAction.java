package com.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.model.MemberDAO;
import com.sist.model.MemberVO;



public class BoardLoginOkAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String url = "board_loginForm.do";
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");

		
		
		MemberDAO mDao = MemberDAO.getInstance();
		MemberVO mVo = null;

		int result = mDao.loginProcess(id, pwd);
		
		//request.setAttribute("result", result);
		if(result == 1) {
			HttpSession session = request.getSession();
			mVo = new MemberVO();
			mVo = mDao.getMember(id);
			session.setAttribute("loginUser", mVo);
			request.setAttribute("message", "로그인 성공");
			request.setAttribute("mVo", mVo);
			url = "board_mainStart.do";
		} else {
			request.setAttribute("message", "로그인에 실패했습니다.");
		}
		
	
	/*	String path = "board_.do";
		
		if(result == 1) {
			path = "board_list.do";
		}*/
		// viewPage로 포워딩
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		forward.setPath(url);
		
		return forward;
	}
	
}
