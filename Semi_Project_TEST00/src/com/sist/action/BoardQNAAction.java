package com.sist.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.model.QNADao;
import com.sist.model.QNAVO;

public class BoardQNAAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
	
		int rowsize=10;
		int block=3;
		int totalRecord=0;
		int allPage=0;
		int page=1;
		
		if(request.getParameter("page")!=null) {
			page=Integer.parseInt(request.getParameter("page"));
		}
		
		
		int startNo = (page*rowsize)-(rowsize-1);
		int endNo = (page*rowsize);
		
		int startBlock=(((page-1)/block)*block)+1;
		int endBlock=(((page-1)/block)*block)+block;
		
		QNADao qDao = QNADao.getInstance();
		totalRecord = qDao.searchQNACount();
			
		allPage = (int)Math.ceil(totalRecord/(double)rowsize);
		
		if(endBlock > allPage) {
			endBlock=allPage;
		}
		
		List<QNAVO> list = qDao.searchQNAByPage(page, rowsize);
		
		
		
		request.setAttribute("page", page);
		request.setAttribute("rowsize", rowsize);
		request.setAttribute("block", block);
		request.setAttribute("totalRecord", totalRecord);
		request.setAttribute("allPage", allPage);
		request.setAttribute("startNo", startNo);
		request.setAttribute("endNo", endNo);
		request.setAttribute("startBlock", startBlock);
		request.setAttribute("endBlock", endBlock);
		request.setAttribute("list", list);
		
		
		String url = "board_QNAForm.do";
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath(url);
		return forward;
	}

}
