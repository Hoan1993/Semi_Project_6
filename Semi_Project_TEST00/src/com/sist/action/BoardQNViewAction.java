package com.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.model.QNADao;
import com.sist.model.QNAVO;

public class BoardQNViewAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		String num_1 = request.getParameter("num");
		int num = Integer.parseInt(num_1);
				
				
		QNADao qDao = QNADao.getInstance();
		qDao.updateCount(num);
		
	
		QNAVO qVo = qDao.selectOneRecordByNum(num);
		
		
		request.setAttribute("board", qVo);
		
		ActionForward forward = new ActionForward();
		
		//String url = "./ServiceCenter/QNADetail.jsp";
		String url = "./ServiceCenter/QNADetail.jsp";
		
		
		forward.setPath(url);
		forward.setRedirect(false);
		
		return forward;
	}

}
