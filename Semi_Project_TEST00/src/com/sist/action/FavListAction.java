package com.sist.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.model.FavoriteDAO;

public class FavListAction implements Action {

   @Override
   public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
		   throws IOException, ServletException {   
	// String domain =
	//	request.getParameter("domain").substring(0, 41)+"article.do?no=";
	
	FavoriteDAO dao = FavoriteDAO.getInstance();
	String list = dao.favoriteList(request.getParameter("email"));
	
	System.out.println("list : "+list);
	
	PrintWriter out = response.getWriter();
	out.print(list);
	return null;
	}
}
