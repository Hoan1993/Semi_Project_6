package com.sist.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.model.ArticleDAO;
import com.sist.model.ArticleVO;

public class ArticleSideAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		ArticleDAO dao = ArticleDAO.getInstance();
		
		List<ArticleVO> list = dao.articleSide();
		request.setAttribute("List", list);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./include/sidebar.jsp");
		System.out.println("list 사이즈 : "+list.size());
		return forward;
	}

}
