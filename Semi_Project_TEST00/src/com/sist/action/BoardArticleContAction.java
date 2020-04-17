package com.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.model.ArticleDAO;
import com.sist.model.ArticleVO;

public class BoardArticleContAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
	
		ArticleDAO aDao = ArticleDAO.getInstance();
		
		
		
		// 그냥 테스트 용도로 번호가 1인 것을 추가함.
		ArticleVO aVo = aDao.selectOneArticleByNum(3);
		
		request.setAttribute("aVo", aVo);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./board/board_contTest.jsp");
		
		
		return forward;
	}

}
