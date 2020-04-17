package com.sist.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.model.FavoriteDAO;

public class FavDelAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		FavoriteDAO dao = FavoriteDAO.getInstance();
		int result = dao.favoriteDel(Integer.parseInt(request.getParameter("no")));
		
		String message = "스크랩 삭제 실패";
		
		if(result>0) {
			message = "스크랩 삭제 성공";
		}
		
		PrintWriter out = response.getWriter();
		out.print(message);
		
		return null;
		}
}
