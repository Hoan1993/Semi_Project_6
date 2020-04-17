package com.sist.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.model.FavoriteDAO;
import com.sist.model.FavoriteVO;

public class FavCheckAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		FavoriteVO vo = new FavoriteVO();
		vo.setArticle_no(Integer.parseInt(request.getParameter("no")));
		vo.setMem_email(request.getParameter("email"));

		FavoriteDAO dao = FavoriteDAO.getInstance();
		int result = dao.favoriteChk(vo);
		System.out.println("result : "+result);
		PrintWriter out = response.getWriter();
		if(result == 0) {
			out.println(result);
		}else if (result != 0) {
			out.println(result);
		}

		return null;
	}
}
