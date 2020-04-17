package com.sist.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.model.MemberVO;
import com.sist.model.QNADao;
import com.sist.model.QNAVO;

public class BoardQNAUpdateOkAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		QNAVO qVo = new QNAVO();
		
		HttpSession session = request.getSession();
		MemberVO mVo = (MemberVO) session.getAttribute("loginUser");
		
		String email = mVo.getMem_email();
		
		qVo.setEmail(email);
		qVo.setTitle(request.getParameter("title"));
		qVo.setContent(request.getParameter("content"));
		qVo.setNum(Integer.parseInt(request.getParameter("num")));
		
		QNADao qDao = QNADao.getInstance();
		qDao.updateBoard(qVo);
		
		/*
		 * ActionForward forward = new ActionForward(); forward.setPath("boardQNA.do");
		 * forward.setRedirect(true);
		 */
		
		PrintWriter out = response.getWriter();
		String str = "";
		str = "<script>";
		str += "opener.window.location.reload();";
		str += "self.close();";
		str += "</script>";
		out.print(str);
		
		
		
		return null;
	}

}
