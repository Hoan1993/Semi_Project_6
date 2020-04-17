package com.sist.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.model.FavoriteDAO;
import com.sist.model.FavoriteVO;

public class FavWriteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		FavoriteVO vo = new FavoriteVO();
		vo.setArticle_no(Integer.parseInt(request.getParameter("no")));
		vo.setMem_email(request.getParameter("email"));
		vo.setArticle_title(request.getParameter("title"));
		
		FavoriteDAO dao = FavoriteDAO.getInstance();
		int result = dao.favoriteNew(vo);
		PrintWriter out = response.getWriter();
		out.println(result);
		
		return null;
	}
}