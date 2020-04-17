package com.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.model.MemberVO;

public class memberSuzungAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String article_writer = request.getParameter("writer");
		
		request.setAttribute("writer", article_writer);
		
		
/*		HttpSession session = request.getSession();
		MemberVO mVo = (MemberVO) session.getAttribute("loginUser");*/
		
		
		ActionForward forward = new ActionForward();
		String url="member_suzungOk.do";
		
		forward.setRedirect(false);
		forward.setPath(url);
		
/*		if(mVo.getMem_pwd() == null) {
			request.setAttribute("email", mVo.getMem_email());
			url = "board_pro.do";
			
			forward.setRedirect(false);
			forward.setPath(url);
		
		}*/
		
		
		
		return forward;
	}

}
