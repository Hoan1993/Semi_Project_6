package com.sist.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.model.ArticleDAO;
import com.sist.model.ArticleVO;

public class SearchMineAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String article_writer = request.getParameter("writer");
	
		System.out.println("++++"+article_writer+"++++");
		
		
		int rowsize=4;
		int block=3;
		int totalRecord=0;
		int allPage=0;
		int page=1;
		
		if(request.getParameter("page")!=null) {
			page=Integer.parseInt(request.getParameter("page"));
		}
		
		System.out.println("++++"+article_writer+"++++"+page);
		
		int startNo = (page*rowsize)-(rowsize-1);
		int endNo = (page*rowsize);
		
		int startBlock=(((page-1)/block)*block)+1;
		int endBlock=(((page-1)/block)*block)+block;
		
		ArticleDAO dao = ArticleDAO.getInstance();
		totalRecord = dao.searchMyArticleCount(article_writer);
		
		allPage = (int)Math.ceil(totalRecord/(double)rowsize);
		
		if(endBlock > allPage) {
			endBlock=allPage;
		}
		
		List<ArticleVO> list = dao.searchArticleMyList(article_writer, page, rowsize);
		
		request.setAttribute("page", page);
		request.setAttribute("rowsize", rowsize);
		request.setAttribute("block", block);
		request.setAttribute("totalRecord", totalRecord);
		request.setAttribute("allPage", allPage);
		request.setAttribute("startNo", startNo);
		request.setAttribute("endNo", endNo);
		request.setAttribute("startBlock", startBlock);
		request.setAttribute("endBlock", endBlock);
		request.setAttribute("article_writer", article_writer);
		request.setAttribute("searchList", list);
		
		
		System.out.println("++++"+article_writer+"++++"+page);
		
		String url = "board_myArticleSearch.do";
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath(url);
		return forward;
	}

}
