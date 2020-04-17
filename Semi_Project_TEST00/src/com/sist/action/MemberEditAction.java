package com.sist.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.model.ArticleDAO;
import com.sist.model.ArticleVO;
import com.sist.model.MemberDAO;
import com.sist.model.MemberVO;

public class MemberEditAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String article_writer=request.getParameter("writer");
		String mem_pwd=request.getParameter("pwd").trim();
		
		System.out.println("이메일"+article_writer);
		System.out.println("비밀번호"+mem_pwd);

		System.out.println("여기까지 했어요!!");
		
		MemberDAO mao = MemberDAO.getInstance();
		
		MemberVO mVo = mao.getMemberPro(article_writer);
		
		int res = mao.okEdit2(article_writer, mem_pwd);
		
		
		ArticleDAO aao = ArticleDAO.getInstance();
		ArticleVO aVo = aao.getArticlePro(article_writer);
		
		ActionForward forward = new ActionForward();
		PrintWriter out = response.getWriter();
		
		if(res>0) {
			request.setAttribute("mPro", mVo);
			request.setAttribute("aPro", aVo);
			String url = "board_profileUpdate.do";
			forward.setRedirect(false);
			forward.setPath(url);
		}else {
			out.println("<script>");
			out.println("alert('비밀번호가 다릅니다.')");
			out.println("history.back()");
			out.println("</script>");
		}
		
		
		
		
		
		return forward;
		
	}

}
