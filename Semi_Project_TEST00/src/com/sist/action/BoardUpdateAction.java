package com.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.model.ArticleDAO;
import com.sist.model.ArticleVO;
import com.sist.model.MemberVO;

public class BoardUpdateAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		
		String article_writer = request.getParameter("writer");
		String article_no = request.getParameter("no");
		
		int article_no1 = Integer.parseInt(article_no);

		System.out.println(article_writer+" "+article_no);
		
		HttpSession session = request.getSession();
		
		MemberVO mVo = null;
		ActionForward forward = new ActionForward();
		String url = "";
		
		ArticleVO aVo = null;
		
		if((MemberVO) session.getAttribute("loginUser") == null) {
			url = "article.do?no="+article_no;
			forward.setPath(url);
			forward.setRedirect(true);
		} else {
			mVo = (MemberVO) session.getAttribute("loginUser");
		}
		
		
		if(mVo == null || !mVo.getMem_email().equals(article_writer)) {
			url = "article.do?no="+article_no;
			/*request.setAttribute("no", article_no);*/
			forward.setPath(url);
			forward.setRedirect(true);
			// article_no을 통해 기사를 가져옴
		} else {
			url = "board_writeUpdateForm.do";
			
			forward.setPath(url);
			forward.setRedirect(false);
			
			ArticleDAO aDao = ArticleDAO.getInstance();
			aVo = new ArticleVO();
			aVo = aDao.getArticleByNum(article_no1);
			request.setAttribute("aVo", aVo);
		}
		
		return forward;
	}

}
