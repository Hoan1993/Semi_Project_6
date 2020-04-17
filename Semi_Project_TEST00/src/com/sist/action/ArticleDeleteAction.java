package com.sist.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.model.ArticleDAO;

public class ArticleDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		int article_no = Integer.parseInt(request.getParameter("no"));
		String article_writer = request.getParameter("writer");
		
		ArticleDAO aao = ArticleDAO.getInstance();
		int res = aao.articleDelete(article_no);
		
		PrintWriter out = response.getWriter();
		
		ActionForward forward = new ActionForward();
		
		
		if(res>0) {
			out.println("<script>");
			out.println("alert('기사 삭제 성공')");
			out.println("</script>");
			String url="board_pro.do?email="+article_writer;
			/*http://localhost:8282/Project_Template01/board_pro.do?email=${user.mem_email}
*/			forward.setRedirect(false);
			forward.setPath(url);
		}else {
			out.println("<script>");
			out.println("alert('기사 삭제 실패')");
			out.println("history.back()");
			out.println("</script>");
		}
		
		
		return forward;
	}

}
